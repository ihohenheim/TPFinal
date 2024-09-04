/*Con esta clase estaremos manejando los archivos de configuracion basados en archivos CSV */

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String FILE_PATH = "configuracion_televisores.csv";  // Ruta del archivo CSV

    // Método para guardar la configuración de los televisores en un archivo CSV
    public void guardarConfiguracion(List<Televisor> televisores) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(FILE_PATH))) {
            // Encabezados del archivo CSV
            String[] header = {"ID", "Canal", "Volumen", "Descripción", "Estado"};
            writer.writeNext(header);

            // Escribiendo los datos de cada televisor en el archivo CSV
            for (Televisor tv : televisores) {
                String[] data = {
                        tv.getId(),
                        String.valueOf(tv.getCanal()),
                        String.valueOf(tv.getVolumen()),
                        tv.getDescripcion(),
                        tv.isEncendido() ? "Encendido" : "Apagado"
                };
                writer.writeNext(data);
            }

            System.out.println("Configuración guardada exitosamente en " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error al guardar la configuración: " + e.getMessage());
        }
    }

    // Método para cargar la configuración de los televisores desde un archivo CSV
    public List<Televisor> cargarConfiguracion() {
        List<Televisor> televisores = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(FILE_PATH))) {
            String[] nextLine;
            reader.readNext();  // Saltar la primera línea de encabezados

            while ((nextLine = reader.readNext()) != null) {
                String id = nextLine[0];
                int canal = Integer.parseInt(nextLine[1]);
                int volumen = Integer.parseInt(nextLine[2]);
                String descripcion = nextLine[3];
                boolean encendido = nextLine[4].equalsIgnoreCase("Encendido");

                // Crear un nuevo televisor basado en los datos leídos
                Televisor tv = new Televisor(descripcion);
                tv.setId(id);  // Establecer ID desde el archivo
                tv.setCanal(canal);
                tv.setVolumen(volumen);
                tv.setEncendido(encendido);

                televisores.add(tv);
            }

            System.out.println("Configuración cargada exitosamente desde " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error al cargar la configuración: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error en el formato de los datos: " + e.getMessage());
        }

        return televisores;
    }
}
