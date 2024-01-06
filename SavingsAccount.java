import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Scanner;

public class SavingsAccount implements BankAccount{
    public SavingsAccount(){
        // use the constructor in User
        Scanner input = new Scanner(System.in);
        String confirm;
        boolean hold = false;
        boolean innerHold = false;
        System.out.println("Thank you for choosing to open a savings account with us today!");
        System.out.println("Would you like to make a deposit now? If yes, press 1. Otherwise, press 2.");
        do{
            confirm = input.nextLine();
            if(confirm.equals("1")){
                System.out.println("Please enter the amount you would like to deposit :");
                do{
                    confirm = input.nextLine();
                    if(checkDigitDot(confirm) && !checkWhiteSpace(confirm) && !checkLetter(confirm)){
                        deposit(Double.parseDouble(confirm));
                        innerHold = false;
                    }
                    else{
                        System.out.println("Invalid entry.");
                        innerHold = true;
                    }
                }while(innerHold);
            }
            else if(confirm.equals("2")){
                deposit(0);
                hold = false;
            }
            else{
                System.out.println("Please make a valid selection. If you would like to make a deposit now, press 1. Otherwise, press 2.");
                hold = true;
                confirm = input.nextLine();
            } 
        }while(hold);   
        input.close();
    }

    public boolean checkDigitDot(String name){
        char[] ch = name.toCharArray();
        for(int i = 0; i < ch.length; i++){
            if(Character.isDigit(ch[i])){
                return true;
            }
            else if(Character.toString(ch[i]).equals(".")){
                return true;
            }
        }
        return false;
    }
    public boolean checkDigit(String name){
        char[] ch = name.toCharArray();
        for(int i = 0; i < ch.length; i++){
            if(Character.isDigit(ch[i])){
                return true;
            }
        }
        return false;
    }
    public boolean checkWhiteSpace(String name){
        char[] ch = name.toCharArray();
        for(int i = 0; i < ch.length; i++){
            if(Character.isWhitespace(ch[i])){
                return true;
            }
        }
        return false;
    }
    public boolean checkLetter(String name){
        char[] ch = name.toCharArray();
        for(int i = 0; i < ch.length; i++){
            if(Character.isLetter(ch[i])){
                return true;
            }
        }
        return false;
    }
    
