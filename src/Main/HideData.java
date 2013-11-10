package Main;

import Model.FileBuilder;

/**
 * @author Quique, ThePirateCat
 */
public class HideData {

    public static void main(String[] args) throws Exception {
        FileBuilder fb = new FileBuilder("C:\\output.png", "C:\\gato.png", new String[]{"C:\\Avatar.png"});
        //MainFrame finalframe = new MainFrame();
        /*
         DataHeader dh = new DataHeader();
         dh.addFile("C:\\a.txt");
         dh.addFile("C:\\asdf.txt");
         byte[] b = dh.getHeader();

         for (int i = 0; i < b.length; i++) {
         byte c = b[i];
         System.out.print((0xFF & c) + ",");
         }
         System.out.println();
         for (int i = 0; i < b.length; i++) {
         byte c = b[i];
         System.out.print((char) (0xFF & c) + ",");
         }*/
    }

}
