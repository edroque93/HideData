package Model;

import java.io.File;

public class DataHeaderFile {

    private String fileName;
    private long fileSize;

    public DataHeaderFile() {
    }

    public DataHeaderFile(String file) throws Exception {
        this.setFileName(file);
    }

    public void setFileName(String fileName) throws Exception {
        if (!new File(fileName).exists())
            throw new Exception("El fichero no se puede manipular: no existe");
        
        this.fileName = fileName;
        this.fileSize = getFileSize();
    }

    public String getFileName() {
        return fileName;
    }

    private long getFileSize() {
        return new File(fileName).length();
    }

}
