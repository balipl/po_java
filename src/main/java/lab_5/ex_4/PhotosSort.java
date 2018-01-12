package lab_5.ex_4;

import io.indico.Indico;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PhotosSort {


    public static String[] Pobierz_zdjecia(String folderName) throws  IndicoException, NoDirectory,NoFile {
        Indico indico = new Indico("7b0d77a63655e6171a828c5050153c42");
        String[] paths;
        String folder = folderName;
        File dir = new File(folder);
        if (!(dir.exists())) {
            throw new NoDirectory("Brak takiego folderu");
        }
        File[] files = getFiles(folder);
        if (files.length == 0) {
            throw new NoFile("Brak zdjec w folderze");
        }
        paths = getPaths(files);
        return paths;
    }

        public Map<String,Double> Rozdzielaj(String path) throws IndicoException, IOException{
        Indico indico = new Indico("7b0d77a63655e6171a828c5050153c42");

            File file=new File(path);
            IndicoResult single = indico.imageRecognition.predict(file);
            Map<String, Double> result = single.getImageRecognition();
            return result;
    }


    private static String[] getPaths(File[] files) {
        String[] paths = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            paths[i] = files[i].getAbsolutePath();
        }
        return paths;
    }

    private static File[] getFiles(String folder) {
        File dir = new File(folder);
        return dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir1, String name) {
                return name.endsWith("jpg");
            }
        });
    }
}