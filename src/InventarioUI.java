import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

public class InventarioUI {

    private ObservableList<Producto> productos = FXCollections.observableArrayList();

    // CAMPOS
    private TextField txtNombre = new TextField();
    private TextField txtPrecio = new TextField();
    private TextField txtCantidad = new TextField();

    private Button btnAgregar = new Button("Agregar");
    private Button btnEliminar = new Button("Eliminar fila");

    private Label lblError = new Label();

    
    private GridPane formulario = new GridPane();

    
    private TableView<Producto> tabla = new TableView<>();

    private VBox root;

    public InventarioUI() {
        inicializarUI();
        configurarEventos();
        cargarDatosIniciales();
    }

    private void inicializarUI() {
        formulario.setHgap(10);
        formulario.setVgap(10);

        formulario.add(new Label("Nombre:"), 0, 0);
        formulario.add(txtNombre, 1, 0);

        formulario.add(new Label("Precio:"), 0, 1);
        formulario.add(txtPrecio, 1, 1);

        formulario.add(new Label("Cantidad:"), 0, 2);
        formulario.add(txtCantidad, 1, 2);
        formulario.add(btnAgregar, 2, 2);

        formulario.setPadding(new Insets(10));
        formulario.setStyle("-fx-border-color: black;");

        // TABLA
        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");
        TableColumn<Producto, Double> colPrecio = new TableColumn<>("Precio");
        TableColumn<Producto, Integer> colCantidad = new TableColumn<>("Cantidad");

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        tabla.getColumns().addAll(colNombre, colPrecio, colCantidad);

        tabla.setItems(productos);

        tabla.setStyle("-fx-border-color: black;");

        // FORMATO PRECIO
        colPrecio.setCellFactory(col -> new TableCell<>() {
            @Override
            protected void updateItem(Double valor, boolean empty) {
                super.updateItem(valor, empty);
                setText(empty || valor == null ? null : String.format("%.2f", valor));
            }
        });

        HBox eliminarBox = new HBox(btnEliminar);
        eliminarBox.setPadding(new Insets(10));
        eliminarBox.setStyle("-fx-border-color:black;");
        eliminarBox.setSpacing(10);

        root = new VBox(10, formulario, tabla, eliminarBox, lblError);
        root.setPadding(new Insets(10));
    }

    private void configurarEventos() {
        
        btnAgregar.setOnAction(e -> {
            String nombre = txtNombre.getText().trim();

            try {
                double precio = Double.parseDouble(txtPrecio.getText());
                int cantidad = Integer.parseInt(txtCantidad.getText());

                productos.add(new Producto(nombre, precio, cantidad));

                txtNombre.clear();
                txtPrecio.clear();
                txtCantidad.clear();
                lblError.setText("");

            } catch (NumberFormatException ex) {
                lblError.setText("Precio y cantidad deben ser números");
            }
        });

        // BOTON ELIMINAR
        btnEliminar.setOnAction(e -> {
            Producto seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                productos.remove(seleccionado);
            }
        });
    }

    private void cargarDatosIniciales() {
        productos.add(new Producto("Laptop", 850.00, 5));
        productos.add(new Producto("Mouse", 12.50, 30));
        productos.add(new Producto("Teclado", 35.00, 15));
    }

    public VBox getRoot() {
        return root;
    }
}