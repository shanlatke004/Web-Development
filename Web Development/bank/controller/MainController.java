package bank.controller;

import bank.Driver;
import bank.model.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {

    private Driver driver;
    private Account currentAccount;

    @FXML
    void viewAccountAction(ActionEvent event) {
        this.driver.loadAccount(this.currentAccount);
    }

    @FXML
    void viewTransactionAction(ActionEvent event) {
        this.driver.loadTransactions(currentAccount);
    }
    public void setCurrentAccount(Account currentAccount){
        this.currentAccount = currentAccount;
    }
    public void setDriver(Driver driver){
        this.driver = driver;
    }
}
