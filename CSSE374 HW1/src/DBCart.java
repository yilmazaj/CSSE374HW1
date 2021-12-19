import java.util.ArrayList;

public class DBCart {
	
	private ArrayList<Integer> itemIDs;
	private ArrayList<Integer> quantities;
	private ArrayList<DBDiscount> discounts;
	private int customerID;

	public DBCart(ArrayList<Integer> items, ArrayList<Integer> quant, ArrayList<DBDiscount> discounts, int custID) {
		this.itemIDs = items;
		this.quantities = quant;
		this.discounts = discounts;
		this.customerID = custID;
	}

	public ArrayList<Integer> getItemIDs() {
		return itemIDs;
	}

	public ArrayList<Integer> getQuantities() {
		return quantities;
	}

	public int getCustomerID() {
		return customerID;
	}

	public ArrayList<DBDiscount> getDiscounts() {
		return discounts;
	}
	
	public boolean addToCart(int itemID, int quantity) {
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
		return true;
	}

	public boolean removeFromCart(int itemID, int quantity) throws Exception {
		int curQuant = this.quantities.get(itemID);
		if (curQuant - quantity < 0) {
			throw new Exception("Can not reduce quantity of item below 0");
		} else {
			curQuant -= quantity;
			this.quantities.set(itemID, curQuant);
			return true;
		}
	}

	public boolean addDiscountCode(DBDiscount discount) throws Exception {
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
