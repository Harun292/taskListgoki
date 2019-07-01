package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        TaskModel model = new TaskModel();
        model.initiate();
        Controller ctrl = new Controller(model);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sample.fxml"));
        loader.setController(ctrl);
        Parent root = loader.load();
        primaryStage.setTitle("Tasks");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.setMinHeight(250);
        primaryStage.setMinWidth(400);
        primaryStage.setMaxHeight(1000);
        primaryStage.setMaxWidth(1000);
        primaryStage.show();
        primaryStage.toFront();
        primaryStage.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
