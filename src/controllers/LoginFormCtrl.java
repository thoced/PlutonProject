package controllers;

import dao.DAO;
import dao.DAOFactory;
import dao.UserDAO;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import models.UserModel;
import org.apache.commons.codec.digest.DigestUtils;


//Controller du LoginForm
public class LoginFormCtrl implements PlutonController {


    //region Membres
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

    //endregion

    //region Evénements

    @FXML
    public void CancelButton_Click(){
        this.loginButton.getScene().getWindow().hide();
    }

    @FXML
    public void loginButton_Click(){
        DAO user = DAOFactory.getInstance().getUserDAO();
        UserModel model = ((UserDAO)user).find(this.loginField.getText());
        String userPwd = DigestUtils.md5Hex(pwdField.getText());
        if(userPwd.equals(model.getPassword())){
            this.success = true;
            this.loginButton.getScene().getWindow().hide();
        }
        else
            this.errorLabel.setVisible(true);
    }

    private void loginField_KeyPress(javafx.scene.input.KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER)
            this.pwdField.requestFocus();

    }

    private void pwdField_KeyPress(javafx.scene.input.KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER)
            LoginFormCtrl.this.loginButton_Click();

    }

    //endregion

    //region getters/setters

    Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    //endregion

    public void InitializeComponents(Stage stage) {
        this.stage = stage;

        this.pwdField.setOnKeyReleased(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent event) {LoginFormCtrl.this.pwdField_KeyPress(event);}
        });

        this.loginField.setOnKeyReleased(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent event) {LoginFormCtrl.this.loginField_KeyPress(event);}
        });
    }

}
