/* La clase Televisor representa un televisor en el programa. 
* Cada instancia de esta clase contiene la información y funcionalidades 
* de un televisor individual que se puede gestionar a través del menú interactivo. 
* Esta clase tiene atributos y métodos que permiten manipular la información del 
* televisor, como cambiar de canal, ajustar el volumen, encenderlo, apagarlo, etc.
*/
import java.util.Random;

public class Televisor {
    /*Vamos a iniciar con los metadatos del Televisor */

    private String id;              // Representa el ID del Televisor
    private int canal;              // Representa el canal actual que va del  1 al 999
    private int volumen;            // Representa el estado actual del volumen 
    private String descripcion;     // Representa el campo de la descripcion del mismo
    private boolean encendido;      // Representa el estado encendido o apagado (Boleano)

    public Televisor(String descripcion) {
        this.id = generarID();
        this.canal = 1;  // Canal por defecto
        this.volumen = 3;  // Volumen por defecto
        this.descripcion = descripcion;
        this.encendido = false;  // Estado inicial es apagado
    }

    /*Ahora vamos a generar el ID del Televisor con Random!!
     * La regla impuesta es dos caracteres  dos digitos numericos
     * Los mismo podran ser cambiados si es necesario
     */

    private String generarID() {
        Random random = new Random();
        char letra1 = (char) ('A' + random.nextInt(26));
        char letra2 = (char) ('A' + random.nextInt(26));
        int num1 = random.nextInt(10);
        int num2 = random.nextInt(10);
        return "" + letra1 + letra2 + num1 + num2;
    }

    /*Los métodos "getter" y "setter" permiten acceder y modificar los 
    * atributos privados de la clase. 
    */

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

    /* Vamos a iniciar con el control del televisor, encender, apagar, cambiar de canal
     * ajuste de volumen!
     */

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
