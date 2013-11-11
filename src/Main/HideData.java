package Main;

import Model.DeconstructFile;
import Model.FileBuilder;

/**
 * @author Quique, ThePirateCat
 */
public class HideData {

    public static void main(String[] args) throws Exception {
        FileBuilder fb = new FileBuilder("C:\\output.png", "C:\\gato.png", new String[]{"C:\\Avatar.png", "C:\\asdf.txt"});
        fb.build();

        DeconstructFile df = new DeconstructFile("C:\\output.png");
        df.extractFile("C:\\SALIDA.png", "Avatar.png");
        df.extractFile("C:\\X.txt", "asdf.txt");
    }

}
