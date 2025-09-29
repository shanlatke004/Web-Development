package bank.controller;

import bank.Driver;
import bank.model.Account;
import bank.model.AccountManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AccountController {
    @FXML private Label accountNoLabel;
    @FXML private Label balanceLabel;
    @FXML private Label emailLabel;
    @FXML private Label firstNameLable;
    @FXML private TextField fundsAmountTextField;
    @FXML private Label lastNameLabel;
    @FXML private Label phoneNoLabel;

    private Driver driver;
    private Account currentAccount;

    @FXML
    void fundsDepositButtonAction(ActionEvent event) {
        this.fundActions("deposit");
    }

    @FXML
    void fundsWithdrawButtonAction(ActionEvent event) {
        this.fundActions("withdraw");
    }

    @FXML
    void goBackButtonAction(ActionEvent event) {
        this.driver.loadMain(this.currentAccount);
    }

    @FXML
    void menuLoadTransaction(ActionEvent event) {
        this.driver.loadTransactions(this.currentAccount);
    }
    @FXML
    void menuLoadAbout(MouseEvent event) {
        System.out.println("About Method Call");
        this.driver.loadAbout();
    }


    @FXML
    void menuLoadMortgage(MouseEvent event){
        this.driver.loadMortgage(this.currentAccount);
        setAccount();
    }

    public void setDriver(Driver driver){
        this.driver = driver;
    }

    public void setCurrentAccount(Account currentAccount){
        this.currentAccount = currentAccount;
        setAccount();
    }

    private void fundActions(String action){
        if (isFundValid()){
            boolean isChange = false;
            int am = Integer.parseInt(fundsAmountTextField.getText());
            if(action.compareTo("withdraw")==0){
                if(currentAccount.getBalance()-am<0){
                    alert("Insufficient Balance","You don't have enough balance to withdraw");
                }else{
                    this.currentAccount.withDraw(am);
                    isChange = true;
                }
            }else if(action.compareTo("deposit")==0){
                this.currentAccount.deposit(am);
                isChange = true;
            }
            if(isChange){
                setAccount();
                fundsAmountTextField.setText("");
                Alert al = new Alert(Alert.AlertType.INFORMATION);
                al.setHeaderText("");
                al.setContentText("Success!");
                al.show();
            }
        }
    }

    private boolean isFundValid(){
        boolean toReturn = true;
        if (fundsAmountTextField.getText() == ""){
            toReturn = false;
            alert("Required", "Please enter amount first!");
        }else {
            try {
                double amount = Double.parseDouble(fundsAmountTextField.getText());
                if (amount<1){
                    toReturn = false;
                    alert("Wrong Input","Please enter non-negative amount");
                }

            }catch (NumberFormatException e){
                alert("Wrong Input", "Please enter amount in digits.");
                toReturn = false;
            }
        }

        return toReturn;
    }
    private void alert(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }
    private void setAccount(){
        this.accountNoLabel.setText(String.valueOf(currentAccount.getAccountNumber()));
        this.firstNameLable.setText(currentAccount.getFirstName());
        this.lastNameLabel.setText(currentAccount.getLastName());
        this.phoneNoLabel.setText(currentAccount.getPhone());
        this.emailLabel.setText(currentAccount.getEmail());
        this.balanceLabel.setText(String.valueOf(currentAccount.getBalance()));
    }

}
