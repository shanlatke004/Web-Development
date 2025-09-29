package bank.controller;

import bank.Driver;
import bank.model.Account;
import bank.model.AccountManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private TextField accountTextField;
    @FXML private Label loginValidLabel;

    private Driver driver;
    private Account currentAccount;

    @FXML void loginButtonAction(ActionEvent event) {
        if (isValid()){
            this.driver.loadMain(currentAccount);
        }
    }//loginButtonAction

    public void setDriver(Driver driver){
        this.driver = driver;
    }
    private boolean isValid(){
        boolean toReturn  = true;
        if (accountTextField.getText() == ""){
            showLabel("All Fields are required!");
            toReturn = false;
        }else{
            try {
                int accountNo = Integer.parseInt(accountTextField.getText());
                currentAccount = AccountManager.getAccount(accountNo);
                if (currentAccount==null){
                    showLabel("Account does not exist!");
                    toReturn = false;
                }

            }catch (NumberFormatException e){
                showLabel("Enter account in numbers!");
                toReturn = false;
            }
        }
        return toReturn;
    }
    private void showLabel(String msg){
        loginValidLabel.setVisible(true);
        loginValidLabel.setText(msg);
    }

}
