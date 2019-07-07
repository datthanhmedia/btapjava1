package thuake;

public interface ATM1 {
	public boolean withdraw(int accNo, double money);
	public boolean deposit(int accNo, double money);
	public double queryBalance(int accNo);
}
