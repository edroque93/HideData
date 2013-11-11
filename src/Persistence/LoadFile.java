package Persistence;

import Model.DataHeader;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class LoadFile {

    private static DataHeader dataHeader;
    private static String origin;
    private static long headerPointer = 0;

    public static DataHeader loadHeaderFromFile(String file) throws Exception {
        origin = file;

        try (RandomAccessFile in = new RandomAccessFile(file, "r")) {
            dataHeader = new DataHeader();

            byte[] trueHeader = dataHeader.getTrueHeader();
            int buffer;
            int coincidences = 0;

            while ((buffer = in.read()) != -1)
                if (buffer == trueHeader[0])
                    coincidences = 1;
                else if (coincidences >= 1)
                    if (buffer == trueHeader[coincidences]) {
                        coincidences++;
                        if (coincidences == trueHeader.length)
                            break;
                    } else
                        coincidences = 0;

            if (coincidences == 0)
                throw new Exception("Header no encontrado en el fichero");

            int sizeOfHeader = 0;
            for (int i = 0; i < 4; i++)
                sizeOfHeader = sizeOfHeader << 8 | in.read();

            int bytesToRead = sizeOfHeader - 4 - trueHeader.length;

            byte[] fileList = new byte[bytesToRead];
            in.read(fileList);

            int i = 0;
            int fileIni;
            while (i < fileList.length) {
                fileIni = i;
                while (fileList[i] != 0)
                    i++;

                int size = 0;
                for (int c = 1; c <= 8; c++)
                    size = size << 8 | fileList[i + c];

                dataHeader.addFile(new String(Arrays.copyOfRange(fileList, fileIni, i), "ASCII"), size);
                i += 9;
            }

            headerPointer = in.getFilePointer();
        }

        return dataHeader;
    }

    public static void extractDataFromFile(String dest, String data) throws Exception {
        if (dataHeader == null)
            throw new Exception("Header no cargado");

        String[] list = dataHeader.getFiles();
        boolean found = false;

        for (String item : list)
            if (item.equals(data))
                found = true;

        if (!found)
            throw new Exception("Fichero no encontrado en header");

        try (RandomAccessFile in = new RandomAccessFile(origin, "r")) {
            long size = dataHeader.getSizeOfFile(data);
            long skip = 0;

            for (String item : list) {
                if (item.equals(data))
                    break;

                skip += dataHeader.getSizeOfFile(item);
            }

            in.seek(headerPointer + skip);

            try (FileOutputStream out = new FileOutputStream(dest)) {
                long i = 0;
                while (i++ < size)
                    out.write(in.read());
                out.close();
            }

            in.close();
        }
    }
}
