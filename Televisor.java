import java.util.Random;

public class Televisor {
    private String id;
    private int canal;
    private int volumen;
    private String descripcion;
    private boolean encendido;

    public Televisor(String descripcion) {
        this.id = generarID();
        this.canal = 1;  // Canal por defecto
        this.volumen = 3;  // Volumen por defecto
        this.descripcion = descripcion;
        this.encendido = false;  // Estado inicial es apagado
    }

    private String generarID() {
        Random random = new Random();
        char letra1 = (char) ('A' + random.nextInt(26));
        char letra2 = (char) ('A' + random.nextInt(26));
        int num1 = random.nextInt(10);
        int num2 = random.nextInt(10);
        return "" + letra1 + letra2 + num1 + num2;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public int getCanal() { return canal; }
    public void setCanal(int canal) { this.canal = canal; }
    public int getVolumen() { return volumen; }
    public void setVolumen(int volumen) { this.volumen = volumen; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public boolean isEncendido() { return encendido; }
    public void setEncendido(boolean encendido) { this.encendido = encendido; }

    public void encender() {
        encendido = true;
    }

    public void apagar() {
        encendido = false;
    }

    public void cambiarCanal(int nuevoCanal) {
        if (encendido) {
            if (nuevoCanal >= 1 && nuevoCanal <= 999) {
                this.canal = nuevoCanal;
            } else {
                System.out.println("Canal inválido. Debe estar entre 1 y 999.");
            }
        } else {
            System.out.println("El televisor está apagado.");
        }
    }

    public void ajustarVolumen(int nuevoVolumen) {
        if (encendido) {
            if (nuevoVolumen >= 0 && nuevoVolumen <= 15) {
                this.volumen = nuevoVolumen;
            } else {
                System.out.println("Volumen inválido. Debe estar entre 0 y 15.");
            }
        } else {
            System.out.println("El televisor está apagado.");
        }
    }

    @Override
    public String toString() {
        return "Televisor [ID=" + id + ", Canal=" + canal + ", Volumen=" + volumen + ", Descripción=" + descripcion + ", Estado=" + (encendido ? "Encendido" : "Apagado") + "]";
    }
}
