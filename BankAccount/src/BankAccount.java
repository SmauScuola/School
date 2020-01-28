public class BankAccount {
	private float Balance;
	private String LastTransaction;
	public final int NormalBalance = 300;

	public BankAccount() {
		Balance = 0;
		LastTransaction = "";
	}

	public BankAccount(float InitialBalance) {
		Balance = 0;
		LastTransaction = "";
	}

	public float getBalance() {
		return Balance;
	}

	public void Taking(float value) {
		Balance -= value;
		LastTransaction = "You taken $" + value;
	}

	public void Deposits(float value) {
		Balance += value;
		LastTransaction = "You have deposited $" + value;
	}

	public String getLastTransaction() {
		return LastTransaction;
	}
	
	public boolean HaveDebts()
	{
		return Balance < NormalBalance;
	}
}
