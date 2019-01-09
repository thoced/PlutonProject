package controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;

//Controller du LoginForm
public class LoginFormCtrl {

    @FXML
    private Button loginButton;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField pwdField;
    @FXML
    private Label errorLabel;
    private Stage stage;

    private Boolean success = false;

    @FXML
    public void CancelButton_Click(){
        this.loginButton.getScene().getWindow().hide();
    }

    @FXML
    public void loginButton_Click(){

        //Tester le couple Login/MDP
        if(loginField.getText().compareTo("Police") == 0 && pwdField.getText().compareTo("Zp5278") == 0){
            this.success = true;
        }
        else
        {
            this.errorLabel.setVisible(true);
            return;
        }
        this.loginButton.getScene().getWindow().hide();
    }

    @FXML
    private void handleButtonAction(KeyEvent event) {
        // Button was clicked, do something…
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        this.pwdField.setOnKeyReleased(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER)
                    LoginFormCtrl.this.loginButton_Click();
            }
        });

        this.loginField.setOnKeyReleased(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER){
                    LoginFormCtrl.this.pwdField.requestFocus();
                }
            }
        });
    }

}
