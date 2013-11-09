package Main;

import Model.DataHeader;

/**
 * @author Quique, ThePirateCat
 */
public class HideData {

    public static void main(String[] args) throws Exception {
        //MainFrame finalframe = new MainFrame();

        DataHeader dh = new DataHeader();
        dh.addFile("C:\\a.txt");
        byte[] b = dh.getBytesOfHeader();

        for (int i = 0; i < b.length; i++) {
            byte c = b[i];
            System.out.print((0xFF & c)+",");
        }
    }

}
