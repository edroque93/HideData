package Model;

import Persistence.LoadFile;

public class DeconstructFile {

    private final String file;
    private final DataHeader dataHeader;

    public DeconstructFile(String file) throws Exception {
        this.file = file;
        dataHeader = LoadFile.loadHeaderFromFile(file);
    }

    public void extractFile(String dest, String file) throws Exception {
        LoadFile.extractDataFromFile(dest, file);
    }

    public String[] getFiles() {
        return dataHeader.getFiles();
    }

}
