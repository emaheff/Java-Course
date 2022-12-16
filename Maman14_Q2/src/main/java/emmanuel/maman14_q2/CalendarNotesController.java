package emmanuel.maman14_q2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarNotesController {
    private static final int START_YEAR = 2022, END_YEAR = 2030, DAYS_IN_WEEK = 7;

    @FXML
    private ComboBox<Integer> monthCombo;

    @FXML
    private ComboBox<Integer> yearCombo;

    @FXML
    private GridPane grid;
    private Button btn, dayBtn;

    @FXML
    void okBtn(ActionEvent event) {
        int year = yearCombo.getValue();
        int month = monthCombo.getValue();

        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1);
        int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        displayDaysInMonth(daysInMonth, dayOfWeek);
    }


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

    private void displayDaysInMonth(int daysInMonth, int dayOfWeek) {
        grid.getChildren().clear();
        List<Button> btns = createListOfBtns(daysInMonth);
        putBtnsOnGrid(btns, dayOfWeek);
        }
        private void putBtnsOnGrid(List<Button> btns, int dayOfWeek){
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

        private void handelButton(ActionEvent actionEvent){
            dayBtn = (Button) actionEvent.getSource();
            int day = Integer.parseInt(dayBtn.getText());
            System.out.println(day);
        }
        private List<Button> createListOfBtns(int daysInMonth){
            List<Button> btns = new ArrayList<>();
            for (int i = 1; i <= daysInMonth; i++) {
                btn = new Button("" + i);
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        handelButton(actionEvent);
                    }
                });
                btns.add(btn);
            }
            return btns;
        }

}
