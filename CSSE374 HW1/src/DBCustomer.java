
public class DBCustomer {
	
	private int custID;
	private String custName;
	private int custZIP;
	private int badCodes;
	private double tax;
	
	public DBCustomer(int ID, String name, int zip, int codes, double tax) {
		this.custID = ID;
		this.custName = name;
		this.custZIP = zip;
		this.badCodes = codes;
		this.tax = tax;
	}

	public int getCustID() {
		return custID;
	}

	public String getCustName() {
		return custName;
	}

	public int getCustZIP() {
		return custZIP;
	}

	public int getBadCodes() {
		return badCodes;
	}

	public double getTax() {
		return tax;
	}
	
	public void addBadCode() {
		this.badCodes++;
	}
	
	
}
