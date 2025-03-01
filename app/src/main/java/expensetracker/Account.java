package main.java.expensetracker;


public class Account {
    //variables
    private double  balance;

    //methods
    public Account(){
        balance = 0;
    }

    public Account(double amount){
        balance = amount;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double amount){
        balance = amount;
    }
}
