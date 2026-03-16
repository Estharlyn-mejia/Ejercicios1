import javafx.scene.Scene;
import javafx.stage.Stage;

public class VentanaPrincipal {
    
    public void mostrar(Stage stage){

        FormularioPersonaje formularioPersonaje = new FormularioPersonaje();

        Scene escena = new Scene(formularioPersonaje.getVista(), 800, 500);

        stage.setTitle("Registro de personajes Dragon Ball Z");
        stage.setScene(escena);
        stage.show();
    }
}
