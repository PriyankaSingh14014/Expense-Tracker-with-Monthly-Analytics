import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ExpenseForm extends VBox {
    private TableView<Expense> table;

    public ExpenseForm() {
        setPadding(new Insets(10));
        setSpacing(10);

        table = new TableView<>();
        TableColumn<Expense, String> dateCol = new TableColumn<>("Date");
        dateCol.setCellValueFactory(data -> data.getValue().dateProperty());

        TableColumn<Expense, String> catCol = new TableColumn<>("Category");
        catCol.setCellValueFactory(data -> data.getValue().categoryProperty());

        TableColumn<Expense, Number> amtCol = new TableColumn<>("Amount");
        amtCol.setCellValueFactory(data -> data.getValue().amountProperty());

        TableColumn<Expense, String> noteCol = new TableColumn<>("Note");
        noteCol.setCellValueFactory(data -> data.getValue().noteProperty());

        table.getColumns().addAll(dateCol, catCol, amtCol, noteCol);
        refreshTable();

        Button addBtn = new Button("Add Expense");
        addBtn.setOnAction(e -> ExpenseSummary.showAddDialog(() -> refreshTable()));

        Button deleteBtn = new Button("Delete Selected");
        deleteBtn.setOnAction(e -> {
            Expense selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                DatabaseHelper.deleteExpense(selected);
                refreshTable();
            }
        });

        Button exportBtn = new Button("Export CSV");
        exportBtn.setOnAction(e -> Utils.exportToCSV(table.getItems()));

        Button pieBtn = new Button("View Pie Chart");
        pieBtn.setOnAction(e -> ChartGenerator.showPieChart());

        Button barBtn = new Button("View Bar Chart");
        barBtn.setOnAction(e -> ChartGenerator.showBarChart());

        HBox controls = new HBox(10, addBtn, deleteBtn, exportBtn, pieBtn, barBtn);
        getChildren().addAll(table, controls);
    }

    private void refreshTable() {
        table.setItems(FXCollections.observableArrayList(DatabaseHelper.getAllExpenses()));
    }
}
