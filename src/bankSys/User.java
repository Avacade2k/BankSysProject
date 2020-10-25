package bankSys;

public class User {
	
	private String username;
	private String password;
	private String fname;
	private String lname;
	private String gender;
	private Double balance;
	
	public User(String username,String password) {
		this.username=username;
		this.password=password;
	}
	
	public User(String username, String password, String fname, String lname, String gender, Double balance) {
		this(username,password);
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.balance=0.00;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
		
	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getGender() {
		return gender;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public void setBalance(Double balance) {
		this.balance=balance;
	}

}
