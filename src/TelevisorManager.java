/* Bueno ahora vamos a administrar los televisores, siendo este el componente principal
 * Desde aca controlaremos y eliminaremos los televisores, de la misma manera sera el
 * control colectivo de la bateria de televisores, sera el milware con el menu principal
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelevisorManager {
    private List<Televisor> televisores;        // Esta es una lista objeto de los tv's
    private FileManager fileManager;            // Es una instancia para guardar y cargar las TV's

    public TelevisorManager() {
        televisores = new ArrayList<>();        // Iniciamos la lista de los TV's como un Array limpio y crea una 
        fileManager = new FileManager();        // instancia de FileManager para gestionar la persistencia de datos  
    }

   // Crear un nuevo televisor
   public void crearTelevisor(String descripcion) {
    Televisor nuevoTelevisor = new Televisor(descripcion);
    System.out.println("ID generado para el televisor: " + nuevoTelevisor.getId());
    System.out.println("¿Desea cambiar el ID generado? (s/n): ");

    Scanner scanner = new Scanner(System.in);
    String respuesta = scanner.nextLine();
    if (respuesta.equalsIgnoreCase("s")) {
        System.out.println("Ingrese el nuevo ID (formato: AB12): ");
        String nuevoId = scanner.nextLine();
        nuevoTelevisor.setId(nuevoId);
    }

    televisores.add(nuevoTelevisor);
    System.out.println("Televisor creado con éxito: " + nuevoTelevisor);
}

// Listar todos los televisores
public void listarTelevisores() {
    if (televisores.isEmpty()) {
        System.out.println("No hay televisores creados.");
    } else {
        for (Televisor tv : televisores) {
            System.out.println(tv);
        }
    }
}

// Borrar un televisor por su ID
public void borrarTelevisor(String id) {
    Televisor televisorAEliminar = buscarTelevisorPorId(id);
    if (televisorAEliminar != null) {
        televisores.remove(televisorAEliminar);
        System.out.println("Televisor con ID " + id + " eliminado.");
    } else {
        System.out.println("Televisor con ID " + id + " no encontrado.");
    }
}

// Buscar un televisor por ID
private Televisor buscarTelevisorPorId(String id) {
    for (Televisor tv : televisores) {
        if (tv.getId().equals(id)) {
            return tv;
        }
    }
    return null;
}

// Cambiar el volumen de un televisor o de todos los televisores
public void cambiarVolumen(String id, int nuevoVolumen) {
    if (id.equalsIgnoreCase("todos")) {
        for (Televisor tv : televisores) {
            tv.ajustarVolumen(nuevoVolumen);
        }
        System.out.println("Volumen cambiado a " + nuevoVolumen + " para todos los televisores.");
    } else {
        Televisor televisor = buscarTelevisorPorId(id);
        if (televisor != null) {
            televisor.ajustarVolumen(nuevoVolumen);
            System.out.println("Volumen cambiado a " + nuevoVolumen + " para el televisor con ID " + id);
        } else {
            System.out.println("Televisor con ID " + id + " no encontrado.");
        }
    }
}

// Establecer un canal para todos los televisores
public void establecerCanalParaTodos(int nuevoCanal) {
    for (Televisor tv : televisores) {
        tv.cambiarCanal(nuevoCanal);
    }
    System.out.println("Canal cambiado a " + nuevoCanal + " para todos los televisores.");
}

// Guardar configuración en un archivo CSV
public void guardarConfiguracion() {
    fileManager.guardarConfiguracion(televisores);
}

// Cargar configuración desde un archivo CSV
public void cargarConfiguracion() {
    televisores = fileManager.cargarConfiguracion();
}

// Encender un televisor por su ID
public void encenderTelevisor(String id) {
    Televisor televisor = buscarTelevisorPorId(id);
    if (televisor != null) {
        televisor.encender();
        System.out.println("Televisor con ID " + id + " encendido.");
    } else {
        System.out.println("Televisor con ID " + id + " no encontrado.");
    }
}

// Apagar un televisor por su ID
public void apagarTelevisor(String id) {
    Televisor televisor = buscarTelevisorPorId(id);
    if (televisor != null) {
        televisor.apagar();
        System.out.println("Televisor con ID " + id + " apagado.");
    } else {
        System.out.println("Televisor con ID " + id + " no encontrado.");
    }
}

// Cambiar de canal a un televisor por su ID
public void cambiarCanalTelevisor(String id, int nuevoCanal) {
    Televisor televisor = buscarTelevisorPorId(id);
    if (televisor != null) {
        televisor.cambiarCanal(nuevoCanal);
        System.out.println("Canal cambiado a " + nuevoCanal + " para el televisor con ID " + id);
    } else {
        System.out.println("Televisor con ID " + id + " no encontrado.");
    }
}
}