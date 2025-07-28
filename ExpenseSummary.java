import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.function.*;

public class ExpenseSummary {
    public static void showAddDialog(Runnable onSave) {
        Stage stage = new Stage();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        DatePicker datePicker = new DatePicker(LocalDate.now());
        TextField categoryField = new TextField();
        TextField amountField = new TextField();
        TextField noteField = new TextField();

        grid.add(new Label("Date:"), 0, 0);
        grid.add(datePicker, 1, 0);
        grid.add(new Label("Category:"), 0, 1);
        grid.add(categoryField, 1, 1);
        grid.add(new Label("Amount:"), 0, 2);
        grid.add(amountField, 1, 2);
        grid.add(new Label("Note:"), 0, 3);
        grid.add(noteField, 1, 3);

        Button saveBtn = new Button("Save");
        saveBtn.setOnAction(e -> {
            String date = datePicker.getValue().toString();
            String category = categoryField.getText();
            double amount = Double.parseDouble(amountField.getText());
            String note = noteField.getText();
            DatabaseHelper.addExpense(date, category, amount, note);
            onSave.run();
            stage.close();
        });

        grid.add(saveBtn, 1, 4);
        stage.setScene(new Scene(grid));
        stage.setTitle("Add Expense");
        stage.show();
    }
}
