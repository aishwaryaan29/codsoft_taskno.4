import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public String deposit(double amount) {
        balance += amount;
        return String.format("Deposited $%.2f. New balance: $%.2f", amount, balance);
    }

    public String withdraw(double amount) {
        if (amount > balance) {
            return "Insufficient funds";
        }
        balance -= amount;
        return String.format("Withdrew $%.2f. New balance: $%.2f", amount, balance);
    }

    public String checkBalance() {
        return String.format("Current balance: $%.2f", balance);
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public String withdraw(double amount) {
        return userAccount.withdraw(amount);
    }

    public String deposit(double amount) {
        return userAccount.deposit(amount);
    }

    public String checkBalance() {
        return userAccount.checkBalance();
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(1000);
        ATM atm = new ATM(userAccount);

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter choice (1/2/3/4): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline character
                    System.out.println(atm.withdraw(withdrawAmount));
                    break;

                case "2":
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline character
                    System.out.println(atm.deposit(depositAmount));
                    break;

                case "3":
                    System.out.println(atm.checkBalance());
                    break;

                case "4":
                    System.out.println("Exiting. Thank you!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
            }
        }
    }
}
