

public class ATMTester{
    public static void main(String[] args){
        User me = new User();
        SavingsAccount savings = new SavingsAccount();
        CheckingsAccount checkings = new CheckingsAccount();

        me.saveSavingsAccount(savings);
        me.saveCheckingsAccount(checkings);

        checkings.deposit();
        checkings.deposit(500);
        checkings.withdraw();

        savings.deposit();
        savings.withdraw();
        savings.deposit(1000);

        savings.viewBalance();
        checkings.viewBalance();

    }
}