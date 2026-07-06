/*
 * Problem: BankAccount — First Java Class
 * Create a class representing a simple bank account with deposit,
 * withdraw, and balance-printing behavior.
 *
 * Fields: owner (String), balance (double)
 *
 * Input:  BankAccount acc = new BankAccount("Nithin", 1500.00);
 *         acc.deposit(500.00);
 *         acc.withdraw(200);
 *         acc.printBalance();
 * Output: Owner: Nithin | Balance: 1800.0
 *
 * Example 2 (insufficient funds):
 * Input:  BankAccount acc = new BankAccount("Nithin", 100.00);
 *         acc.withdraw(500);
 * Output: Insufficient Funds
 *
 * Approach: Store owner and balance as instance fields. Use a constructor
 * to initialize both at object creation. deposit() adds directly to balance.
 * withdraw() uses a guard clause to reject withdrawals greater than the
 * current balance before mutating state.
 * Time complexity: O(1) for all operations
 */

package bankaccount;

public class BankAccount {

    // Fields — the data every BankAccount object will hold
    String owner;
    double balance;

    // Constructor — runs when you create a new BankAccount object
    // "this.owner" refers to the field, "owner" (right side) refers to the parameter
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    // Adds the given amount to the current balance
    public void deposit(double amount) {
        balance = balance + amount;
    }

    // Prints the account details in the required format
    public void printBalance() {
        System.out.println("Owner: " + owner + " | Balance: " + balance);
    }

    // Subtracts the given amount from balance, but only if funds are sufficient
    public void withdraw(double amount) {
        if (amount > balance) {
            // Guard clause: stop here if withdrawal isn't possible
            System.out.println("Insufficient Funds");
            return; // exits the method early, skips the line below
        }
        balance = balance - amount;
    }

    // Entry point — this is what runs when you execute this class
    public static void main(String args[]) {
        // Creates a new BankAccount object in memory, "acc" refers to it
        BankAccount acc = new BankAccount("Nithin", 1500.00);

        acc.deposit(500.00);   // balance becomes 2000.0
        acc.withdraw(200);     // balance becomes 1800.0
        acc.printBalance();    // prints final result
    }
}