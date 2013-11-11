package Model;

import java.io.File;

public class DataHeaderFile implements Comparable<DataHeaderFile>{

    private String fileName;
    private long fileSize;

    public DataHeaderFile(String file) throws Exception {
        this.setFileName(file);
    }

    public DataHeaderFile(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public void setFileName(String fileName) throws Exception {
        File file = new File(fileName);

        if (!file.exists())
            throw new Exception("El fichero no se puede manipular: no existe");

        this.fileName = file.getName();
        this.fileSize = file.length();

    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    @Override
    public int compareTo(DataHeaderFile o) {
        return this.getFileName().compareTo(o.getFileName());
    }
}
