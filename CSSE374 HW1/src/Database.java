import java.util.ArrayList;

public class Database {
	
	private ArrayList<DBCustomer> customers;
	private ArrayList<DBItem> items;
	private ArrayList<DBDiscount> discounts;
	private ArrayList<DBCart> carts;
	private DatabaseRequestHandler dbrh;
	
	public Database(DatabaseRequestHandler dbrh) {
		initializeCustomers();
		initializeItems();
		initializeDiscounts();
		initializeCarts();
		this.dbrh = dbrh;
	}

	public ArrayList<DBCustomer> initializeCustomers(){
		this.customers = new ArrayList<DBCustomer>();
		customers.add(new DBCustomer(1, "Stacy", 92130, 0, 0.0725));
		customers.add(new DBCustomer(2, "Adam", 47804, 0, 0.07));
		return customers;
	}
	
	public ArrayList<DBItem> initializeItems(){
		this.items = new ArrayList<DBItem>();
		items.add(new DBItem(1, "Orange", "A fruit that is orange", "orange.jpg", 0.10, 8));
		items.add(new DBItem(2, "Apple", "A fruit that growns on apple trees", "apple.jpg", 0.15, 9));
		items.add(new DBItem(3, "Xbox Series X", "A gaming console with an X in the name", "xboxseriesx.jpg", 499.99, 1));
		items.add(new DBItem(4, "Bean Bag Chair", "A chair that's a bag of beans", "beanbagchair.jpg", 1.00, 2));
		items.add(new DBItem(5, "Hammer", "A tool to put nails into things", "hammer.jpg", 5.00, 3));
		items.add(new DBItem (6, "Cup", "Something to hold liquid", "cup.jpg", 6.00, 4));
		items.add(new DBItem(7, "Piano", "An instrument with keys", "piano.jpg", 300.00, 5));
		return items;
	}
	
	public ArrayList<DBDiscount> initializeDiscounts(){
		this.discounts = new ArrayList<DBDiscount>();
		discounts.add(new DBDiscount(1, 0.05, 1));
		discounts.add(new DBDiscount(2, 0.45, 2));
		discounts.add(new DBDiscount(3, 0.26, 3));
		return discounts;
	}
	
	public ArrayList<DBCart> initializeCarts(){
		this.carts = new ArrayList<DBCart>();
		ArrayList<Integer> itemIDs1 = new ArrayList<Integer>();
		itemIDs1.add(1);
		itemIDs1.add(2);		
		ArrayList<Integer> itemIDs2 = new ArrayList<Integer>();
		itemIDs2.add(3);
		itemIDs2.add(4);
		itemIDs2.add(5);
		ArrayList<Integer> quant1 = new ArrayList<Integer>();
		quant1.add(1);
		quant1.add(4);
		ArrayList<Integer> quant2 = new ArrayList<Integer>();
		quant2.add(1);
		quant2.add(1);
		quant2.add(2);
		ArrayList<DBDiscount> disc1 = new ArrayList<DBDiscount>();
		disc1.add(discounts.get(0));
		disc1.add(discounts.get(1));
		ArrayList<DBDiscount> disc2 = new ArrayList<DBDiscount>();
		disc2.add(discounts.get(2));
		carts.add(new DBCart(itemIDs1, quant1, disc1, 1));
		carts.add(new DBCart(itemIDs2, quant2, disc2, 2));
		return carts;
	}

	public DBCustomer getCustomer(int customerID) throws Exception {
		for(int i = 0; i < customers.size(); i++) {
			if(customers.get(i).getCustID() == customerID) {
				return customers.get(i);
			}
		}
		throw new Exception("Invalid Customer ID");
	}

	public DBItem getItem(int itemID) throws Exception {
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getItemID() == itemID) {
				return items.get(i);
			}
		}
		throw new Exception("Invalid Item ID");
	}

	public DBDiscount getDiscount(int discountID) throws Exception {
		for(int i = 0; i < discounts.size(); i++) {
			if(discounts.get(i).getDiscountID() == discountID) {
				return discounts.get(i);
			}
		}
		throw new Exception("Invalid Discount");
	}

	public DBCart getCart(int custID) throws Exception {
		for(int i = 0; i < carts.size(); i++) {
			if(carts.get(i).getCustomerID() == custID) {
				return carts.get(i);
			}
		}
		throw new Exception("Invalid Cart");
	}
	
	// addToCart, removeFromCart, checkout, badCode, addDiscount
	
	public int badCode(int custID) throws Exception {
		DBCustomer cust = this.getCustomer(custID);
		return cust.getBadCodes() + 1;
	}
	
	public int getNumBadCodes(int custID) throws Exception{
		DBCustomer cust = this.getCustomer(custID);
		return cust.getBadCodes();
	}
	
	public boolean addToCart(int custID, int itemID, int quantity) throws Exception {
		DBCart cart = this.getCart(custID);
		return cart.addToCart(itemID, quantity);
	}
	
	public boolean removeFromCart(int custID, int itemID, int quantity) throws Exception {
		DBCart cart = this.getCart(custID);
		return cart.removeFromCart(itemID, quantity);
	}
	
	public boolean checkout(int custID) throws Exception {
		int index = -1;
		for(int i = 0; i < carts.size(); i++) {
			if(carts.get(i).getCustomerID() == custID) {
				carts.remove(i);
			}
		}
		if(index == -1) {
			throw new Exception("Failed to checkout");
		} else {
			throw new Exception("Succesful checkout");
		}
	}
	
	public boolean addDiscount(int custID, DBDiscount discount) throws Exception {
		DBCart cart = this.getCart(custID);
		return cart.addDiscountCode(discount);
	}
	
	
}
