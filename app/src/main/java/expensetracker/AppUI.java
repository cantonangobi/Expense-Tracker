package main.java.expensetracker;

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
        System.out.print("\033[H\033[2J");  
        System.out.flush();     
        System.out.println(" _______________________________________________________________________");
        System.out.println("|                                                                       |");
        System.out.println("| " + menuHeader);
        System.out.println("|_______________________________________________________________________|");
        System.out.println("|                                                                       |");
        System.out.println("| " + menuBody);
        System.out.println("|_______________________________________________________________________|");
    }
    
    public double getNumInput(){
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
    

    public void runUI(){
        menuHeader = "Welcome";
        menuBody = "Account Setup";
        prompt = "Please enter an initial balance: ";
        displayMenu();
        double answer = getNumInput();

        expenseTracker.setBalance(answer);

        while (true)
        {
            menuBody = "Current Balance: " + String.valueOf(expenseTracker.getBalance());
            prompt = "Good Day. What would you like to do?:\n\t1) Record an expense\n\t2) Record an income\n\t3) reset balance to 0\n\t4) Exit\nResponse: ";
            displayMenu();
            System.out.println(prompt);

            String choice = new Scanner(System.in).next();
            if (choice.equals("1")){
                menuHeader = "Record Expense";
                prompt = "Please input the amount: ";
                displayMenu();
                answer = getNumInput();
                expenseTracker.recordExpense(answer);
    
            }
            else if (choice.equals("2")){
                menuHeader = "Record Income";
                prompt = "Please input the amount: ";
                displayMenu();
                answer = getNumInput();
                expenseTracker.recordIncome(answer);
            }
            else if (choice.equals("3")){
                expenseTracker.setBalance(0);
            }
            else if (choice.equals("4")){
                break;
            }
            else{
                //todo
                break;
            }
        }
        
    }
}
