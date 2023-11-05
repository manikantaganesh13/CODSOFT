import java.util.*;

class UserBankAccount{
    private double balance;

    UserBankAccount(double balance){
        this.balance = balance;
    }

    public void checkBalance(){
            System.out.println("Account balance: "+balance);
    }

    public void deposit(double d_amount){
        balance += d_amount;
        System.out.println("Deposit successful");
    }

    public void withdraw(double wd_amount){
        if(balance >= wd_amount){
            balance -= wd_amount;
            System.out.println("Withdraw successful");
        }
            
        else{
            System.out.println("Insufficient balance!!!");
        }
    }
}

class ATM{
    private static int pin = 3891;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the ATM Machine");
        double balance = 1000;

        UserBankAccount account = new UserBankAccount(balance);

        System.out.println("Please enter your PIN: ");
        int input_pin = sc.nextInt();

        if(pin == input_pin){
            while(true){
                System.out.println("Select an option:");
                System.out.println("1.Deposit money\n2.Withdraw money\n3.Check balance\n4.Exit");
                int option = sc.nextInt();
                    
                switch(option){
                    case 1: System.out.println("Enter amount to deposit: ");
                            double d_amount = sc.nextDouble();
                            account.deposit(d_amount);
                            break;
                    case 2: System.out.println("Enter amount to withdraw: ");
                            double wd_amount = sc.nextDouble();
                            account.withdraw(wd_amount);
                            break;
                    case 3: account.checkBalance();
                            break;
                    case 4 : System.out.println("Thank You! Visit again");
                             System.exit(0);
                             break;
                    default: System.out.println("Invalid option! Select again.");
                            break;
                }
            }
        }    
        else{
            System.out.println("Invalid PIN");
        }
        sc.close();
    }    
}