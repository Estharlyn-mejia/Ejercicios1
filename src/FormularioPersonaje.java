import javafx.scene.control.Label;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class FormularioPersonaje {
    
    private VBox root;

    private TextField txtNombre;
    private ComboBox<String> cbRaza;
    private TextField txtPoder;
    private TextField txtPlaneta;
    private TextField txtTecnica;
    private TextField txtEdad;

    private GridPane tabla;
    private int fila = 1;

    public FormularioPersonaje() {
        root = new VBox(15);
        root.setStyle("-fx-background-color: #ff8c00;");
        root.setPadding(new Insets(20));

        Label titulo = new Label("REGISTRO DE PERSONAJE DRAGON BALL Z");
        titulo.setStyle("-fx-font-size: 22px;" +"-fx-text-fill: white;" +"-fx-font-weight: bold;");

        GridPane formulario = new GridPane();
        formulario.setHgap(10);
        formulario.setVgap(10);

        txtNombre = new TextField();
        txtPoder = new TextField();
        txtPlaneta = new TextField();
        txtTecnica = new TextField();
        txtEdad = new TextField();

        cbRaza = new ComboBox<>();
        cbRaza.getItems().addAll("Saiyajin", "Humano", "Namekiano", "Adroide", "Majin", "Frezer Race");

        Button agregar = new Button("Agregar");

        agregar.setStyle("-fx-background-color: #0033cc;" +"-fx-text-fill: white;" +"-fx-font-weight: bold;");

        formulario.add(new Label("Nombre:"), 0, 0);
        formulario.add(txtNombre, 1, 0);
        formulario.add(new Label("Raza:"), 0, 1);
        formulario.add(cbRaza, 1, 1);
        formulario.add(new Label("Poder:"), 0, 2);
        formulario.add(txtPoder, 1, 2);
        formulario.add(new Label("Planeta:"), 0, 3);
        formulario.add(txtPlaneta, 1, 3);
        formulario.add(new Label("Tecnica:"), 0, 4);
        formulario.add(txtTecnica, 1, 4);
        formulario.add(new Label("Edad"), 0, 5);
        formulario.add(txtEdad, 1, 5);

        formulario.add(agregar, 1, 6);

        tabla = new GridPane();
        tabla.setStyle("-fx-background-color: white;" + "-fx-padding: 10;" + "-fx-border-color: black;" + "-fx-border-width: 2;");
        tabla.setHgap(10);
        tabla.setVgap(10);

        Label h1 = new Label("Nombre");
        Label h2 = new Label("Raza");
        Label h3 = new Label("Poder");
        Label h4 = new Label("Planeta");
        Label h5 = new Label("Técnica");
        Label h6 = new Label("Edad");
        
        h1.setStyle("-fx-font-weight: bold;");
        h2.setStyle("-fx-font-weight: bold;");
        h3.setStyle("-fx-font-weight: bold;");
        h4.setStyle("-fx-font-weight: bold;");
        h5.setStyle("-fx-font-weight: bold;");
        h6.setStyle("-fx-font-weight: bold;");
        
        tabla.add(h1,0,0);
        tabla.add(h2,1,0);
        tabla.add(h3,2,0);
        tabla.add(h4,3,0);
        tabla.add(h5,4,0);
        tabla.add(h6,5,0);

        agregar.setOnAction(e -> agregarPersonaje());

        root.getChildren().addAll(titulo, formulario, new Label("PERSONAJES REGISTRADOS"), tabla);
    }

    private void agregarPersonaje(){
        if(txtNombre.getText().isEmpty() || txtPoder.getText().isEmpty() || txtPlaneta.getText().isEmpty() || txtTecnica.getText().isEmpty() || txtEdad.getText().isEmpty() || cbRaza.getValue() ==null){
            mostrarError("Ningun campo puede estra vacio");
        }
        int poder;
        int edad;
        try {
            poder = Integer.parseInt(txtPoder.getText());
            edad = Integer.parseInt(txtEdad.getText());
        } catch (Exception e) {
            mostrarError("Edad y poder deben ser numeros.");
            return;
        }
        if(poder <= 0 || edad <= 0){
            mostrarError("Edad y poder deben ser mayores a cero.");
            return;
        }

        Personaje p = new Personaje(txtNombre.getText(), cbRaza.getValue(), poder, txtPlaneta.getText(), txtTecnica.getText(), edad);

        tabla.add(new Label(p.getNombre()), 0, fila);
        tabla.add(new Label(p.getRaza()), 1, fila);
        tabla.add(new Label(String.valueOf(p.getNilvelPoder())), 2, fila);
        tabla.add(new Label(p.getPlanetaOrigen()), 3, fila);
        tabla.add(new Label(p.getTecnicaEspecial()), 4, fila);
        tabla.add(new Label(String.valueOf(p.getEdad())), 5, fila);

        fila ++;
        
        limpiar();
    }

    private void limpiar(){
        txtNombre.clear();
        txtPoder.clear();
        txtPlaneta.clear();
        txtTecnica.clear();
        txtEdad.clear();
        cbRaza.setValue(null);
    }

    private void mostrarError(String mensaje){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public VBox getVista(){
        return root;
    }
}
