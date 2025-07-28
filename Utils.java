import javafx.collections.ObservableList;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static void exportToCSV(ObservableList<Expense> expenses) {
        try (FileWriter writer = new FileWriter("expenses.csv")) {
            writer.write("Date,Category,Amount,Note\n");
            for (Expense e : expenses) {
                writer.write(String.format("%s,%s,%.2f,%s\n",
                        e.getDate(), e.getCategory(), e.getAmount(), e.getNote()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
