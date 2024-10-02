import java.rmi.*;
import java.util.Scanner;

public class BankClient {
    public static void main(String[] args) {
        try {
            BankInterface bank = (BankInterface) Naming.lookup("//localhost/BankService");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your account number: ");
            String accountNumber = scanner.nextLine();
            System.out.println("Choose an operation: balance / deposit / withdraw");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("balance")) {
                System.out.println("Your balance is: " + bank.checkBalance(accountNumber));
            } else if (command.equalsIgnoreCase("deposit")) {
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                bank.deposit(accountNumber, amount);
                System.out.println("Deposited successfully. Your new balance is: " + bank.checkBalance(accountNumber));
            } else if (command.equalsIgnoreCase("withdraw")) {
                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();
                if (bank.withdraw(accountNumber, amount)) {
                    System.out.println("Withdrawn successfully. Your new balance is: " + bank.checkBalance(accountNumber));
                } else {
                    System.out.println("Insufficient funds.");
                }
            } else {
                System.out.println("Invalid command.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
