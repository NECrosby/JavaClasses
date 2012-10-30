import java.util.Date;


public class Account {
	//Data fields of Account class
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private java.util.Date dateCreated;

	//no argument constructor
	Account(){

	}

	//Constructor with specific ID, Balance
	Account(int _id, double _balance){
		id = _id;
		balance = _balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@Override
	public String toString() {
		return "The new account number " + id + ", now has a balance of " + balance
				+ ". \rThe monthly interest rate is " + getMonthlyInterestRate(annualInterestRate) + ". \rThis account was created on " + getDateCreated() + ".";
	}

	// Monthly interest rate is equal to annual divided by 12
	public double getMonthlyInterestRate(double annualInterestRate) {
		double monthlyInterestRate = annualInterestRate / 12;
		return monthlyInterestRate;
	}
	
	// Withdrawal function
	public double setWithdrawal(double newWithdrawal, double balance){
		double withdrawal = newWithdrawal;
		balance = balance - withdrawal;
		this.setBalance(balance);
		return balance;		
	}
	
	//Deposit function
	public double setDeposit(double newDeposit, double balance){
		double deposit = newDeposit;
		balance = deposit + balance;
		this.setBalance(balance);
		return balance;		
	}

}

