package emmanuel.maman14_q2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class CalendarNotesController {
    private static final int START_YEAR = 2022, END_YEAR = 2030, DAYS_IN_WEEK = 7;

    @FXML
    private ComboBox<Integer> monthCombo;

    @FXML
    private ComboBox<Integer> yearCombo;

    @FXML
    private GridPane grid;
    private Button btn;
    private int day;
    private HashMap<String,String> hashMap = new HashMap<String,String>();

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

        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1);
        int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH); // returns how many days in this month
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK); // returns what day of the week is the first day of that month
        displayDaysInMonth(daysInMonth, dayOfWeek);
    }

    // this method responsible is to get list of buttons (as much as required (depends on the month))
    // and then to send it to putBtnsOnGrid(btns, dayOfWeek) method to actually put the buttons on the gridPane
    private void displayDaysInMonth(int daysInMonth, int dayOfWeek) {
        grid.getChildren().clear();
        List<Button> btns = createListOfBtns(daysInMonth);
        putBtnsOnGrid(btns, dayOfWeek);
    }

    // this method returns list of buttons
    private List<Button> createListOfBtns(int daysInMonth) {
        List<Button> btns = new ArrayList<>();
        for (int i = 1; i <= daysInMonth; i++) {
            btn = new Button("" + i);
            btn.setOnAction(new EventHandler<ActionEvent>() { // make the button useful
                // this method send to another method to handle the buttons
                @Override
                public void handle(ActionEvent actionEvent) {
                    try {
                        handelButton(actionEvent);
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
    private void handelButton(ActionEvent actionEvent) throws IOException {

        btn = (Button) actionEvent.getSource();
        day = Integer.parseInt(btn.getText());

        // need to work on it...
        // I want to know if there is a note that i already saved on the hashMap
        // if there are notes - it should be displayed on the texArea of the dialog window and be able to edit it
        // else the user should be able to add a note
        EditController ec = new EditController();
        TextArea te = ec.getTextArea();
        te.setText("yosi!");
        ec.setTextArea(te);
//        if (hashMap.containsKey(getDate())){
//            te.setText(hashMap.get(getDate()));
//        }
        openDialogWindow();
    }

    // open the new dialog window
    private void openDialogWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("edit.fxml"));
        Scene scene = new Scene(root);
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
    public String getDate() {
        String date = "" + day + "." + monthCombo.getValue() + "." + yearCombo.getValue();
        return date;
    }

    public HashMap<String, String> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }
}
