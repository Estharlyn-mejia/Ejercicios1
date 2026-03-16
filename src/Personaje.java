public class Personaje {
    
    private String nombre;
    private String raza;
    private int nivelPoder;
    private String planetaOrigen;
    private String tecnicaEspecial;
    private int edad;

    public Personaje(String nombre, String raza, int nivelPoder, String planetaOrigen, String tecnicaEspecial, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.nivelPoder = nivelPoder;
        this.planetaOrigen = planetaOrigen;
        this.tecnicaEspecial = tecnicaEspecial;
        this.edad = edad;
    }

    public String getNombre(){
        return nombre;
    }
    
    public String getRaza(){
        return raza;
    }

    public int getNilvelPoder(){
        return nivelPoder;
    }

    public String getPlanetaOrigen(){
        return planetaOrigen;
    }

    public String getTecnicaEspecial(){
        return tecnicaEspecial;
    }

    public int getEdad(){
        return edad;
    }
}
