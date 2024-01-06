import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class User{
    public User(){
        String tempName;
        String tempPIN;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your first name. ");
        tempName = input.nextLine();
        initializeFirstName(tempName);
        tempName = "";
        System.out.println("Please enter your last name. ");
        tempName = input.nextLine();
        initializeLastName(tempName);
        tempName = "";
        System.out.println("Please create a 4-digit PIN. ");
        tempPIN = input.nextLine();
        initializePIN(tempPIN);
        input.close();
        System.out.println("Please wait to be assigned an account number...");
        initializeClientNumber();
        System.out.println("Thank you for your patience. \n Just one last thing. Saving...");
        try{
            saveUser();
        }
        catch(InterruptedException e){
            System.out.println("Error saving user. Please try again later.");
            System.exit(0);
        }
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

    public void initializeFirstName(String name){
        boolean hold = false;
        boolean holdInner = false;
        Scanner num = new Scanner(System.in);
        Scanner firstName = new Scanner(System.in);
        String tempName = name;
        String check;
        do{
            if(!checkLetter(name) || checkDigit(name) || checkWhiteSpace(name)){
                System.out.println("Please re-enter your first name. ");
                tempName = firstName.nextLine();
                hold = true;
            }
            else{
                hold = false;
            }
        } while (hold);
        do{
                System.out.println("You have entered " + tempName + " as your first name. If correct, press 1. To re-enter, press 2.");
                check = num.nextLine();
                if(check.equals("1")){
                    this.firstName = tempName;
                    hold = false;
                }
                else if(check.equals("2")){
                    System.out.println("Please enter your first name. ");
                    tempName = firstName.nextLine();
                    do{
                        if(!checkLetter(name) || checkDigit(name) || checkWhiteSpace(name)){
                            System.out.println("Please re-enter your first name. ");
                            tempName = firstName.nextLine();
                            holdInner = true;
                    }
                    } while (holdInner);
                }
                else{
                    System.out.println("Invalid entry.");
                    hold = true;
                }
        } while (hold);
        num.close();
        firstName.close();
        this.firstName = tempName;
    }
    public void initializeLastName(String name){
        boolean hold = false;
        boolean holdInner = false;
        Scanner num = new Scanner(System.in);
        Scanner lastName = new Scanner(System.in);
        String tempName = "";
        String check = "";
        do{
            if(!checkLetter(name) || checkDigit(name) || checkWhiteSpace(name)){
                System.out.println("Please re-enter your last name. ");
                tempName = lastName.nextLine();
                hold = true;
            }
            else{
                hold = false;
            }
        } while (hold);
        do{
            System.out.println("You have entered " + tempName + " as your last name. If correct, press 1. To re-enter, press 2.");
                check = num.nextLine();
                if(check.equals("1")){
                    this.lastName = tempName;
                    hold = false;
                }
                else if(check.equals("2")){
                    System.out.println("Please enter your first name. ");
                    tempName = lastName.nextLine();
                    do{
                            if(!checkLetter(name) || checkDigit(name) || checkWhiteSpace(name)){
                                System.out.println("Invalid entry.");
                                System.out.println("Please re-enter your first name. ");
                                tempName = lastName.nextLine();
                                holdInner = true;
                            }
                            else{
                                holdInner = false;
                            }
                    } while (holdInner);
                }
                else{
                    System.out.println("Invalid entry.");
                    hold = true;
                }
        } while (hold);
        num.close();
        lastName.close();
        this.lastName = tempName;
    }
    public void initializePIN(String check){
        boolean hold = false;
        boolean holdInner = false;
        Scanner input = new Scanner(System.in);
        String tempPIN = "";
        int confirm;
        String compare = "";
        do{
            if(!checkDigit(check) || checkLetter(check) || checkWhiteSpace(check)){
                System.out.println("Invalid entry.");
                System.out.println("Please enter a 4-digit PIN. ");
                tempPIN = input.nextLine();
                hold = true;
            }
            else{
                hold = false;
            }
        } while (hold);
        do{
            System.out.println("You have entered " + tempPIN + " as your PIN. If correct, press 1. To re-enter, press 2.");
                confirm = input.nextInt();
                if(confirm == 1){
                    System.out.println("Please re-enter your PIN to confirm.");
                    compare = input.nextLine();
                    if(!(tempPIN.equals(compare))){
                        hold = true;
                    }
                    else{
                        hold = false;
                    }
                }
                else if(confirm == 2){
                    System.out.println("Please create a 4-digit PIN. ");
                    tempPIN = input.nextLine();
                    do{
                        if(!checkDigit(tempPIN) || checkLetter(tempPIN) || checkWhiteSpace(tempPIN)){
                            System.out.println("Invalid entry.");
                            System.out.println("Please enter a 4-digit PIN. ");
                            tempPIN = input.nextLine();
                            holdInner = true;
                            hold = true;
                        }
                        else{
                            holdInner = false;
                        }
                    } while (holdInner);
                }
                else{
                    System.out.println("Invalid entry.");
                    hold = true;
                }
        } while (hold);
        System.out.println("Please note down your PIN in a safe location. You will need it to access your account.");
        input.close();
        this.PIN = Integer.parseInt(tempPIN);
    }
    public void initializeClientNumber(){
        boolean hold = false;
        Random number = new Random();
        int num = number.nextInt();
        do{
            // implement a check to make sure the number is unique                 
        } while (hold);
        System.out.println("Please note down your account number in a safe location. You will need it to access your account.");
        this.clientNumber = num;
    }
    public void saveUser() throws InterruptedException{
        String PINbinary = Integer.toBinaryString(this.PIN);
        String clientNumberBinary = Integer.toBinaryString(this.clientNumber);
        int counter = 0;
        boolean hold = false;
        File user = new File(PINbinary + clientNumberBinary);
        do{
            if(counter == 3){
                System.out.println("Sorry for the delay. Please restart account creation process.");
                System.exit(0);
            }
            try{
                user.createNewFile();
                hold = false;
            }
            catch(IOException e){
                System.out.println("An error occurred. Please wait one moment.");
                counter++;
                hold = true;
                Thread.sleep(10000);
            }
        } while (hold);
        counter = 0;
        do{
            if(counter == 3){
                System.out.println("Sorry for the delay. Please restart account creation process.");
                System.exit(0);
            }
            try{
                FileWriter writer = new FileWriter(PINbinary + clientNumberBinary);
                writer.write(this.firstName + " " + this.lastName + " " + this.PIN + " " + this.clientNumber);
                writer.close();
                hold = false;
            }
            catch(IOException e){
                System.out.println("An error occurred. Please wait one moment.");
                counter++;
                hold = true;
                Thread.sleep(10000);
            }
        } while (hold);
        System.out.println("Thank you for your patronage. We hope to see you again soon!");
        System.exit(0);
    }

    public void saveSavingsAccount(SavingsAccount accountName){
        this.savings = accountName;
        try{
            String PINbinary = Integer.toBinaryString(this.PIN);
            String clientNumberBinary = Integer.toBinaryString(this.clientNumber);

            String[] lines = new String[5];
            List<String> allLines = Files.readAllLines(Paths.get(PINbinary + clientNumberBinary));
            int i = 0;

            for(String line : allLines){
                lines[i] = line;
                i++;
            }

            lines[4] = "1";

            FileWriter writer = new FileWriter("copy.txt");
            BufferedWriter buffer = new BufferedWriter(writer);

            for(int j = 0; i < lines.length; j++){
                buffer.write(lines[j]);
            }

            writer.close();
            buffer.close();

            Path source = Paths.get("copy.txt");
            Files.move(source, source.resolveSibling(PINbinary + clientNumberBinary), StandardCopyOption.REPLACE_EXISTING);
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
    }

    public void saveCheckingsAccount(CheckingsAccount accountName){
        this.checkings = accountName;
        try{
            String PINbinary = Integer.toBinaryString(this.PIN);
            String clientNumberBinary = Integer.toBinaryString(this.clientNumber);

            String[] lines = new String[5];
            List<String> allLines = Files.readAllLines(Paths.get(PINbinary + clientNumberBinary));
            int i = 0;

            for(String line : allLines){
                lines[i] = line;
                i++;
            }

            lines[5] = "1";

            FileWriter writer = new FileWriter("copy.txt");
            BufferedWriter buffer = new BufferedWriter(writer);

            for(int j = 0; i < lines.length; j++){
                buffer.write(lines[j]);
            }

            writer.close();
            buffer.close();

            Path source = Paths.get("copy.txt");
            Files.move(source, source.resolveSibling(PINbinary + clientNumberBinary), StandardCopyOption.REPLACE_EXISTING);
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
    }

    public SavingsAccount getSavingsAccount(){
        return savings;
    }
    public CheckingsAccount getCheckingsAccount(){
        return checkings;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getPIN(){
        return PIN;
    }
    public int getClientNumber(){
        return clientNumber;
    }

    public void setSavingsAccount(SavingsAccount savings){
        this.savings = savings;
    }
    public void setCheckingsAccount(CheckingsAccount checkings){
        this.checkings = checkings;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setPIN(int PIN){
        this.PIN = PIN;
    }
    public void setClientNumber(int clientNumber){
        this.clientNumber = clientNumber;
    }

    public boolean getHasSavingsAccount(){
        boolean has = false;
        try{
            String PINbinary = Integer.toBinaryString(this.PIN);
            String clientNumberBinary = Integer.toBinaryString(this.clientNumber);

            String[] lines = new String[5];
            List<String> allLines = Files.readAllLines(Paths.get(PINbinary + clientNumberBinary));
            int i = 0;

            for(String line : allLines){
                lines[i] = line;
                i++;
            }
            if(lines[4].equals("1")){
                has = true;
            }
            else{
                has = false;
            }
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
        return has;
    }
    public boolean getHasCheckingsAccount(){
        boolean has = false;
        try{
            String PINbinary = Integer.toBinaryString(this.PIN);
            String clientNumberBinary = Integer.toBinaryString(this.clientNumber);

            String[] lines = new String[5];
            List<String> allLines = Files.readAllLines(Paths.get(PINbinary + clientNumberBinary));
            int i = 0;

            for(String line : allLines){
                lines[i] = line;
                i++;
            }
            if(lines[5].equals("1")){
                has = true;
            }
            else{
                has = false;
            }
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
        return has;
    }

    private SavingsAccount savings;
    private CheckingsAccount checkings;
    private String firstName;
    private String lastName;
    private int PIN;
    private int clientNumber;
}