package myproj3;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		AtmOperations op = new AtmOperations();
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int AccountNumber = rand.nextInt(1000000000) + 1;
		int PinNumber = rand.nextInt(10000) + 1;
		System.out.println("Your Account Numbers is: " + AccountNumber);
		System.out.println("Your Pin Numbers is: " + PinNumber);
		System.out.println("Welcome to ATM Machine");
		System.out.print("Enter Atm Number: ");
		int atmNumber = sc.nextInt();
		System.out.print("Enter Atm Pin: ");
		int atmPin = sc.nextInt();
		if (((atmNumber == AccountNumber) && (atmPin == PinNumber))) {
			while (true) {
				System.out.println(
						"\n1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.Transfer Amount\n5.View Mini Statement \n6.Exit ATM");
				System.out.println("Enter Choice: ");
				int ch = sc.nextInt();
				if (ch >= 1 && ch <= 5) {
					switch (ch) {
					case 1:
						op.ViewBalance();
						break;
					case 2:
						System.out.print("Enter the Amount in multiple of 500: ");
						double WithdrawAmount = sc.nextDouble();
						op.withdrawAmount(WithdrawAmount);
						break;
					case 3:
						System.out.print("Enter Amount to Deposit: ");
						double depositedAmount = sc.nextDouble();
						op.depositAmount(depositedAmount);
						break;
					case 4:
						System.out.println("Enter Account Number to Transfer: ");
						int accNumber = sc.nextInt();
						System.out.println("Enter Amount to transfer: ");
						double amttransfer = sc.nextDouble();
						op.transferAmount(accNumber, amttransfer);
						break;
					case 5:
						op.viewMiniStatement();
						break;
					case 6:
						System.out.println("Thankyou for using ATM Machine");
						System.exit(0);
						break;
					}
				} else {
					System.out.println("Enter Correct choice!");
				}
			}
		} else {
			System.out.println("Incorrect ATM Number or ATM Pin");
		}
	}

}
