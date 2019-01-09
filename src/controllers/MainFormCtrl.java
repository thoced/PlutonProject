package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormCtrl implements Initializable,PlutonControllers {

    private Stage stage;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        if(!this.LogIn()){
            Platform.exit();
        }

    }

    private boolean LogIn(){
        try {
            Stage loginForm = new Stage();
            loginForm.setTitle("Login");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/views/LoginForm.fxml"));
            Pane myPane = (Pane)loader.load();
            Scene scene = new Scene(myPane);
            loginForm.setResizable(false);
            loginForm.setIconified(false);
            loginForm.setScene(scene);
            loginForm.initStyle(StageStyle.UTILITY);
            LoginFormCtrl controller = loader.getController();
            controller.InitializeComponents(stage);
            loginForm.setAlwaysOnTop(true);
            loginForm.showAndWait();
            return controller.getSuccess();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public void InitializeComponents(Stage stage) {
        this.stage = stage;
    }
}