    public void deposit(){
        Scanner input = new Scanner(System.in);
        String deposit;
        double newBalance;
        boolean hold = false;
        boolean innermostHold = false;
        int PIN = 0;
        int clientNumber = 0;
        do{
            System.out.println("Please enter your PIN to continue.");
            deposit = input.nextLine();
            if(deposit.length() < 4 && deposit.length() > 0 && checkDigit(deposit) && !checkWhiteSpace(deposit) && !checkLetter(deposit)){
                System.out.println("You entered " + deposit + ". If this is correct, press 1. To re-enter, press 2.");
                PIN = Integer.parseInt(deposit);
                do{
                    deposit = input.nextLine();
                    if(deposit.equals("1")){
                        innermostHold = true;
                        hold = false;
                    }
                    else if(deposit.equals("2")){
                        innermostHold = false;
                        hold = true;
                    }
                    else{
                        System.out.println("Invalid entry.");
                        innermostHold = false;
                        hold = true;
                    }
                }while(innermostHold);
            }
            else{
                System.out.println("Invalid entry.");
                hold = true;
            }
        }while(hold);
        do{
            System.out.println("Please enter your client number to continue.");
            deposit = input.nextLine();
            if(checkDigit(deposit) && !checkWhiteSpace(deposit) && !checkLetter(deposit)){
                System.out.println("You entered " + deposit + ". If this is correct, press 1. To re-enter, press 2.");
                clientNumber = Integer.parseInt(deposit);
                do{
                    deposit = input.nextLine();
                    if(deposit.equals("1")){
                        innermostHold = true;
                        hold = false;
                    }
                    else if(deposit.equals("2")){
                        innermostHold = false;
                        hold = true;
                    }
                    else{
                        System.out.println("Invalid entry.");
                        innermostHold = false;
                        hold = true;
                    }
                }while(innermostHold);
            }
            else{
                System.out.println("Invalid entry.");
                hold = true;
            }
        }while(hold);
        do{
            System.out.println("Please enter the amount to deposit.");
            deposit = input.nextLine();
            if(!checkDigitDot(deposit) || checkWhiteSpace(deposit) || checkLetter(deposit)){
                System.out.println("Invalid entry.");
                hold = true;
            }
            else{
                hold = false;
        }
        }while(hold);
        input.close();
        newBalance = Double.parseDouble(deposit) + this.balance;
        writeToFile(newBalance, PIN, clientNumber); 
    }
    public void deposit(double num){
        Scanner input = new Scanner(System.in);
        String deposit;
        double newBalance;
        boolean hold = false;
        boolean innermostHold = false;
        int PIN = 0;
        int clientNumber = 0;
        do{
            System.out.println("Please enter your PIN to continue.");
            deposit = input.nextLine();
            if(deposit.length() < 4 && deposit.length() > 0 && checkDigit(deposit) && !checkWhiteSpace(deposit) && !checkLetter(deposit)){
                System.out.println("You entered " + deposit + ". If this is correct, press 1. To re-enter, press 2.");
                PIN = Integer.parseInt(deposit);
                do{
                    deposit = input.nextLine();
                    if(deposit.equals("1")){
                        innermostHold = true;
                        hold = false;
                    }
                    else if(deposit.equals("2")){
                        innermostHold = false;
                        hold = true;
                    }
                    else{
                        System.out.println("Invalid entry.");
                        innermostHold = false;
                        hold = true;
                    }
                }while(innermostHold);
            }
            else{
                System.out.println("Invalid entry.");
                hold = true;
            }
        }while(hold);
        do{
            System.out.println("Please enter your client number to continue.");
            deposit = input.nextLine();
            if(checkDigitDot(deposit) && !checkWhiteSpace(deposit) && !checkLetter(deposit)){
                System.out.println("You entered " + deposit + ". If this is correct, press 1. To re-enter, press 2.");
                clientNumber = Integer.parseInt(deposit);
                do{
                    deposit = input.nextLine();
                    if(deposit.equals("1")){
                        innermostHold = true;
                        hold = false;
                    }
                    else if(deposit.equals("2")){
                        innermostHold = false;
                        hold = true;
                    }
                    else{
                        System.out.println("Invalid entry.");
                        innermostHold = false;
                        hold = true;
                    }
                }while(innermostHold);
            }
            else{
                System.out.println("Invalid entry.");
                hold = true;
            }
        }while(hold);
        input.close();
        newBalance = Double.parseDouble(deposit) + num;
        writeToFile(newBalance, PIN, clientNumber); 
    }
    public void withdraw(){
        Scanner input = new Scanner(System.in);
        String deposit;
        double newBalance;
        boolean hold = false;
        boolean innermostHold = false;
        int PIN = 0;
        int clientNumber = 0;
        do{
            System.out.println("Please enter your PIN to continue.");
            deposit = input.nextLine();
            if(deposit.length() < 4 && deposit.length() > 0 && checkDigit(deposit) && !checkWhiteSpace(deposit) && !checkLetter(deposit)){
                System.out.println("You entered " + deposit + ". If this is correct, press 1. To re-enter, press 2.");
                PIN = Integer.parseInt(deposit);
                do{
                    deposit = input.nextLine();
                    if(deposit.equals("1")){
                        innermostHold = true;
                        hold = false;
                    }
                    else if(deposit.equals("2")){
                        innermostHold = false;
                        hold = true;
                    }
                    else{
                        System.out.println("Invalid entry.");
                        innermostHold = false;
                        hold = true;
                    }
                }while(innermostHold);
            }
            else{
                System.out.println("Invalid entry.");
                hold = true;
            }
        }while(hold);
        do{
            System.out.println("Please enter your client number to continue.");
            deposit = input.nextLine();
            if(checkDigitDot(deposit) && !checkWhiteSpace(deposit) && !checkLetter(deposit)){
                System.out.println("You entered " + deposit + ". If this is correct, press 1. To re-enter, press 2.");
                clientNumber = Integer.parseInt(deposit);
                do{
                    deposit = input.nextLine();
                    if(deposit.equals("1")){
                        innermostHold = true;
                        hold = false;
                    }
                    else if(deposit.equals("2")){
                        innermostHold = false;
                        hold = true;
                    }
                    else{
                        System.out.println("Invalid entry.");
                        innermostHold = false;
                        hold = true;
                    }
                }while(innermostHold);
            }
            else{
                System.out.println("Invalid entry.");
                hold = true;
            }
        }while(hold);
        do{
            System.out.println("Please enter the amount to withdraw.");
            deposit = input.nextLine();
            if(!checkDigitDot(deposit) || checkWhiteSpace(deposit) || checkLetter(deposit)){
                System.out.println("Invalid entry.");
                hold = true;
            }
            else{
                hold = false;
        }
        }while(hold);
        input.close();
        newBalance = this.balance - Double.parseDouble(deposit);
        writeToFile(newBalance, PIN, clientNumber);
    }

