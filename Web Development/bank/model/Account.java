package bank.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
    private int accountNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private double balance;

    private ArrayList<Transaction> transactions;

    public Account(int accountNumber, String firstName, String lastName, String email, String phone, double balance) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {

        return transactions;
    }

    public void deposit(int amount){
        if (amount>0){
            this.balance+=amount;
            this.transactions.add(new Transaction(generateID(),this.getAccountNumber(),amount,"Deposit"));
            AccountManager.saveAccounts();
        }
    }
    public boolean withDraw(int amount){
        if(balance-amount>-1){
            this.balance-=amount;
            this.transactions.add(new Transaction(generateID(),this.getAccountNumber(),amount,"Withdraw"));
            AccountManager.saveAccounts();
            return true;
        }
        return false;
    }
    public void mortgage(int amount){
        if (amount>0){
            this.balance+=amount;
            this.transactions.add(new Transaction(generateID(),this.getAccountNumber(),(amount+(0.1*amount)),"Mortgage"));
            AccountManager.saveAccounts();
        }
    }
    private int generateID(){

        int max = 0;
        for (Transaction t: transactions) {
            if (t.getId()>max){
                max = t.getId();
            }
        }
        return max+1;
    }

    @Override
    public String toString() {
        return "model.Account{" +
                "accountNumber=" + accountNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}
