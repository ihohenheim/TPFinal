import java.util.ArrayList;
import java.util.List;

public class TelevisorManager {
    private List<Televisor> televisores;

    public TelevisorManager() {
        televisores = new ArrayList<>();
    }

    public void agregarTelevisor(Televisor tv) {
        televisores.add(tv);
    }

    public void listarTelevisores() {
        if (televisores.isEmpty()) {
            System.out.println("No hay televisores registrados.");
        } else {
            for (Televisor tv : televisores) {
                System.out.println(tv);
            }
        }
    }

    public void borrarTelevisor(String id) {
        televisores.removeIf(tv -> tv.getId().equals(id));
    }

    public Televisor buscarTelevisorPorID(String id) {
        for (Televisor tv : televisores) {
            if (tv.getId().equals(id)) {
                return tv;
            }
        }
        return null;
    }

    public void cambiarVolumenTodos(int volumen) {
        for (Televisor tv : televisores) {
            tv.ajustarVolumen(volumen);
        }
    }

    public void cambiarCanalTodos(int canal) {
        for (Televisor tv : televisores) {
            tv.cambiarCanal(canal);
        }
    }

    public void guardarConfiguracion(String rutaArchivo) {
        // Implementación para guardar la configuración en un archivo CSV.
    }

    public void cargarConfiguracion(String rutaArchivo) {
        // Implementación para cargar la configuración desde un archivo CSV.
    }
}
