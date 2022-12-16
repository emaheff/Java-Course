package emmanuel.maman14_q2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalendarNotes extends Application {
    @Override
    public void start(Stage stage) throws  Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CalendarNotes.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("CalendarNotes");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}