package pruebas;

/**
 *
 * @author Alisoft
 */
public class Empresario implements Persona{
    private String nombre;
    private int edad;

    public Empresario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    @Override
    public String getNombre() {
        return "Soy el empresario " + nombre;
    }

    @Override
    public int getEdad() {
        return edad;
    }
    
    
}
