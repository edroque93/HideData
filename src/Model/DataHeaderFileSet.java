package Model;

import java.util.TreeSet;

public class DataHeaderFileSet extends TreeSet<DataHeaderFile> {

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

    public String[] getFiles() {
        String[] result = new String[this.size()];
        int i = 0;

        for (DataHeaderFile item : this)
            result[i++] = item.getFileName();

        return result;
    }

    public long getSizeOfFile(String file) {
        for (DataHeaderFile item : this)
            if (item.getFileName().equalsIgnoreCase(file))
                return item.getFileSize();

        return 0;
    }

    private long calcHeaderFileSize(DataHeaderFile item) {
        return item.getFileName().length() + 1 + 4 * 2;
    }
}
