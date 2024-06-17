package myproj3;
import java.util.HashMap;
import java.util.Map;

public class AtmOperationImp implements AtmOperations {
	atmInterface Atm = new atmInterface();
	HashMap<Double, String> miniStatement = new HashMap<>();

	@Override
	public void ViewBalance() {
		System.out.println("Available Balance is: " + Atm.getBalance());
	}

	@Override
	public void withdrawAmount(double withdrawAmount) {

		if (withdrawAmount % 500 == 0) {
			if (withdrawAmount <= Atm.getBalance()) {
				miniStatement.put(withdrawAmount, " Amount Withdrawn");
				System.out.println("Collect the Cash: " + withdrawAmount);
				Atm.setBalance(Atm.getBalance() - withdrawAmount);
				ViewBalance();
			} else
				System.out.println("Insufficient Balance!!");
		} else
			System.out.println("Enter the Amount in multiple of 500");
	}

	@Override
	public void depositAmount(double depositAmount) {
		miniStatement.put(depositAmount, " Amount Deposited");
		System.out.println(depositAmount + " Deposited Successfully!!");
		Atm.setBalance(Atm.getBalance() + depositAmount);
		ViewBalance();
	}

	@Override
	public void viewMiniStatement() {
		for (Map.Entry<Double, String> m : miniStatement.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

	}

	@Override
	public void transferAmount(double accountNumber, double transferAmount) {
		if (transferAmount <= Atm.getBalance()) {
			String x = String.format("%d", (int) accountNumber);
			miniStatement.put(transferAmount, " Amount Transferred to Account " + x);
			System.out.println("Amount Transferred Successfully!!");
			Atm.setBalance(Atm.getBalance() - transferAmount);
			ViewBalance();
		} else {
			System.out.println("Insufficient Balance!!");
		}
	}

}
