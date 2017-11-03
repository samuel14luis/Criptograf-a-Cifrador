package pruebas;

/**
 *
 * @author Alisoft
 */
public class Empleado implements Persona{

    public Empleado(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    private String nombre;
    private int edad;
    
    
    @Override
    public String getNombre() {
        return "Soy el empleado "+nombre;
    }

    @Override
    public int getEdad() {
        return edad;
    }
    
}
