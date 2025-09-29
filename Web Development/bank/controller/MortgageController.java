package bank.controller;

import bank.model.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MortgageController {
    @FXML private TextField amountTextField;
    @FXML private Label mortgageAmountLabel;
    @FXML private TextField yearTextfield;

    private final int MORTGAGE_PERCENTAGE = 10;
    private Account currentAccount;
    private Stage stage;


    @FXML
    void saveButtonAction(ActionEvent event) {
        if (isValid()){
            int amount = Integer.parseInt(amountTextField.getText());
            this.currentAccount.mortgage(amount+(MORTGAGE_PERCENTAGE*amount));
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setHeaderText("");
            al.setContentText("Success!");
            al.show();
            this.stage.close();

        }
    }

    private boolean isValid(){
        boolean toReturn = true;
        if (amountTextField.getText() == "" || yearTextfield.getText() == ""){
            alert("Required!","All Fields are Required.");
            toReturn = false;
        }else{
            try {
                int amount = Integer.parseInt(amountTextField.getText());
                int year = Integer.parseInt(yearTextfield.getText());
                if (amount<=0 || year<=0){
                    toReturn = false;
                    alert("Wrong Input!","Please enter all positive values.");
                }
            }catch (NumberFormatException e){
                toReturn = false;
                alert("Wrong Input!","All inputs should be in numbers");
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

    public void setCurrentAccount(Account currentAccount){
        this.currentAccount = currentAccount;
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }

}
