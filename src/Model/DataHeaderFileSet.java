package Model;

import java.util.HashSet;

public class DataHeaderFileSet extends HashSet<DataHeaderFile> {

    private int sizeOfHeaderFileSet;

    public int getSizeOfHeaderFileSet() {
        sizeOfHeaderFileSet = 0;

        for (DataHeaderFile item : this)
            sizeOfHeaderFileSet += calcHeaderFileSize(item);

        return sizeOfHeaderFileSet;
    }

    private long calcHeaderFileSize(DataHeaderFile item) {
        return item.getFileName().length() + 1 + 4;
    }
}
