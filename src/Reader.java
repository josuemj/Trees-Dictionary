import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

    /**
     * Return lines of txt.
     * @return
     */
    public static ArrayList<String> leer() {
        ArrayList<String> lineas = new ArrayList<>();

        try {
            File archivo = new File("procesos.txt");
            Scanner scan = new Scanner(archivo);

            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                lineas.add(linea);
            }
            scan.close();

        } catch (Exception e) {
            System.out.println("Error en: " + e.getMessage());
        }
        return lineas;
    }
}
