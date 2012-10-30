package NaomiPrograms_Chapter8;

import java.util.Date;


public class AccountNaomi {

	private int id = 0;
	private double balance = 0.0;
	private double annualInterestRate = 0.0;
	private Date dateCreated = new Date();
	
	public AccountNaomi() {
		
	}
	
	public AccountNaomi(int newId, double newBalance) {
		id = newId;
		balance = newBalance;
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

	public Date getDateCreated() {
		return dateCreated;
	}
	
	public double getMonthlyInterestRate() {
		double monthlyInterestRateValue = 0.0;
		monthlyInterestRateValue = this.getAnnualInterestRate() / 12;
		return monthlyInterestRateValue;
	}
	
	public double withdrawal(Double newWithdrawal) {
		Double newBalance = 0.0;
		newBalance = this.getBalance() - newWithdrawal;
		this.setBalance(newBalance);
		return this.getBalance();
	}
	
	public double deposit(Double newDeposit) {
		Double newBalance = 0.0;
		newBalance = this.getBalance() + newDeposit;
		this.setBalance(newBalance);
		return this.getBalance();
	}

	@Override
	public String toString() {
		return "Account " + getId() + " has " + getBalance() + " currently. \n" +
				"The monthly Interest Rate on this account is " + getMonthlyInterestRate() + ". \n" + 
				"The account was created on " + getDateCreated() + ". \n";
	}
	
	
	
}
