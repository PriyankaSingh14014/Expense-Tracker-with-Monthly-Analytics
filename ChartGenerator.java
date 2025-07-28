import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.util.*;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ChartGenerator {
    public static void showPieChart() {
        List<Expense> expenses = DatabaseHelper.getAllExpenses();
        Map<String, Double> categoryTotals = new HashMap<>();

        for (Expense ex : expenses) {
            categoryTotals.merge(ex.getCategory(), ex.getAmount(), Double::sum);
        }

        DefaultPieDataset dataset = new DefaultPieDataset();
        for (var entry : categoryTotals.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        JFreeChart chart = ChartFactory.createPieChart("Expense Distribution", dataset, true, true, false);
        showChart(chart);
    }

    public static void showBarChart() {
        List<Expense> expenses = DatabaseHelper.getAllExpenses();
        Map<String, Double> categoryTotals = new HashMap<>();

        for (Expense ex : expenses) {
            categoryTotals.merge(ex.getCategory(), ex.getAmount(), Double::sum);
        }

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (var entry : categoryTotals.entrySet()) {
            dataset.addValue(entry.getValue(), entry.getKey(), entry.getKey());
        }

        JFreeChart chart = ChartFactory.createBarChart("Expenses by Category", "Category", "Amount", dataset);
        showChart(chart);
    }

    private static void showChart(JFreeChart chart) {
        SwingNode swingNode = new SwingNode();
        SwingUtilities.invokeLater(() -> swingNode.setContent(new ChartPanel(chart)));

        StackPane pane = new StackPane(swingNode);
        Scene scene = new Scene(pane, 600, 400);

        Stage stage = new Stage();
        stage.setTitle("Chart");
        stage.setScene(scene);
        stage.show();
        stage.requestFocus();
    }
}
