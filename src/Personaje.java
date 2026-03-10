
public class Personaje{

    private String nombre;
    private String raza;
    private int nivelPoder;
    private String planetaOrigen;
    private String tecnicaEspecial;
    private int edad;

    // Constructor
    public Personaje(String nombre, String raza, int nivelPoder, String planetaOrigen, String tecnicaEspecial, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.nivelPoder = nivelPoder;
        this.planetaOrigen = planetaOrigen;
        this.tecnicaEspecial = tecnicaEspecial;
        this.edad = edad;
    }

    // Getters

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public int getNivelPoder() {
        return nivelPoder;
    }

    public String getPlanetaOrigen() {
        return planetaOrigen;
    }

    public String getTecnicaEspecial() {
        return tecnicaEspecial;
    }

    public int getEdad() {
        return edad;
    }

    // Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setNivelPoder(int nivelPoder) {
        this.nivelPoder = nivelPoder;
    }

    public void setPlanetaOrigen(String planetaOrigen) {
        this.planetaOrigen = planetaOrigen;
    }

    public void setTecnicaEspecial(String tecnicaEspecial) {
        this.tecnicaEspecial = tecnicaEspecial;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}


