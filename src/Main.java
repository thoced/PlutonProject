import controllers.LoginFormCtrl;
import controllers.MainFormCtrl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/MainForm.fxml"));
        Parent root = loader.load();
        MainFormCtrl controller = loader.getController();
        controller.setStage(primaryStage);
        primaryStage.setTitle("Pluton Project");
        primaryStage.setScene(new Scene(root, 600, 325));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
