package Model;

import java.util.HashSet;

public class DataHeaderFileSet extends HashSet<DataHeaderFile> {

    public int getSizeOfHeaderFileSet() {
        int sizeOfHeaderFileSet = 0;

        for (DataHeaderFile item : this)
            sizeOfHeaderFileSet += calcHeaderFileSize(item);

        return sizeOfHeaderFileSet;
    }

    public long getSizeOfFileSet() {
        long size = 0;

        for (DataHeaderFile item : this)
            size += item.getFileSize();

        return size;
    }

    private long calcHeaderFileSize(DataHeaderFile item) {
        return item.getFileName().length() + 1 + 4 * 2;
    }
}
