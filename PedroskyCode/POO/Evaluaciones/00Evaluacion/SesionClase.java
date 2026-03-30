public class SesionClase {
    // Atributos privados 
    private String fecha;  // [cite: 12]
    private String bloque; // [cite: 12]

    // Constructor 
    public SesionClase(String fecha, String bloque) {
        this.fecha = fecha;
        this.bloque = bloque;
    }

    // Métodos Getter 
    public String getFecha() {
        return fecha;
    }

    public String getBloque() {
        return bloque;
    }
}