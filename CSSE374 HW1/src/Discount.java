
public class Discount {
	
	int discountID;
	double discountVal;
	int itemID;
	DatabaseRequestHandler dbrh;
	
	public Discount(int ID, double val, int item, DatabaseRequestHandler dbrh) {
		this.discountID = ID;
		this.discountVal = val;
		this.itemID = item;
		this.dbrh = dbrh;
	}
	
	public Discount(DBDiscount dbDiscount, DatabaseRequestHandler dbrh) {
		this.discountID = dbDiscount.getDiscountID();
		this.discountVal = dbDiscount.getDiscountVal();
		this.itemID = dbDiscount.getItemID();
		this.dbrh = dbrh;
	}

	public boolean isValid() {
		try {
			dbrh.fetchDiscountData(discountID);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int getDiscountID() throws Exception {
		return dbrh.fetchDiscountData(discountID).getDiscountID();
	}

	public double getDiscountVal() throws Exception {
		return dbrh.fetchDiscountData(discountID).getDiscountVal();
	}

	public int getItemID() throws Exception {
		return dbrh.fetchDiscountData(discountID).getItemID();
	}

	
}
