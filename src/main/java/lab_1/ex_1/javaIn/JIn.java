package lab_1.ex_1.javaIn;

import java.io.*;

public class JIn {
    public static String getString() {
        String text = null;
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            text = bfr.readLine();
        }catch(IOException e){e.printStackTrace();}
        return text;
    }

    public static Integer getInteger(){
        Integer integer = null;
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            integer = Integer.parseInt(bfr.readLine());
        }catch(IOException e){e.printStackTrace();}
        catch(NumberFormatException e){e.printStackTrace();}
        return integer;
    }
}