import java.util.*;

// Account class
class Account {
    int accNumber;
    String name;
    double balance;

    // Deposit method
    void deposit(double amt) {
        balance += amt;
        System.out.println("Deposited: " + amt);
    }

    // Withdraw method
    void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawn: " + amt);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    // Display account
    void display() {
        System.out.println("Acc No: " + accNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}

// Bank class
class Bank {
    ArrayList<Account> accounts = new ArrayList<>();

    void addAccount(Account acc) {
        accounts.add(acc);
        System.out.println("Account Created Successfully!");
    }

    Account findAccount(int accNo) {
        for (Account acc : accounts) {
            if (acc.accNumber == accNo) {
                return acc;
            }
        }
        return null;
    }
}

// Main class
public class BankManagment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n1.Create 2.Deposit 3.Withdraw 4.Check 5.Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Account acc = new Account();
                    System.out.print("Enter Account No: ");
                    acc.accNumber = sc.nextInt();
                    System.out.print("Enter Name: ");
                    acc.name = sc.next();
                    acc.balance = 0;
                    bank.addAccount(acc);
                    break;

                case 2:
                    System.out.print("Enter Acc No: ");
                    int accNo = sc.nextInt();
                    Account a1 = bank.findAccount(accNo);
                    if (a1 != null) {
                        System.out.print("Enter Amount: ");
                        a1.deposit(sc.nextDouble());
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Acc No: ");
                    int accNo2 = sc.nextInt();
                    Account a2 = bank.findAccount(accNo2);
                    if (a2 != null) {
                        System.out.print("Enter Amount: ");
                        a2.withdraw(sc.nextDouble());
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Acc No: ");
                    int accNo3 = sc.nextInt();
                    Account a3 = bank.findAccount(accNo3);
                    if (a3 != null) {
                        a3.display();
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}