package emmanuel.maman14_q2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class EditController {

    private Calendar date;
    private EventRepository repository;

    @FXML
    private TextArea textArea = new TextArea();
    @FXML
    private Button saveBtn;

    private CalendarNotesController controller;


    // this method should save the string to the hashMap and close the dialog window
    @FXML
    void saveBtn(ActionEvent event) {
        Button btn = (Button) event.getSource();
        System.out.println(textArea.getText());

        // close the window
//        Stage stage = (Stage)saveBtn.getScene().getWindow();
//        stage.close();
    }

    public TextArea getTextArea() {
        return textArea;
    }

}