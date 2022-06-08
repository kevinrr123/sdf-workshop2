package vtp2022.workshop2;


import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class BankAccount {

    private String name="";

    // Getter and Setter for the rest of properties
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<String> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }

    private String accId = UUID.randomUUID().toString().substring(0,8);

    //holds the bank acc balance
    private float balance = 0f;
    //list of transaction history in the event of anything done
    private List<String> transaction = new LinkedList<>();

    private boolean isClosed = false;

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    private LocalDateTime accountCreationDate;
    private LocalDateTime accountClosingDate;

        //constructor with account name
        public BankAccount(String name){
            this.name = name;
        }
    
        //2nd constructor with bank account name and initial balance
        public BankAccount(String name, float initialBal){
            this.name=name;
            this.balance = initialBal;
        }

    public LocalDateTime getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(LocalDateTime accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public LocalDateTime getAccountClosingDate() {
        return accountClosingDate;
    }

    public void setAccountClosingDate(LocalDateTime accountClosingDate) {
        this.accountClosingDate = accountClosingDate;
    }






    protected float withdraw(String withdrawAmt){
        Float withdrawAmtF = null;
        try{
            Float withdrawAmtF = Float.parseFloat(withdrawAmt);
            if (depositAmtF.floatValue()<=0){
                throw new IllegalArgumentException("Invalid amount entered");
            }

            if(this.isClosed()){
                throw new IllegalArgumentException("Account is closed");
            }

            //Construct the transaction history event log
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Deposit $");
            txnStrbld.append(depositAmtF.floatValue());
            txnStrbld.append("at");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());
            //save event log into txn linkedlist
            transaction.add(txnStrbld.toString());
            //update the deposit amount
            this.balance = this.balance + depositAmtF.floatValue();
        }catch(NumberFormatException e){
            System.err.print(e);
            throw new IllegalArgumentException("Invalid deposit amount");
        }
    }

    protected void deposit(String depositAmt){
        try{
            Float depositAmtF = Float.parseFloat(depositAmt);
            if (depositAmtF.floatValue()<=0){
                throw new IllegalArgumentException("Invalid amount entered");
            }

            if(this.isClosed()){
                throw new IllegalArgumentException("Account is closed");
            }

            //Construct the transaction history event log
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Deposit $");
            txnStrbld.append(depositAmtF.floatValue());
            txnStrbld.append("at");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());
            //save event log into txn linkedlist
            transaction.add(txnStrbld.toString());
            //update the deposit amount
            this.balance = this.balance + depositAmtF.floatValue();
        }catch(NumberFormatException e){
            System.err.print(e);
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        
    }



    
}
