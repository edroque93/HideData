package Model;

import java.io.UnsupportedEncodingException;

/*
 DataHeader structure:

 trueHeader/11
 sizeOfHeader/4
 DataHeaderFileSet = [name/x & null/1 & size/8]+
 */
public class DataHeader {

    private final byte[] trueHeader = {
        0x48, 0x69, 0x64, 0x65, 0x44, 0x61, 0x74, 0x61, 8, 11, 13
    };
    private int sizeOfHeader;
    private DataHeaderFileSet files;

    public DataHeader() {
        files = new DataHeaderFileSet();
    }

    public void addFile(String file) throws Exception {
        files.add(new DataHeaderFile(file));
    }

    public byte[] getBytesOfHeader() throws UnsupportedEncodingException {
        calcSizeOfHeader();

        byte[] result = new byte[sizeOfHeader];

        System.arraycopy(trueHeader, 0, result, 0, trueHeader.length);
        result[trueHeader.length] = (byte) (sizeOfHeader >>> 24);
        result[trueHeader.length + 1] = (byte) (sizeOfHeader >>> 16);
        result[trueHeader.length + 2] = (byte) (sizeOfHeader >>> 8);
        result[trueHeader.length + 3] = (byte) (sizeOfHeader);

        int pointer = trueHeader.length + 4;
        byte[] buffer;
        long fileSize;

        for (DataHeaderFile item : files) {
            buffer = item.getFileName().getBytes("ASCII");
            System.arraycopy(buffer, 0, result, pointer, buffer.length);
            pointer += buffer.length;
            fileSize = item.getFileSize();
            result[pointer + 1] = (byte) (fileSize >>> 56);
            result[pointer + 2] = (byte) (fileSize >>> 48);
            result[pointer + 3] = (byte) (fileSize >>> 40);
            result[pointer + 4] = (byte) (fileSize >>> 32);
            result[pointer + 5] = (byte) (fileSize >>> 24);
            result[pointer + 6] = (byte) (fileSize >>> 16);
            result[pointer + 7] = (byte) (fileSize >>> 8);
            result[pointer + 8] = (byte) (fileSize);
        }

        return result;
    }

    private void calcSizeOfHeader() {
        sizeOfHeader = trueHeader.length;
        sizeOfHeader += 4;
        sizeOfHeader += files.getSizeOfHeaderFileSet();
    }

}
