import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InterfazPersonajes {

    private int fila = 1;
    private GridPane grid;

    public void mostrarInterfaz(Stage stage) {
        // CAMPOS
        TextField txtNombre = new TextField();
        TextField txtPoder = new TextField();
        TextField txtPlaneta = new TextField();
        TextField txtTecnica = new TextField();
        TextField txtEdad = new TextField();

        
        ComboBox<String> comboRaza = new ComboBox<>();
        comboRaza.getItems().addAll(
        "Saiyajin",
        "Humano",
        "Namekiano",
        "Androide",
        "Majin",
        "Freezer Race"
        );

        comboRaza.setValue("Seleccionar");
        

        Button btnAgregar = new Button("Agregar");
        btnAgregar.setStyle(
        "-fx-background-color: #ff6f00;" +
        "-fx-text-fill: white;" +
        "-fx-font-weight: bold;" +
        "-fx-background-radius: 10;"
        );

        // FORMULARIO
        GridPane formulario = new GridPane();
        formulario.setStyle(
        "-fx-background-color: #0d47a1;" +
        "-fx-padding: 20;" +
        "-fx-background-radius: 15;"
        );
        formulario.setVgap(10);
        formulario.setHgap(10);

        formulario.add(new Label("Nombre:"), 0, 0);
        formulario.add(txtNombre, 1, 0);

        formulario.add(new Label("Raza:"), 0, 1);
        formulario.add(comboRaza, 1, 1);

        formulario.add(new Label("Poder:"), 0, 2);
        formulario.add(txtPoder, 1, 2);

        formulario.add(new Label("Planeta:"), 0, 3);
        formulario.add(txtPlaneta, 1, 3);

        formulario.add(new Label("Técnica:"), 0, 4);
        formulario.add(txtTecnica, 1, 4);

        formulario.add(new Label("Edad:"), 0, 5);
        formulario.add(txtEdad, 1, 5);

        formulario.add(btnAgregar, 1, 6);

        
        grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(10);

        grid.add(new Label("Nombre"), 0, 0);
        grid.add(new Label("Raza"), 1, 0);
        grid.add(new Label("Poder"), 2, 0);
        grid.add(new Label("Planeta"), 3, 0);
        grid.add(new Label("Técnica"), 4, 0);
        grid.add(new Label("Edad"), 5, 0);
        

        
        btnAgregar.setOnAction(e -> {
            try {
                String nombre = txtNombre.getText();
                String raza = comboRaza.getValue();
                String planeta = txtPlaneta.getText();
                String tecnica = txtTecnica.getText();

                if (nombre.isEmpty() || planeta.isEmpty() || tecnica.isEmpty() || raza == null) {
                    mostrarError("Todos los campos son obligatorios");
                    return;
                }

                int poder = Integer.parseInt(txtPoder.getText());
                int edad = Integer.parseInt(txtEdad.getText());

                if (poder <= 0) {
                    mostrarError("El poder debe ser mayor que 0");
                    return;
                }

                if (edad <= 0) {
                    mostrarError("La edad debe ser mayor que 0");
                    return;
                }

                Personaje p = new Personaje(nombre, raza, poder, planeta, tecnica, edad);

                
                grid.add(new Label(p.getNombre()), 0, fila);
                grid.add(new Label(p.getRaza()), 1, fila);
                grid.add(new Label(String.valueOf(p.getNivelPoder())), 2, fila);
                grid.add(new Label(p.getPlanetaOrigen()), 3, fila);
                grid.add(new Label(p.getTecnicaEspecial()), 4, fila);
                grid.add(new Label(String.valueOf(p.getEdad())), 5, fila);

                fila++;

                
                txtNombre.clear();
                comboRaza.setValue(null);
                txtPoder.clear();
                txtPlaneta.clear();
                txtTecnica.clear();
                txtEdad.clear();

            } catch (NumberFormatException ex) {
                mostrarError("Poder y Edad deben ser números válidos");
            }
        });

       
        VBox root = new VBox(20);
        
        root.setPadding(new Insets(20));
        root.getChildren().addAll(formulario, grid);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Registro de Personajes Dragon Ball Z");
        stage.show();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}