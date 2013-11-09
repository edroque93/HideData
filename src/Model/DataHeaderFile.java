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
        File file = new File(fileName);

        if (!file.exists())
            throw new Exception("El fichero no se puede manipular: no existe");

        this.fileName = file.getName();
        this.fileSize = file.length();
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

}