    public void accumulateInterest(int PIN, int clientNumber){
        String PINbinary = Integer.toBinaryString(PIN);
        String clientNumberBinary = Integer.toBinaryString(clientNumber);
        String line = "";
        try{
            List<String> allLines = Files.readAllLines(Paths.get(PINbinary + clientNumberBinary));
            line = allLines.get(2);
        }
        catch(IOException e){
            e.printStackTrace();
        }        

        double hold = Double.parseDouble(line);
        hold *= interestRate;
        writeToFile(hold, PIN, clientNumber);
    }

    public void viewBalance(){
        Scanner input = new Scanner(System.in);
        String deposit;
        boolean hold = false;
        boolean innermostHold = false;
        int PIN = 0;
        int clientNumber = 0;
        do{
            System.out.println("Please enter your PIN to continue.");
            deposit = input.nextLine();
            if(deposit.length() < 4 && deposit.length() > 0 && checkDigit(deposit) && !checkWhiteSpace(deposit) && !checkLetter(deposit)){
                System.out.println("You entered " + deposit + ". If this is correct, press 1. To re-enter, press 2.");
                PIN = Integer.parseInt(deposit);
                do{
                    deposit = input.nextLine();
                    if(deposit.equals("1")){
                        innermostHold = true;
                        hold = false;
                    }
                    else if(deposit.equals("2")){
                        innermostHold = false;
                        hold = true;
                    }
                    else{
                        System.out.println("Invalid entry.");
                        innermostHold = false;
                        hold = true;
                    }
                }while(innermostHold);
            }
            else{
                System.out.println("Invalid entry.");
                hold = true;
            }
        }while(hold);
        do{
            System.out.println("Please enter your client number to continue.");
            deposit = input.nextLine();
            if(checkDigitDot(deposit) && !checkWhiteSpace(deposit) && !checkLetter(deposit)){
                System.out.println("You entered " + deposit + ". If this is correct, press 1. To re-enter, press 2.");
                clientNumber = Integer.parseInt(deposit);
                do{
                    deposit = input.nextLine();
                    if(deposit.equals("1")){
                        innermostHold = true;
                        hold = false;
                    }
                    else if(deposit.equals("2")){
                        innermostHold = false;
                        hold = true;
                    }
                    else{
                        System.out.println("Invalid entry.");
                        innermostHold = false;
                        hold = true;
                    }
                }while(innermostHold);
            }
            else{
                System.out.println("Invalid entry.");
                hold = true;
            }
        }while(hold);
        input.close();
        String PINbinary = Integer.toBinaryString(PIN);
        String clientNumberBinary = Integer.toBinaryString(clientNumber);
        String line = "";
        try{
            List<String> allLines = Files.readAllLines(Paths.get(PINbinary + clientNumberBinary));
            line = allLines.get(2);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Your current savings is $" + line + ".");
    }

    public void writeToFile(double balance, int PIN, int clientNumber){ // true = savings; false = checkings
        String PINbinary = Integer.toBinaryString(PIN);
        String clientNumberBinary = Integer.toBinaryString(clientNumber);
        String[] lines = new String[5];
            try{
                List<String> allLines = Files.readAllLines(Paths.get(PINbinary + clientNumberBinary));
                int i = 0;
                for(String line : allLines){
                    lines[i] = line;
                    i++;
                }
                
                lines[2] = Double.toString(balance); // 3rd line saves savings balance
                FileWriter writer = new FileWriter("copy.txt");
                BufferedWriter buffer = new BufferedWriter(writer);
    
                for(int j = 0; j < lines.length; j++){
                    buffer.write(lines[j]);
                }
    
                writer.close();
                buffer.close();
    
                Path source = Paths.get("copy.txt");
                Files.move(source, source.resolveSibling(PINbinary + clientNumber), StandardCopyOption.REPLACE_EXISTING);   
            }
            catch(IOException e){
                System.out.println("An error occurred. Please try again later. Speak to a teller if issue persists.");
                // save an error code file named after the date and time
                System.exit(0);
            }
            catch(InvalidPathException e){
                System.out.println("An error occurred. Please try again later. Speak to a teller if issue persists.");
                System.exit(0);
            }
            finally{
                System.out.println("Thank you for your patronage. Please see us again soon and have a good day!");
                System.exit(0);
        }
    }

    private double balance;
    private final double interestRate = 0.39;
}