public class MainMenu {
    private TelevisorManager televisorManager;
    private Scanner scanner;

    public MainMenu() {
        televisorManager = new TelevisorManager();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear televisor");
            System.out.println("2. Listar televisores");
            System.out.println("3. Borrar televisor");
            System.out.println("4. Cambiar volumen");
            System.out.println("5. Cambiar canal de todos los televisores");
            System.out.println("6. Guardar configuración");
            System.out.println("7. Cargar configuración");
            System.out.println("8. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearTelevisor();
                    break;
                // Otras opciones...
                case 8:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public void crearTelevisor() {
        System.out.println("Ingrese la descripción del televisor:");
        String descripcion = scanner.nextLine();
        televisorManager.crearTelevisor(descripcion);  // Llamada correcta al método
    }

    // Otros métodos del menú...
}
