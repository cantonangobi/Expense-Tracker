package main.java.expensetracker;


public class Account {
    //variables
    private String userID;
    private String name;
    private double  balance;

    //methods
    public Account(){
        userID = "";
        name = "";
        balance = 0;
    }

    public Account(String userID, String name, double balance){
        this.userID = userID;
        this.name = name;
        this.balance = balance;
    }


    public double getBalance(){
        return balance;
    }

    public void setBalance(double amount){
        balance = amount;
    }

    public void setUserID(String userID){
        this.userID = userID;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getUserID(){
        return userID;
    }
    public String getName(){
        return name;
    }
    
}
