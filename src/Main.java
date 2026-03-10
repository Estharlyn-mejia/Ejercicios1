import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Personaje goku = new Personaje(
        "Goku",
        "Saiyajin",
        9000,
        "Vegeta",
        "Kamehameha",
        35);

        InterfazPersonajes interfaz = new InterfazPersonajes();
        interfaz.mostrarInterfaz(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}