package Model;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileBuilder {

    private String destFile;
    private String originalFile;
    private String[] filesToHide;

    public FileBuilder(String destFile, String originalFile, String[] filesToHide) throws Exception {
        if (!new File(originalFile).exists())
            throw new Exception("El archivo original no existe");

        this.originalFile = originalFile;
        this.filesToHide = filesToHide;
        this.destFile = destFile;
        build();
    }

    private void build() throws Exception {
        DataHeader dataHeader = new DataHeader();

        for (String item : filesToHide)
            dataHeader.addFile(item);

        FileOutputStream out = new FileOutputStream(destFile);

        out.write(Files.readAllBytes(Paths.get(originalFile)));
        out.write(dataHeader.getHeader());
        for (String item : filesToHide)
            out.write(Files.readAllBytes(Paths.get(item)));
    }

}
