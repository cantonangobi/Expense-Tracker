package main.java.expensetracker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExpenseTracker {
    //Variables
    private Account account;
    // private String lastID;
    private String saveFileName;
    private boolean accountLoaded;
    //private 


    //methods
    public ExpenseTracker(){
        saveFileName = "account.csv";
        accountLoaded = false;
        load();
    }

    // public void createAccount(){
    //     account = new Account();    
    // }

    public void createAccount(String name, double amount){
        account = new Account("1", name, amount );    
        save();
        accountLoaded = true;
    }

    public void setBalance(double amount){
        account.setBalance(amount);
        save();
    }

    public double getBalance(){
        return account.getBalance();
    }

    public void recordIncome(double amount){
        account.setBalance(account.getBalance() + amount);
        save();
    }

    public void recordExpense(double amount){
        account.setBalance(account.getBalance() - amount);
        save();
    }

    public void resetAccount(String name, double amount){
        // lastID = String.valueOf(Integer.parseInt(lastID) + 1);
        account = new Account(account.getUserID(),name,amount);
        save();
        accountLoaded = true;
    }

    public void save(){
        File file = new File(saveFileName);
        String line = account.getUserID() + "," + account.getName() + "," + String.valueOf(account.getBalance() +"\n");
        writeFile(file, line);
    }

    public void load(){ 
        File file = new File(saveFileName);
        
        if (file.isFile()) {
            String line = readFile(file);
            if (!line.isEmpty()){
                String[] words = line.split(",");
                account = new Account(words[0],words[1], Double.parseDouble(words[2]));
                System.out.println(account.getName());
                accountLoaded = true;
            }
        }
    }

    public boolean accountExists(){
        return accountLoaded;
    }

    public String getAccountName(){
        return account.getName();
    }

    private void writeFile(File file, String line){
        try {

            FileWriter writer = new FileWriter(file);

            writer.write(line);
            writer.close();
            System.out.println("The file has been written in " + System.getProperty("user.dir"));

        } catch (IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        
    }

    private String readFile(File file){
        String line = "";
        try{
            Scanner reader = new Scanner(file);

            // Traversing File Data
            //   while (reader.hasNextLine()) {
            //     lines = lines + reader.nextLine();
            //     lines = lines + "\n";
            // }
            if (reader.hasNextLine()){
                line = reader.nextLine();
            }
            
            reader.close();

        } catch (IOException e){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        
        return line;
    }


}
