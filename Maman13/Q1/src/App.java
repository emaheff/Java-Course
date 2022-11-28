import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
	
	public void start(Stage stage) throws Exception{

		Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));

		Scene scene = new Scene(root);
		stage.setTitle("App");
		stage.setScene(scene);
		stage.show();
	}
	State state = new State();
	public static void main(String[] args) {
		launch(args);
	}
}