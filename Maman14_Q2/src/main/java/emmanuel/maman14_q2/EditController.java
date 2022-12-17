package emmanuel.maman14_q2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class EditController {

    @FXML
    private TextArea textArea = new TextArea();
    @FXML
    private Button saveBtn;

    private CalendarNotesController controller;

    // this method should save the string to the hashMap and close the dialog window
    @FXML
    void saveBtn(ActionEvent event) {
        // close the window
        Stage stage = (Stage)saveBtn.getScene().getWindow();
        stage.close();
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    public TextArea getTextArea() {
        return textArea;
    }

}