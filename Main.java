import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage stage) {
        Scene scene = new Scene(new ExpenseForm(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("Expense Tracker");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
