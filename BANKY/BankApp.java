import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- BankY System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View Account");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accNum = scanner.next();
                    System.out.print("Enter account holder name: ");
                    scanner.nextLine(); // Consume newline
                    String name = scanner.nextLine();
                    bank.createAccount(accNum, name);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    accNum = scanner.next();
                    Account account = bank.getAccount(accNum);
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double amount = scanner.nextDouble();
                        account.deposit(amount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    accNum = scanner.next();
                    account = bank.getAccount(accNum);
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double amount = scanner.nextDouble();
                        account.withdraw(amount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter sender's account number: ");
                    String fromAcc = scanner.next();
                    System.out.print("Enter receiver's account number: ");
                    String toAcc = scanner.next();
                    System.out.print("Enter amount to transfer: ");
                    double amount = scanner.nextDouble();
                    bank.transfer(fromAcc, toAcc, amount);
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    accNum = scanner.next();
                    account = bank.getAccount(accNum);
                    if (account != null) {
                        System.out.println(account);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 6:
                    bank.saveAccounts();
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
