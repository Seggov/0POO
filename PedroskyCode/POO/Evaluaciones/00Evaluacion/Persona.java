public class Persona {
    // Atributos privados para cumplir con el encapsulamiento 
    private String nombre; // [cite: 11]
    private String rut;    // [cite: 11]

    // Constructor para inicializar los datos
    public Persona(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    // Métodos Getter para obtener los datos desde otras clases 
    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }
}