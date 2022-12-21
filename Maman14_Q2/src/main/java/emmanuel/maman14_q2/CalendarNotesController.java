package emmanuel.maman14_q2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.*;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

import java.util.*;

public class CalendarNotesController {
    private static final int START_YEAR = 2022, END_YEAR = 2030;
    private EventRepository repository;
    @FXML
    private ComboBox<Integer> monthCombo;

    @FXML
    private ComboBox<Integer> yearCombo;

    @FXML
    private GridPane grid;

    // global hashMap that saving the created buttons
    private HashMap<String, Button[]> earlierButtons = new HashMap<String, Button[]>();

    public CalendarNotesController() {
        this.repository = new EventRepository();
    }

    // this method display the part of the UI on a window
    public void initialize() {
        displayCombos();
    }

    private void displayCombos() {
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
    void okBtn() {
        int year = yearCombo.getValue();
        int month = monthCombo.getValue();

        String monthAndYear = "" + month + "." + year;

        Calendar date = Calendar.getInstance();
        date.set(year, month - 1, 1);

        displayDaysInMonth(date, monthAndYear);
    }

    // this method responsible is to get array of buttons (as much as required (depends on the month))
    // and then to send it to putBtnsOnGrid method to actually put the buttons on the gridPane
    private void displayDaysInMonth(Calendar date, String monthAndYear) {
        grid.getChildren().clear(); // clear the grid in case there are previous buttons
        Button[] btns;
        if (earlierButtons.containsKey(monthAndYear)) { // if true - that means that those buttons already initialized and contain important data
            btns = earlierButtons.get(monthAndYear);
        } else {
            btns = createArrayOfBtns(date); // initialise new array of buttons and store them in the earlierButtons hashMap
            earlierButtons.put(monthAndYear, btns);
        }
        putBtnsOnGrid(btns, date);
    }

    // this method returns list of buttons
    private Button[] createArrayOfBtns(Calendar date) {
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH) - 1;
        int daysInMonth = date.getActualMaximum(Calendar.DAY_OF_MONTH); // returns how many days in this month
        Button[] btns = new Button[daysInMonth];
        Font font = new Font(20);
        for (int i = 0; i < daysInMonth; i++) {
            Calendar dayInMonth = Calendar.getInstance();
            dayInMonth.set(year, month, i+1);
            Button btn = new Button("" + (i + 1));
            btn.setFont(font);
            btn.setOnAction(new EventHandler<ActionEvent>() { // make the button useful
                // this method send to another method to handle the buttons
                @Override
                public void handle(ActionEvent actionEvent) {
                    handelSelectedDayBtn(dayInMonth);
                }
            });
            btns[i] = btn;
        }
        return btns;
    }

    // this method get information from the pressed button and open a new UI window
    // that suppose to show the notes (if there are any) and to allow to edit the notes
    private void handelSelectedDayBtn(Calendar dayInMonth){

//        String event = repository.getEvent(dayInMonth);
//        TextArea textArea = editController.getTextArea();
//        textArea.setText(event);

        TextArea textArea = new TextArea();
        Event event = repository.getEvent(dayInMonth);
        if (event != null){
            textArea.setText(repository.getEvent(dayInMonth).getTitle());
        }
        openDialogWindow(dayInMonth, textArea);
    }

    // open the new dialog window
    private void openDialogWindow(Calendar date, TextArea textArea) {
        Font font = new Font(20);
        Label editLabel = new Label("Add or edit your note");
        editLabel.setFont(font);
//        textArea.setWrapText(true);
        Button saveBtn = new Button("Save");
        saveBtn.setFont(font);
        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                saveBtnPressed(actionEvent, textArea, date);
            }
        });
        VBox vBox = new VBox(10, editLabel, textArea, saveBtn);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    void saveBtnPressed(ActionEvent event, TextArea textArea, Calendar date) {
        String userInput = textArea.getText();
        Event event1 = new Event(date,userInput);
        repository.saveEvent(event1);

        // close the edit window
        Button btn = (Button) event.getSource();
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

    // the method puts the buttons in the right place on the gridPane
    private void putBtnsOnGrid(Button[] btns, Calendar date) {
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK); // returns what day of the week is the first day of that month
        int column = dayOfWeek - 1, row = 0;
        for (Button btn : btns) {
            if (column == 7) {
                column = 0;
                row++;
            }
            setBtnsSize(btn, column, row);
            grid.add(btn, column, row);
            column++;
        }
    }

    private void setBtnsSize(Button btn, int column, int row){
        GridPane.setHalignment(btn, HPos.CENTER);
        GridPane.setValignment(btn, VPos.CENTER);
        Bounds bounds = grid.getCellBounds(column, row);
        btn.setPrefWidth(bounds.getWidth());
        btn.setPrefHeight(bounds.getHeight());
    }
}