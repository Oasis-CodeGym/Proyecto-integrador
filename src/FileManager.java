import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class FileManager {
    public static String readFile(String fileName) throws IOException {
        File documentToCipher = new File( fileName );
        String mensaje = Files.readString( documentToCipher.toPath() );
        return mensaje.toUpperCase();
    }

    public static String writeFile(String finalMessage) throws IOException {
        File documentoCifrado = new File( "Mensaje Cifrado.txt" );
        if (documentoCifrado.createNewFile()) {
            System.out.println( documentoCifrado + "Se ha creado el documento cifrado" );
        }
        try {
            FileWriter writer = new FileWriter( "Mensaje Cifrado.txt" );
            writer.write( finalMessage );
            writer.close();

        } catch (IOException e) {
            System.out.println( "Ocurrió un error" );
        }
        return null;
    }
}
