
public class TestAccount {

	/** Main method */
	public static void main(String[] args) {
		//Create a new Account, the ID needs to be 1122, Opening balance of $20,000, Annual Interest Rate of 4.5%
		Account newAccount = new Account();
		
		newAccount.setId(1122);
		newAccount.setBalance(20000);
		newAccount.setAnnualInterestRate(.045);
		
		//Make a withdrawal for $2,500
		newAccount.setWithdrawal(2500, newAccount.getBalance());
		
		//Make a deposit for $3,000
		newAccount.setDeposit(3000, newAccount.getBalance());
		
		System.out.println();
		System.out.println(newAccount.toString());
		
		
	}

}
