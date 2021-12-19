
public final class Customer {
	
	int custID;
	String custName;
	int custZIP;
	int badCodes;
	double tax;
	DatabaseRequestHandler dbrh;
	
	public Customer(int ID, String name, int zip, int codes, double tax, DatabaseRequestHandler dbrh) {
		this.custID = ID;
		this.custName = name;
		this.custZIP = zip;
		this.badCodes = codes;
		this.tax = tax;
		this.dbrh = dbrh;
	}

	public Customer(DBCustomer dbCustomer, DatabaseRequestHandler dbrh) {
		this.custID = dbCustomer.getCustID();
		this.custName = dbCustomer.getCustName();
		this.custZIP = dbCustomer.getCustZIP();
		this.badCodes = dbCustomer.getBadCodes();
		this.tax = dbCustomer.getTax();
		this.dbrh = dbrh;
	}

	public int getCustID() throws Exception {
		return dbrh.fetchCustomerData(custID).getCustID();
	}

	public String getCustName() throws Exception {
		return dbrh.fetchCustomerData(custID).getCustName();
	}

	public int getCustZIP() throws Exception {
		return dbrh.fetchCustomerData(custID).getCustZIP();
	}

	public int getBadCodes() throws Exception {
		return dbrh.fetchCustomerData(custID).getBadCodes();
	}

	public double getTax() throws Exception {
		return dbrh.fetchCustomerData(custID).getTax();
	}
	
	public int addBadCode() throws Exception {
		return dbrh.fetchCustomerData(custID).addBadCode();
	}
	

}
