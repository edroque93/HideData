package Model;

import Persistence.SaveFile;
import java.io.File;

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
    }

    public void build() throws Exception {
        DataHeader dataHeader = new DataHeader();

        for (String item : filesToHide)
            dataHeader.addFile(item);

        SaveFile.saveToFile(destFile, originalFile, dataHeader.getHeader(), filesToHide);
    }
}
