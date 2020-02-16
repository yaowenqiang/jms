import java.util.ArrayList;

public class Accounts {
    private String name;
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Accounts(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            transactions.add(amount);
            this.balance += amount;
            System.out.println(amount + " deposited, Balance is new " + this.balance);
        } else {
            System.out.println("Cannot deposit negative sums.");
        }
    }

    public void withdraw(int amount) {
        int withdrawal = -amount;
        if (withdrawal < 0) {
            transactions.add(withdrawal);
            this.balance += withdrawal;
            System.out.println(amount + " withdrawn, balance is now " + this.balance);
        } else {
            System.out.println("Cannot withdraw negative sum.");
        }
    }

    public void calculateBalance() {
        this.balance = 0;
        for (int i : this.transactions) {
            this.balance += i;
        }
        System.out.println("Calculated balance is " + this.balance);
    }
}
