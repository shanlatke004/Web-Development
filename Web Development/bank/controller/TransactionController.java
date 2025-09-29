package bank.controller;

import bank.Driver;
import bank.model.Account;
import bank.model.AccountManager;
import bank.model.Transaction;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionController implements Initializable {
    @FXML private TableView<Transaction> transactionTableview;
    @FXML private TableColumn<Transaction, Integer> idColumn;
    @FXML private TableColumn<Transaction, Integer> accountNoColumn;
    @FXML private TableColumn<Transaction, Double> amountColumn;
    @FXML private TableColumn<Transaction, String> typeColumn;
    @FXML private TableColumn<Transaction, String> dateTimeColumn;

    private Account currentAccount;
    private Driver driver;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.idColumn.setCellValueFactory(new PropertyValueFactory<Transaction, Integer>("id"));
        this.accountNoColumn.setCellValueFactory(new PropertyValueFactory<Transaction, Integer>("accountNo"));
        this.amountColumn.setCellValueFactory(new PropertyValueFactory<Transaction, Double>("amount"));
        this.typeColumn.setCellValueFactory(new PropertyValueFactory<Transaction, String>("type"));
        this.dateTimeColumn.setCellValueFactory(new PropertyValueFactory<Transaction, String>("dateTime"));

    }

    @FXML void goBackButtonAction(ActionEvent event) {
        this.driver.loadMain(this.currentAccount);
    }
    public void setDriver(Driver driver){
        this.driver = driver;
    }
    public void setCurrentAccount(Account currentAccount){
        this.currentAccount = currentAccount;
        this.transactionTableview.setItems(FXCollections.observableArrayList(currentAccount.getTransactions()));
    }

}
