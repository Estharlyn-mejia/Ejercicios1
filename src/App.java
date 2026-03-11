import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        InventarioUI ui = new InventarioUI();

        Scene scene = new Scene(ui.getRoot(), 500, 400);

        stage.setTitle("Inventario");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
