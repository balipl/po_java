package lab_5.ex_4;

import io.indico.api.utils.IndicoException;

public class Test {

    public static void main(String[] argv) {
        try {
            PhotosSort.PhotosSort("/home/grove/Pobrane/foto");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
