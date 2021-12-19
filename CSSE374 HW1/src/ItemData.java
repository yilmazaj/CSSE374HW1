
public class ItemData {
	
	private int itemID;
	private String itemName;
	private String itemDesc;
	private String itemPic;
	private DatabaseRequestHandler dbrh;
	
	public ItemData(int ID, String name, String desc, String pic, DatabaseRequestHandler dbrh) {
		this.itemID = ID;
		this.itemName = name;
		this.itemDesc = desc;
		this.itemPic = pic;
		this.dbrh = dbrh;
	}
	
	public ItemData(DBItem dbItem, DatabaseRequestHandler dbrh) {
		this.itemID = dbItem.getItemID();
		this.itemName = dbItem.getItemName();
		this.itemDesc = dbItem.getItemDesc();
		this.itemPic = dbItem.getItemPic();
		this.dbrh = dbrh;
	}

	public double getPrice() throws Exception {
		return dbrh.fetchItemData(itemID).getItemPrice();
	}
	
	public int getStock() throws Exception {
		return dbrh.fetchItemData(itemID).getItemStock();
	}

	public int getItemID() throws Exception {
		return dbrh.fetchItemData(itemID).getItemID();
	}

	public String getItemName() throws Exception {
		return dbrh.fetchItemData(itemID).getItemName();
	}

	public String getItemDesc() throws Exception {
		return dbrh.fetchItemData(itemID).getItemDesc();
	}

	public String getItemPic() throws Exception {
		return dbrh.fetchItemData(itemID).getItemPic();
	}
	
	
}
