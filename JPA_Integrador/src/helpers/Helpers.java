package helpers;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Helpers {

	// metodo utilizado para parsear la informacion de los archivos CSV

	public static CSVParser leerCSV(String ruta) {
        CSVParser parser = null;
        try {
            parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(ruta));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return parser;
    }

}
