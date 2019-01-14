package controllers;

import dao.DAOFactory;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.DossierModel;
import models.SectionModel;

import javax.swing.event.ChangeEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class MainFormCtrl implements PlutonController, Initializable, ChangeListener<TreeItem<SectionModel>> {

    private Stage stage;

    private  TreeItem root;
    private TreeItem rootCase;

    @FXML
    MenuItem menuClose;


    @FXML
    TreeView sectionTreeView;
    @FXML
    TreeView casesTreeView;

    @FXML
    SplitPane splitPane;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        /*if(!this.LogIn()){
            Platform.exit();
        }*/

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

    public void InitializeComponents(Stage stage) throws SQLException {
        this.stage = stage;

        //region Affichage des sections

        root = new TreeItem("Sections");
        rootCase = new TreeItem("Dossiers");

        this.sectionTreeView.setRoot(root);
        this.casesTreeView.setRoot(rootCase);


        this.sectionTreeView.getSelectionModel().selectedItemProperty().addListener(this);


        try {
            List<SectionModel> sections = DAOFactory.getInstance().getSectionDAO().selectAll(1,false);

            for(SectionModel section:sections){
                if(section.getId() == 1) continue;

                TreeItem item = new TreeItem(section);
                root.getChildren().add(item);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        root.setExpanded(true);

        //endregion

        // initialisation des menuItems
        menuClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.hide();
            }
        });

    }


    @Override
    public void changed(ObservableValue<? extends TreeItem<SectionModel>> observable, TreeItem<SectionModel> oldValue, TreeItem<SectionModel> newValue) {

        if(newValue == null)
            return;

        rootCase.getChildren().clear();

        if(newValue == root)
            return;

        try {
            List<DossierModel> dossiers = DAOFactory.getInstance().getDossierDAO().selectFromForeignKey(newValue.getValue().getId());

            for(DossierModel model : dossiers){
                TreeItem<DossierModel> itemDossier = new TreeItem<>();
                itemDossier.setValue(model);
                rootCase.getChildren().add(itemDossier);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
