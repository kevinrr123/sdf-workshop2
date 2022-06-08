package vtp2022.workshop2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My atm Machine - POSBANK" );
        BankAccount bkAcc = new BankAccount("Kevin Bank Account");
        bkAcc.deposit("1000");
        System.out.println("My new account balance >" + bkAcc.getBalance());
        bkAcc.withdraw("20");
        System.out.println("My new account balance >" + bkAcc.getBalance());
        bkAcc.withdraw("500");
        System.out.println("My new account balance >" + bkAcc.getBalance());
    }
}
