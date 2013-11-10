package Model;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileBuilder {

    private String destFile;
    private String originalFile;
    private String[] filesToHide;
    private byte[] original;
    private byte[] header;
    private byte[] files;

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

        header = dataHeader.getHeader();
        files = new byte[(int) dataHeader.getSizeOfFiles()]; // 2Gb max file

        FileOutputStream out = new FileOutputStream(destFile);

        out.write(Files.readAllBytes(Paths.get(originalFile)));
        out.write(header);
        for (String item : filesToHide)
            out.write(Files.readAllBytes(Paths.get(item)));

    }

}
