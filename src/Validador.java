import java.io.File;

public class Validador {
    public static boolean isFileExists(String filePath) {
        File file = new File( filePath );
        return file.exists() && file.isFile();
    }
}