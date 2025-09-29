package bank.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction implements Serializable {
    private int id;
    private int accountNo;
    private double amount;
    private String type;
    private String dateTime;


    public Transaction(int id, int accountNo, double amount, String type) {
        this.id = id;
        this.accountNo = accountNo;
        this.amount = amount;
        this.type = type;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.dateTime = LocalDateTime.now().format(dtf);
    }

    public int getId() {
        return id;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "model.Transaction{" +
                "id=" + id +
                ", accountNo=" + accountNo +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
