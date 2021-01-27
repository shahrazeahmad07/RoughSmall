import java.util.Scanner;

public class AtmWithdraw {
    public static void main(String[] args) {
        int balance = 5000;
        int withdrawAmount = 0;
        char anotherTransaction = '0';
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Withdraw Amount: ");
            withdrawAmount = sc.nextInt();
            try {
                if (withdrawAmount > balance) {
                    throw new ArithmeticException("Insufficient Balance");
                }
                System.out.println("Transaction Successful");
                balance = balance - withdrawAmount;
            } catch (ArithmeticException e) {
                System.out.println("Error. " + e.getMessage());
            }
            System.out.println("Do you want another transaction?");
            anotherTransaction = sc.next().charAt(0);
        }while (anotherTransaction == 'y' || anotherTransaction == 'Y');
    }
}
