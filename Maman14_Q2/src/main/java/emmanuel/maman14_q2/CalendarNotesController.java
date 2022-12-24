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
    private static final int START_YEAR = 2022, END_YEAR = 2030, DAYS_IN_A_WEEK = 7;
    private EventRepository repository;
    @FXML
    private ComboBox<Integer> monthCombo;
    @FXML
    private ComboBox<Integer> yearCombo;
    @FXML
    private GridPane grid;
    @FXML
    private TextField searchText;


    // global hashMap that saving the created buttons
    private HashMap<String, Button[]> earlierButtons = new HashMap<>();

    public CalendarNotesController() {
        this.repository = new EventRepository();
    }

    // display the combo boxes of years and months
    public void initialize() {
        for (int i = START_YEAR; i <= END_YEAR; i++) {
            yearCombo.getItems().add(i);
        }
        for (int i = 1; i <= 12; i++) {
            monthCombo.getItems().add(i);
        }
        yearCombo.setValue(START_YEAR);
        monthCombo.setValue(1);
    }

    // this method get the input (the month and year the user picked)
    // and call to displayDaysInMonth method
    @FXML
    void okBtn() {
        int year = yearCombo.getValue();
        int month = monthCombo.getValue() - 1;

        String monthAndYear = "" + month + "." + year;

        Calendar date = Calendar.getInstance();
        date.set(year, month, 1);

        displayDaysInMonth(date, monthAndYear);
    }

    // this method responsible is to get an array of buttons (as much as required (depends on the month))
    // from createArrayOfBtns and save them in earlierButtons hashMap or to get an array of buttons from
    // the same hashMap.
    // and then to send it to putBtnsOnGrid method to actually put the buttons on the gridPane
    private void displayDaysInMonth(Calendar date, String monthAndYear) {
        grid.getChildren().clear(); // clear the grid in case there are previous buttons
        Button[] btns;
        if (earlierButtons.containsKey(monthAndYear)) { // if true - that means that those buttons already initialized
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
        int month = date.get(Calendar.MONTH);
        int daysInMonth = date.getActualMaximum(Calendar.DAY_OF_MONTH); // returns how many days in this month
        Button[] btns = new Button[daysInMonth];
        Font font = new Font(20);
        for (int i = 0; i < daysInMonth; i++) {
            Calendar dayInMonth = Calendar.getInstance();
            dayInMonth.set(year, month, i + 1);
            Button btn = new Button("" + (i + 1));
            btn.setFont(font);
            btn.setOnAction(new EventHandler<ActionEvent>() {
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
    private void handelSelectedDayBtn(Calendar date) {
        TextArea textArea = new TextArea();
        Event event = repository.getEvent(date);
        if (event != null) {
            textArea.setText(event.getTitle());
        }
        Button saveBtn = new Button("Save");
        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                saveBtnPressed(actionEvent, textArea, date);
            }
        });
        openEventWindow(textArea, saveBtn);
    }

    // open the new event window
    private void openEventWindow(TextArea textArea, Button saveBtn) {
        Font font = new Font(20);
        Label editLabel = new Label("Add or edit your note");
        editLabel.setFont(font);
        saveBtn.setFont(font);
        VBox vBox = new VBox(10, editLabel, textArea, saveBtn);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    // this method save the content of the user input (new events or edited event)
    void saveBtnPressed(ActionEvent actionEvent, TextArea textArea, Calendar date) {
        String userInput = textArea.getText();
        if (!userInput.equals("")){
            Event event = new Event(date, userInput);
            repository.saveEvent(event);
        }
        closeWindow(actionEvent);
    }

    private void closeWindow(ActionEvent actionEvent){
        Button btn = (Button) actionEvent.getSource();
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

    // the method puts the buttons in the right place on the gridPane
    private void putBtnsOnGrid(Button[] btns, Calendar date) {
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK); // returns what day of the week is the first day of that month
        int column = dayOfWeek - 1, row = 0;
        for (Button btn : btns) {
            if (column == DAYS_IN_A_WEEK) {
                column = 0;
                row++;
            }
            setBtnsSize(btn, column, row);
            grid.add(btn, column, row);
            column++;
        }
    }

    // this method is responsible for displaying the right size of buttons on the grid
    private void setBtnsSize(Button btn, int column, int row) {
        GridPane.setHalignment(btn, HPos.CENTER);
        GridPane.setValignment(btn, VPos.CENTER);
        Bounds bounds = grid.getCellBounds(column, row);
        btn.setPrefWidth(bounds.getWidth());
        btn.setPrefHeight(bounds.getHeight());
    }

    // this method takes the user input and search the content in the hashMap that contain all the events
    @FXML
    void searchBtnPressed() {
        String userInput = searchText.getText();
        List<Event> titles = repository.findByTitle(userInput);
        Label foundedTitleLabel = new Label();
        if (titles.isEmpty() || userInput.equals("")) {
            foundedTitleLabel.setText("No results for this title");
        } else {
            String allFoundedTitles = "results that contains the search - \t" + userInput + "\n";
            for (Event e: titles) {
                allFoundedTitles += "\n" +  "Date: " + e.getDate().getTime() + "\n" + e.getTitle() + "\n";
            }
            foundedTitleLabel.setText(allFoundedTitles);
        }
        Button okBtn = new Button("Close");
        okBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                closeWindow(actionEvent);
            }
        });
        openResultsWindow(foundedTitleLabel, okBtn);
    }

    private void openResultsWindow(Label allTitles, Button okBtn){
        Font font = new Font(20);
        Label result = new Label("Results");
        result.setFont(font);
        okBtn.setFont(font);
        VBox vBox = new VBox(10, result, allTitles, okBtn);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);
        Stage stage = new Stage();
        stage.setWidth(500);
        stage.setHeight(700);
        vBox.setPrefWidth(stage.getWidth());
        vBox.setPrefHeight(stage.getHeight());
        allTitles.setPrefWidth(vBox.getPrefWidth());
        allTitles.setPrefHeight(vBox.getPrefHeight() - result.getHeight() - okBtn.getPrefHeight());
        allTitles.setAlignment(Pos.TOP_LEFT);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}