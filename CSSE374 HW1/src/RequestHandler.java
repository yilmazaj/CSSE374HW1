import java.util.ArrayList;

public class RequestHandler {
	
	private DatabaseRequestHandler dbrh;
	private Cart cart;
	private int customerID;

	public RequestHandler() {
		this.dbrh = new DatabaseRequestHandler();
		this.cart = null;
		this.customerID = -1;
	}
	
	public ArrayList<String> viewCart() throws Exception {
		ArrayList<String> returnVal = new ArrayList<String>();
		if (this.cart == null) {
			returnVal.add("Invalid Customer");
			return returnVal;
		}
		double total = Cost.totalAfterTax(cart, this.dbrh.fetchCustomerData(customerID));
		for (int i = 0; i < cart.getItemIDs().size(); i++) {
			DBItem item = this.dbrh.fetchItemData(cart.getItemIDs().get(i));
			returnVal.add(item.getItemName());
		}
		returnVal.add(Double.toString(total));
		return returnVal;
	}
	
	public boolean addItemToCart(int itemID, int quantity) throws Exception {
		DBItem item = this.dbrh.fetchItemData(itemID);
		this.cart.addToCart(itemID, quantity);
		return this.dbrh.addToCart(customerID, itemID, quantity);
	}
	
	public boolean removeItemFromCart(int itemID, int quantity) throws Exception {
		DBItem item = this.dbrh.fetchItemData(itemID);
		this.cart.removeFromCart(itemID, quantity);
		return this.dbrh.removeFromCart(customerID, itemID, quantity);
	}
	
	public boolean addDiscountCode(int discountID) throws Exception {
		if (this.dbrh.getNumBadCodes(this.customerID) >= 5) {
			throw new Exception("Discounts Locked for this account.");
		}
		DBDiscount discount = this.dbrh.fetchDiscountData(discountID);
		return this.cart.addDiscountCode(discountID);
	}
	
	public void checkout() throws Exception {
		this.dbrh.checkout(customerID);
	}
}
