package bank.model;

import java.io.*;
import java.util.ArrayList;

public class AccountManager {
    private static ArrayList<Account> accounts = new ArrayList<>();
    public AccountManager(){
        readAccounts();
    }
    public static Account getAccount(int accountNo){
        readAccounts();
        for (Account a: accounts) {
            if(accountNo==a.getAccountNumber())
                return a;
        }
        return null;
    }
    public static void addAccount(Account account){
        accounts.add(account);
        writeAccounts();

    }
    public static void saveAccounts(){
        writeAccounts();
    }
    private static void writeAccounts(){
        try {
            FileOutputStream f = new FileOutputStream(new File("src/bank/accounts.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            for (Account a: accounts) {
                o.writeObject(a);
            }
            o.close();
            f.close();

        } catch (Exception e) {
            System.out.println("Accounts not write: "+e.getMessage());
        }
    }
    private static void readAccounts(){
        try{
            FileInputStream fi = new FileInputStream(new File("src/bank/accounts.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            accounts.clear();
            accounts = new ArrayList<>();
            while (true){
                Account ra = (Account) oi.readObject();
                if (ra!=null){
                    accounts.add(ra);
                }else{
                    break;
                }
            }
            oi.close();
            fi.close();
        }catch (Exception e){
            System.out.println("Accounts read completed!");
        }

    }
}
