import javafx.beans.property.*;

public class Expense {
    public int id;
    private final StringProperty date;
    private final StringProperty category;
    private final DoubleProperty amount;
    private final StringProperty note;

    public Expense(int id, String date, String category, double amount, String note) {
        this.id = id;
        this.date = new SimpleStringProperty(date);
        this.category = new SimpleStringProperty(category);
        this.amount = new SimpleDoubleProperty(amount);
        this.note = new SimpleStringProperty(note);
    }

    public StringProperty dateProperty() {
        return date;
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public DoubleProperty amountProperty() {
        return amount;
    }

    public StringProperty noteProperty() {
        return note;
    }

    public String getDate() {
        return date.get();
    }

    public String getCategory() {
        return category.get();
    }

    public double getAmount() {
        return amount.get();
    }

    public String getNote() {
        return note.get();
    }
}
