package Bai_Tap_Buoi_4.Exercise_4_Encapsulation.Question_2;

public class Account {
    private String id;
    private String name;
    private int balance;

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getID() { return id; }
    public String getName() { return name; }
    public int getBalance() { return balance; }

    public int credit(int amount) {
        this.balance += amount;
        return this.balance;
    }

    public int debit(int amount) {
        if (amount <= balance) {
            this.balance -= amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return this.balance;
    }

    public int transferTo(Account another, int amount) {
        if (amount <= balance) {
            this.debit(amount);
            another.credit(amount);
        } else {
            System.out.println("Amount exceeded balance");
        }
        return this.balance;
    }

    @Override
    public String toString() {
        return "Account[id=" + id + ", name=" + name + ", balance=" + balance + "]";
    }
}