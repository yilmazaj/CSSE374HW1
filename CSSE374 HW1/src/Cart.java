import java.util.ArrayList;

public class Cart {

	private ArrayList<Integer> itemIDs;
	private ArrayList<Integer> quantities;
	private ArrayList<Discount> discounts;
	private Customer customer;
	private DatabaseRequestHandler dbrh;

	public Cart(ArrayList<Integer> items, ArrayList<Integer> quant, int custID, DatabaseRequestHandler dbrh) throws Exception {
		this.itemIDs = items;
		this.quantities = quant;
		this.dbrh = dbrh;
		this.customer = dbrh.fetchCustomerData(custID);
	}

	public Cart(DBCart dbCart, DatabaseRequestHandler dbrh) throws Exception {
		this.itemIDs = dbCart.getItemIDs();
		this.quantities = dbCart.getQuantities();
		this.customer = dbrh.fetchCustomerData(dbCart.getCustomerID());
		this.dbrh = dbrh;
	}

	public double getTotalCartCost() throws Exception {
		return Cost.totalAfterTax(this, customer);
	}
	
	public ArrayList<Integer> getItemIDs() throws Exception {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < itemIDs.size(); i++) {
			temp.add(dbrh.fetchItemData(itemIDs.get(i)).getItemID());
		}
		return temp;
	}

	public ArrayList<Integer> getQuantities() {
		return quantities;
	}

	public ArrayList<Discount> getDiscounts() {
		return discounts;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public DatabaseRequestHandler getDBRH() {
		return dbrh;
	}

	public void addToCart(int itemID, int quantity) {
		// checks if item is in cart already
		int indexOfItem = findIndexOfItem(itemID);
		if (indexOfItem == -1) {
			this.itemIDs.add(itemID);
			this.quantities.add(quantity);
		} else {
			int curQuant = this.quantities.get(indexOfItem);
			curQuant += quantity;
			this.quantities.set(itemID, curQuant);
		}
	}

	public void removeFromCart(int itemID, int quantity) throws Exception {
		int curQuant = this.quantities.get(itemID);
		if (curQuant - quantity < 0) {
			throw new Exception("Can not reduce quantity of item below 0");
		} else {
			curQuant -= quantity;
			this.quantities.set(itemID, curQuant);
		}
	}

	public boolean addDiscountCode(int discountID) throws Exception {
		Discount discount = new Discount(dbrh.fetchDiscountData(discountID), dbrh);
		discounts.add(discount);
		return true;
	}

	///////////////////////////////////// HELPER FUNCTIONS

	// Checks if item is in cart already or not
	public int findIndexOfItem(int itemID) {
		int indexOfItem = -1;
		for (int i = 0; i < itemIDs.size(); i++) {
			if (itemID == itemIDs.get(i)) {
				indexOfItem = i;
			}
		}
		return indexOfItem;
	}

}
