package Model;

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

    public byte[] getBytesOfHeader() {
        calcSizeOfHeader();

        byte[] result = new byte[sizeOfHeader];
        
        System.arraycopy(trueHeader, 0, result, 0, trueHeader.length);
        result[trueHeader.length+1] = (byte) (sizeOfHeader >>> 24);
        result[trueHeader.length+2] = (byte) (sizeOfHeader >>> 16);
        result[trueHeader.length+3] = (byte) (sizeOfHeader >>> 8);
        result[trueHeader.length+4] = (byte) (sizeOfHeader);
        // Faltan bytes...
        
        return result;
    }

    private void calcSizeOfHeader() {
        sizeOfHeader = trueHeader.length;
        sizeOfHeader += 4;
        sizeOfHeader += files.getSizeOfHeaderFileSet();
    }

}
