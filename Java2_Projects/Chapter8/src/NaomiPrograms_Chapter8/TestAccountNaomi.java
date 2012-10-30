package NaomiPrograms_Chapter8;


public class TestAccountNaomi {

	public static void main(String[] args) {
		AccountNaomi myAccount = new AccountNaomi(1122, 20000.00);
		myAccount.setAnnualInterestRate(0.045);
		System.out.println("Opening Account balance: " + myAccount.getBalance() + "\n");
		myAccount.withdrawal(2500.00);
		System.out.println("Balance after 2500.00 withdrawal: " + myAccount.getBalance() + "\n");
		myAccount.deposit(3000.00);
		System.out.println("Balance after 3000.00 deposit: " + myAccount.getBalance() + "\n");
		System.out.println(myAccount.toString());
	}

}
