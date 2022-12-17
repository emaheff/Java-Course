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
    private HashMap<String,String> hashMap = new HashMap<String,String>();

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

    private void handelButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("edit.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Add or edit note");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        btn = (Button) actionEvent.getSource();
        int day = Integer.parseInt(btn.getText());
        String date = day + "." + monthCombo.getValue() + "." + yearCombo.getValue();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Note");
        alert.setHeaderText("Date:\t" + date);
        if (hashMap.containsKey(date)){
            alert.setContentText(hashMap.get(date));
        }


        ButtonType okBtn = new ButtonType("OK");
        ButtonType editBtn = new ButtonType("Edit");
        alert.getButtonTypes().setAll(okBtn, editBtn);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == editBtn){
            TextInputDialog dialog = new TextInputDialog("Add a new note");
            if (hashMap.containsKey(date)) {
                dialog.getEditor().setText(hashMap.get(date));
            }
            dialog.getEditor().setPrefSize(500,200);
            dialog.getEditor().setAlignment(Pos.TOP_LEFT);
            dialog.getEditor().appendText("\n");
            dialog.setTitle("Note");
            dialog.setHeaderText("Add or edit your note");
            dialog.setContentText(null);
            Optional<String> result2 = dialog.showAndWait();
            if (result2.isPresent()){
                hashMap.put(date, result2.get());
            }
        }
    }

    private List<Button> createListOfBtns(int daysInMonth) {
        List<Button> btns = new ArrayList<>();
        for (int i = 1; i <= daysInMonth; i++) {
            btn = new Button("" + i);
            btn.setOnAction(new EventHandler<ActionEvent>() {
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



}
