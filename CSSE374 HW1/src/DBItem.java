
public class DBItem {

	private int itemID;
	private String itemName;
	private String itemDesc;
	private String itemPic;
	private double itemPrice;
	private int itemStock;
	
	public DBItem(int ID, String name, String desc, String pic, double price, int stock) {
		this.itemID = ID;
		this.itemName = name;
		this.itemDesc = desc;
		this.itemPic = pic;
		this.itemPrice = price;
		this.itemStock = stock;
	}

	public int getItemID() {
		return itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public String getItemPic() {
		return itemPic;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public int getItemStock() {
		return itemStock;
	}
	
	
	
}
