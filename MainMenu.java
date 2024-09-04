import java.util.Scanner;

public class MainMenu {
    private TelevisorManager manager;
    private Scanner scanner;

    public MainMenu() {
        manager = new TelevisorManager();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("=== Menú de Gestión de Televisores ===");
            System.out.println("1. Crear un televisor");
            System.out.println("2. Listar televisores");
            System.out.println("3. Borrar un televisor");
            System.out.println("4. Cambiar volumen de un televisor");
            System.out.println("5. Cambiar volumen de todos los televisores");
            System.out.println("6. Apagar o encender un televisor");
            System.out.println("7. Cambiar canal de un televisor");
            System.out.println("8. Cambiar canal de todos los televisores");
            System.out.println("9. Guardar configuración");
            System.out.println("10. Recuperar configuración");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearTelevisor();
                    break;
                case 2:
                    manager.listarTelevisores();
                    break;
                case 3:
                    borrarTelevisor();
                    break;
                case 4:
                    cambiarVolumenTelevisor();
                    break;
                case 5:
                    cambiarVolumenTodos();
                    break;
                case 6:
                    cambiarEstadoTelevisor();
                    break;
                case 7:
                    cambiarCanalTelevisor();
                    break;
                case 8:
                    cambiarCanalTodos();
                    break;
                case 9:
                    guardarConfiguracion();
                    break;
                case 10:
                    recuperarConfiguracion();
                    break;
                case 11:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 11);
    }

    private void crearTelevisor() {
        System.out.print("Ingrese la descripción del televisor: ");
        scanner.nextLine();  // Limpiar buffer
        String descripcion = scanner.nextLine();
        Televisor tv = new Televisor(descripcion);
        manager.agregarTelevisor(tv);
        System.out.println("Televisor creado con ID: " + tv.getId());
    }

    private void borrarTelevisor() {
        System.out.print("Ingrese el ID del televisor a borrar: ");
        String id = scanner.next();
        manager.borrarTelevisor(id);
        System.out.println("Televisor con ID " + id + " borrado.");
    }

    private void cambiarVolumenTelevisor() {
        // Similar a otros métodos, pero cambia el volumen de un televisor específico
    }

    private void cambiarVolumenTodos() {
        // Cambia el volumen de todos los televisores
    }

    private void cambiarEstadoTelevisor() {
        // Apaga o enciende un televisor
    }

    private void cambiarCanalTelevisor() {
        // Cambia el canal de un televisor específico
    }

    private void cambiarCanalTodos() {
        // Cambia el canal de todos los televisores
    }

    private void guardarConfiguracion() {
        // Llama a manager.guardarConfiguracion()
    }

    private void recuperarConfiguracion() {
        // Llama a manager.cargarConfiguracion()
    }
}
