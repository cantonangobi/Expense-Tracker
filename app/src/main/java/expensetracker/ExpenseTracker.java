package main.java.expensetracker;

public class ExpenseTracker {
    //Variables
    private Account account;

    //methods
    public ExpenseTracker(){
        createAccount();
    }

    public void createAccount(){
        account = new Account();    
    }

    public void setBalance(double amount){
        account.setBalance(amount);
    }

    public double getBalance(){
        return account.getBalance();
    }

    public void recordIncome(double amount){
        account.setBalance(account.getBalance() + amount);
    }

    public void recordExpense(double amount){
        account.setBalance(account.getBalance() - amount);
    }
}
