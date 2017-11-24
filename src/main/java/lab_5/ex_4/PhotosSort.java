package lab_5.ex_4;

import io.indico.Indico;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PhotosSort {

    public static void PhotosSort(String folderName) throws IndicoException, NoDirectory, NoFile {
        Indico indico = new Indico("7b0d77a63655e6171a828c5050153c42");

        String folder = folderName;
        File dir = new File(folder);
        if(!(dir.exists())){
            throw new NoDirectory("Brak takiego folderu");
        }
        File[] files = getFiles(folder);
        if(files.length == 0){
            throw new NoFile("Brak zdjec w folderzre");
        }
        String[] paths = getPaths(files);

        BatchIndicoResult multiple = null;


        try{
            multiple = indico.imageRecognition.predict(paths);
        }catch (IOException e){e.printStackTrace();}

        List<Map<String, Double>> results = multiple.getImageRecognition();
        int i = 0;
        for (Map<String, Double> map:
                results) {
            String output = "";
            double maxValue = 0;
            Iterator it = map.entrySet().iterator();

            while(it.hasNext()){
                Map.Entry pair = (Map.Entry) it.next();
                if( (double) pair.getValue() > maxValue){
                    maxValue = (double) pair.getValue();
                    output = pair.getKey().toString();
                    System.out.println(output + maxValue);
                }



            }
            String exitPath = makeFolder(folder, output);

            File activeFile = files[i];
            activeFile.renameTo(new File(exitPath + "/"+  activeFile.getName()));
            i++;
        }
    }

    private static String makeFolder(String folder, String output) {
        String directoryPath = folder + "/" + output;
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdir();
        }
        return directoryPath;
    }

    private static String[] getPaths(File[] files) {
        String[] paths = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            paths[i] = files[i].getAbsolutePath();
            System.out.println(paths[i]);
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