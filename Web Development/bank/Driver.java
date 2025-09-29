package bank;

import bank.controller.*;
import bank.model.Account;
import bank.model.AccountManager;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Driver extends Application {

    private Stage primaryStage;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        try {
            VBox pane = (VBox) FXMLLoader.load(getClass().getResource("view/splash.fxml"));


            FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            fadeIn.setOnFinished((e) -> {
                fadeOut.play();
            });

            fadeOut.setOnFinished((e) -> {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("view/login.fxml"));
                    VBox root = (VBox)loader.load();
                    LoginController lc = loader.getController();
                    lc.setDriver(this);
                    Scene s=new Scene(root);
                    Stage stage = (Stage) pane.getScene().getWindow();

                    stage.setScene(s);
                    stage.setTitle("Login");
                } catch (Exception ex) {
                    System.out.println("Login not loaded: "+ex.getMessage());
                }
            });

            Scene scene = new Scene(pane);
            primaryStage.setTitle("Bank");
            primaryStage.getIcons().add(new Image(getClass().getResource("view/Bank.jpeg").toExternalForm()));
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e) {
            System.out.println("Splash Not Loaded: "+e.getMessage());
        }

    }
    public void loadMain(Account currentAccount){
        try {
            FXMLLoader loader = new FXMLLoader();
            System.out.println("Path: "+getClass().getResource("view/main.fxml"));
            loader.setLocation(getClass().getResource("view/main.fxml"));
            VBox root = (VBox)loader.load();
            MainController mc = loader.getController();
            mc.setDriver(this);
            mc.setCurrentAccount(currentAccount);
            Scene s=new Scene(root);
            primaryStage.setScene(s);
            primaryStage.setTitle("Bank");
        } catch (Exception ex) {
            System.out.println("Main not loaded: "+ex.getMessage());
        }

    }
    public void loadTransactions( Account currentAccount){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/transaction.fxml"));
            VBox root = (VBox)loader.load();
            TransactionController tc = loader.getController();
            tc.setDriver(this);
            tc.setCurrentAccount(currentAccount);
            Scene s=new Scene(root);
            primaryStage.setScene(s);
            primaryStage.setTitle("Transactions");
        } catch (Exception ex) {
            System.out.println("Transaction not loaded: "+ex.getMessage());
        }
    }
    public void loadAccount(Account currentAccount){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/account.fxml"));
            VBox root = (VBox)loader.load();
            AccountController ac = loader.getController();
            ac.setDriver(this);
            ac.setCurrentAccount(currentAccount);
            Scene s=new Scene(root);
            primaryStage.setScene(s);
            primaryStage.setTitle("My Account");
        } catch (Exception ex) {
            System.out.println("Account not loaded: "+ex.getMessage());
        }
    }
    public void loadAbout(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/about.fxml"));
            VBox root = (VBox)loader.load();

            Scene s=new Scene(root);
            Stage stage = new Stage();
            stage.setScene(s);
            stage.setTitle("About");
            stage.getIcons().add(new Image(getClass().getResource("view/Bank.jpeg").toExternalForm()));
            stage.initOwner(primaryStage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (Exception ex) {
            System.out.println("About not loaded: "+ex.getMessage());
        }
    }
    public void loadMortgage(Account currentAccount){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/mortgage.fxml"));
            VBox root = (VBox)loader.load();
            MortgageController mc = loader.getController();
            Scene s = new Scene(root);
            Stage stage = new Stage();
            mc.setStage(stage);
            mc.setCurrentAccount(currentAccount);
            stage.setScene(s);
            stage.setTitle("Mortgage");
            stage.getIcons().add(new Image(getClass().getResource("view/Bank.jpeg").toExternalForm()));
            stage.initOwner(primaryStage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
        } catch (Exception ex) {
            System.out.println("About not loaded: "+ex.getMessage());
        }
    }
}