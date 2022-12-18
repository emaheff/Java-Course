package emmanuel.maman14_q2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class CalendarNotesController {
    private static final int START_YEAR = 2022, END_YEAR = 2030, DAYS_IN_WEEK = 7;
    private EventRepository repository = new EventRepository();
    private EditController editController = new EditController();
    @FXML
    private ComboBox<Integer> monthCombo;

    @FXML
    private ComboBox<Integer> yearCombo;

    @FXML
    private GridPane grid;


    // this method display the part of the UI on a window
    public void initialize() {
        showCombo();
    }

    private void showCombo() {
        for (int i = START_YEAR; i <= END_YEAR; i++) {
            yearCombo.getItems().add(i);
        }
        for (int i = 1; i <= 12; i++) {
            monthCombo.getItems().add(i);
        }
        yearCombo.setValue(START_YEAR);
        monthCombo.setValue(1);
    }

    // this method get the input (the month and the year that the user picked)
    // analysing how many days in this month, what day in the week is the first day of the month
    // and send those parameters to  displayDaysInMonth(daysInMonth, dayOfWeek) method
    @FXML
    void okBtn(ActionEvent event) {
        int year = yearCombo.getValue();
        int month = monthCombo.getValue();

        Calendar date = Calendar.getInstance();
        date.set(year, month - 1, 1);

        displayDaysInMonth(date);
    }

    // this method responsible is to get list of buttons (as much as required (depends on the month))
    // and then to send it to putBtnsOnGrid(btns, dayOfWeek) method to actually put the buttons on the gridPane
    private void displayDaysInMonth(Calendar date) {
        grid.getChildren().clear();
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK); // returns what day of the week is the first day of that month
        List<Button> btns = createListOfBtns(date);
        putBtnsOnGrid(btns, dayOfWeek);
    }

    // this method returns list of buttons
    private List<Button> createListOfBtns(Calendar date) {
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH) -1;
        int daysInMonth = date.getActualMaximum(Calendar.DAY_OF_MONTH); // returns how many days in this month
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK); // returns what day of the week is the first day of that month
        List<Button> btns = new ArrayList<>();
        for (int i = 1; i <= daysInMonth; i++) {
            Calendar dayInMonth = Calendar.getInstance();
            dayInMonth.set(year, month, i);
            Button btn = new Button("" + i);
            btn.setOnAction(new EventHandler<ActionEvent>() { // make the button useful
                // this method send to another method to handle the buttons
                @Override
                public void handle(ActionEvent actionEvent) {
                    try {
                        handelButton(actionEvent,dayInMonth);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            btns.add(btn);
        }
        return btns;
    }

    // this method get information from the pressed button and open a new UI window
    // that suppose to show the notes (if there are any) and to allow to edit the notes
    private void handelButton(ActionEvent actionEvent, Calendar dayInMonth) throws IOException {
        String event = repository.getEvent(dayInMonth);
        TextArea textArea = editController.getTextArea();
        textArea.setText(event);
        openDialogWindow(dayInMonth);
    }

    // open the new dialog window
    private void openDialogWindow(Calendar date) throws IOException {
        VBox root = (VBox) FXMLLoader.load(getClass().getResource("edit.fxml"));
        root.getChildren().remove(1);
        TextArea textArea = editController.getTextArea();
        textArea.setText("uriel");
        root.getChildren().add(textArea);
        Node temp = root.getChildren().remove(1);
        root.getChildren().add(temp);
        Scene scene = new Scene(root);

        scene.setUserData(date);
        Stage stage = new Stage();
        stage.setTitle("Add or edit note");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    // the method puts the buttons in the right place on the gridPane
    private void putBtnsOnGrid(List<Button> btns, int dayOfWeek) {
        int column = dayOfWeek - 1, row = 0;
        while (!btns.isEmpty()) {
            if (column == 7) {
                column = 0;
                row++;
            }
            GridPane.setHalignment(btns.get(0), HPos.CENTER);
            GridPane.setValignment(btns.get(0), VPos.CENTER);
            Bounds bounds = grid.getCellBounds(column, row);
            btns.get(0).setPrefWidth(bounds.getWidth());
            btns.get(0).setPrefHeight(bounds.getHeight());
            grid.add(btns.get(0), column, row);
            btns.remove(btns.get(0));
            column++;
        }
    }

    // dont know if i need those...


//    public HashMap<String, String> getEvents() {
//        return events;
//    }
//
//    public void setEvents(HashMap<String, String> events) {
//        this.events = events;
//    }
}
