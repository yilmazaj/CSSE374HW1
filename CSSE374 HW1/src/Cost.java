import java.util.ArrayList;

public final class Cost {
	
	// the cost of an entire entry after discounts
	public static double totalDiscountItemCost(double curCost, double discountVal) {
		return curCost * (1 - discountVal);
	}
	
	// the cost of an entire entry (itemdata, quantity)
	public static double totalItemCost(ItemData item, int quantity) throws Exception {
		return item.getPrice() * quantity;
	}
	// the cost of an entire cart (cart)
	public static double totalCartCost(Cart cart) throws Exception {
		double total = 0;
		DatabaseRequestHandler dbrh = cart.getDBRH();
		for(int i = 0; i < cart.getItemIDs().size(); i++) {
			// get current item cost (item and quantity)
			ItemData curItem = new ItemData(dbrh.fetchItemData(cart.getItemIDs().get(i)), dbrh);
			double tempItemCost = totalItemCost(curItem, cart.getQuantities().get(i));
			// check for possible discounts
			for(int n = 0; n < cart.getDiscounts().size(); n++) {
				// compare each discount's itemID to current item ID
				// apply discount if match
				if(cart.getDiscounts().get(n).getItemID() == curItem.getItemID()) {
					tempItemCost = totalDiscountItemCost(tempItemCost, cart.getDiscounts().get(n).discountVal);
				}
			}
			total += tempItemCost;
		}
		return total;
		
	}
	// the cost of an entire cart after tax (cart, customer)
	public static double totalAfterTax(Cart cart, Customer customer) throws Exception {
		return totalCartCost(cart) + customer.getTax();
	}

}
