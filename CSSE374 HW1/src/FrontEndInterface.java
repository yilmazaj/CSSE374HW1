import java.util.ArrayList;

public class FrontEndInterface {

	private RequestHandler rh;

	public static void main(String[] args) {
		RequestHandler rh = new RequestHandler();
	}

	enum Request {
		VIEW_CART, ADD_ITEM_TO_CART, REMOVE_ITEM_FROM_CART, UPDATE_ITEM_IN_CART, ADD_DISCOUNT_CODE, CHECKOUT
	}

	public ArrayList<String> handleRequest(Request req, String[] args) throws Exception {
		ArrayList<String> returnVal = new ArrayList<String>();
		switch (req) {
			case VIEW_CART:
				returnVal.addAll(this.rh.viewCart());
				break;
				
			case ADD_ITEM_TO_CART:
				if(args.length != 2) {
					returnVal.add("Invalid arguments");
					break;
				}
				Integer itemID = Integer.getInteger(args[0]);
				Integer quantity = Integer.getInteger(args[1]);
				try {
					if (rh.addItemToCart(itemID, quantity)) {
						returnVal.add("Item Added");
						break;
					} 
				} catch (Exception e) {
						returnVal.add(e.getMessage());
						break;
				}
				break;
				
			case REMOVE_ITEM_FROM_CART:
				if(args.length != 2) {
					returnVal.add("Invalid arguments");
					break;
				}
				Integer itemID2 = Integer.getInteger(args[0]);
				Integer quantity2 = Integer.getInteger(args[1]);
				try {
					if (rh.addItemToCart(itemID2, quantity2)) {
						returnVal.add("Item Removed");
						break;
					} 
				} catch (Exception e) {
						returnVal.add(e.getMessage());
						break;
				}
				break;
				
			case ADD_DISCOUNT_CODE:
				if(args.length != 1) {
					returnVal.add("Invalid arguments");
					break;
				}
				Integer discID = Integer.getInteger(args[0]);
				if(discID < 1) {
					returnVal.add("Invalid DiscountID");
					break;
				}
				try {
					if (rh.addDiscountCode(discID)) {
						returnVal.add("Discount Code Added");
						break;
					} 
				} catch (Exception e) {
						returnVal.add(e.getMessage());
						break;
				}
				break;
				
			
			case CHECKOUT:
				if(args.length != 0) {
					returnVal.add("Invalid arguments");
					break;
				}
				try {
					rh.checkout();
				} catch (Exception e) {
					returnVal.add(e.getMessage());
					break;
				}
				break;
				
			default:
				returnVal.add("Invalid Action");
				break;
		}

	return returnVal;

}

}
