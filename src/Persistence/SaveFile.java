package Persistence;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SaveFile {

    public static void saveToFile(String dest,
            String original,
            byte[] header,
            String[] files) throws IOException {

        FileOutputStream out = new FileOutputStream(dest);

        out.write(Files.readAllBytes(Paths.get(original)));
        out.write(header);
        for (String file : files)
            out.write(Files.readAllBytes(Paths.get(file)));
        out.close();
    }
}
