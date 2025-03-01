package expensetracker;

import java.util.ArrayList;
import java.util.Scanner;

public class AppUI {
    //attributes
    private ExpenseTracker expenseTracker;
    private String menuHeader, menuBody, prompt;

    //Methods
    public AppUI(){
        expenseTracker = new ExpenseTracker();
    }


    public void displayMenu(){
        // System.out.print("\033[H\033[2J");  
        // System.out.flush();     
        System.out.println(" _______________________________________________________________________");
        System.out.println("|                                                                       |");
        System.out.println("| " + menuHeader);
        System.out.println("|_______________________________________________________________________|");
        System.out.println("|                                                                       |");
        System.out.println("| " + menuBody);
        System.out.println("|_______________________________________________________________________|");
    }
    
    private double getNumInput(){
        double num = 0;
        while (true){
            try{
                System.out.print(prompt);
                num = new Scanner(System.in).nextDouble();
            }
            catch (Exception e){
                displayMenu();
                System.out.println("\nInvalid Input! Please try again");
                continue;
            }
            break;
        }
        return num;   
    }
    
    private void setUpAccount(){
        menuHeader = "Welcome";
        menuBody = "Account Setup";
        prompt = "Please enter your name: ";
        displayMenu();
        System.out.print(prompt);
        String name = new Scanner(System.in).next();

        menuHeader = "Welcome " + name;
        prompt = "Please enter an initial balance: ";
        displayMenu();
        double answer = getNumInput();

        expenseTracker.createAccount(name, answer); 
    }
   
    private void resetAccount(){
        menuHeader = "Welcome";
        menuBody = "Account Setup";
        prompt = "Please enter your name: ";
        displayMenu();
        System.out.print(prompt);
        String name = new Scanner(System.in).next();

        menuHeader = "Welcome " + name;
        prompt = "Please enter an initial balance: ";
        displayMenu();
        double answer = getNumInput();
        
        expenseTracker.resetAccount(name, answer); 
    }
  
    private void recordExpense(){
        menuHeader = "Record Expense";
        prompt = "Please input the amount: ";
        displayMenu();
        double answer = getNumInput();
        expenseTracker.recordExpense(answer);
    }
    
    private void recordIncome(){
        menuHeader = "Record Income";
        prompt = "Please input the amount: ";
        displayMenu();
        double answer = getNumInput();
        expenseTracker.recordIncome(answer);
    }

    private void setBalance(){
        menuHeader = "Set Balance";
        prompt = "Please input the amount: ";
        displayMenu();
        double answer = getNumInput();
        expenseTracker.setBalance(answer);
    }

    public void runUI(){
        //setup account if it doesn't exist
        if (!expenseTracker.accountExists()) {
            setUpAccount();
        }

        //run main menu
        while (true)
        {
            menuHeader = "Welcome " + expenseTracker.getAccountName();
            menuBody = "Current Balance: " + String.valueOf(expenseTracker.getBalance());
            prompt = "Good Day. What would you like to do?:\n\t1) Record an expense\n\t2) Record an income\n\t3) Set balance\n\t4) Reset account\n\t5) View Transaction list\n\t6) Exit\nResponse: ";
            displayMenu();
            System.out.println(prompt);

            String choice = new Scanner(System.in).next();
            if (choice.equals("1")){
                recordExpense();
            }
            else if (choice.equals("2")){
                recordIncome();
            }
            else if (choice.equals("3")){
               setBalance();
            }
            else if (choice.equals("4")){
                resetAccount();
            }
            else if (choice.equals("5")){
                
                
                // prompt = "Good Day. Your Transactions are as follows:\n\t   Type\tamount\tbalance\n\t1) type\tamount\tbalance\n\t2) type\tamount\tbalance\n\t3) type\tamount\tbalance\nEnter 0 to go back to main menu: ";
                prompt = "Good Day. Your Transactions are as follows:\n\t|   Type\t|amount\t|balance|\n";
                prompt = prompt +"\t|---------------|-------|-------|\n";
                ArrayList<Transaction> transactions = expenseTracker.getTransactions();
                for (int i = 0; i < transactions.size(); i++) {
                    // System.out.println("\t" + String.valueOf(i+1) +") " + transactions.get(i).getType() + "\t" + String.valueOf(transactions.get(i).getAmount()) + "\t" + String.valueOf(transactions.get(i).getBalance()) +"\n");
                    prompt = prompt + "\t|" + String.valueOf(i+1) +") " + transactions.get(i).getType() + "\t|" + String.valueOf(transactions.get(i).getAmount()) + "\t|" + String.valueOf(transactions.get(i).getBalance()) +"|\n";
                }
                prompt = prompt + "\nEnter 0 to go back to main menu: ";
                displayMenu();
                System.out.println(prompt);
                choice = new Scanner(System.in).next();
                continue;
            }
            else if (choice.equals("6")){
                break;
            }
            else{
                //todo
                break;
            }
        }
        
    }
}
