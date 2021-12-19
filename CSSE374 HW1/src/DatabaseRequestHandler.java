import java.util.ArrayList;

public class DatabaseRequestHandler {
	
	private Database db;

	public DatabaseRequestHandler() {
		this.db = new Database(this);
	}
	
	public Customer fetchCustomerData(int custID) throws Exception {
		return new Customer(db.getCustomer(custID), this);
	}
	
	public DBCart fetchCart(int custID) throws Exception{
		return db.getCart(custID);
	}
	
	public DBItem fetchItemData(int itemID) throws Exception{
		return db.getItem(itemID);
	}
	
	public DBDiscount fetchDiscountData(int discountID) throws Exception{
		return db.getDiscount(discountID);
	}
	
	public boolean addToCart(int custID, int itemID, int quantity) throws Exception {
		return db.addToCart(custID, itemID, quantity);
	}
	
	public boolean removeFromCart(int custID, int ItemID, int quantity) throws Exception {
		return db.removeFromCart(custID, ItemID, quantity);
	}
	
	public void checkout(int custID) throws Exception {
		db.checkout(custID);
	}
	
	public boolean addDiscountCode(int custID, int discountID) throws Exception {
		DBDiscount discount = db.getDiscount(discountID);
		return db.addDiscount(custID, discount);
	}
	
	public int badCode(int custID) throws Exception {
		DBCustomer cust = db.getCustomer(custID);
		return db.badCode(custID);
	}
	
	public int getNumBadCodes(int custID) throws Exception {
		DBCustomer cust = db.getCustomer(custID);
		return db.getNumBadCodes(custID);
	}
	
}
