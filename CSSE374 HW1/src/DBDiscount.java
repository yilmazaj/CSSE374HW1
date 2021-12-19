
public class DBDiscount {
	
	private int discountID;
	private double discountVal;
	private int itemID;
	
	public DBDiscount(int ID, double val, int item) {
		this.discountID = ID;
		this.discountVal = val;
		this.itemID = item;
	}

	public int getDiscountID() {
		return discountID;
	}

	public double getDiscountVal() {
		return discountVal;
	}

	public int getItemID() {
		return itemID;
	}
	
	

}
