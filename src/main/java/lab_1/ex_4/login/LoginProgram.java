package lab_1.ex_4.login;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import lab_1.ex_4.login.Login;
/**
 *
 * @author Szymon
 */
public class LoginProgram {
    public static void main(String[] argv){
      Login log = new Login ("ala", "makota");
	  try{
		InputStreamReader rd = new InputStreamReader(System.in);
		BufferedReader bfr = new BufferedReader(rd);

        // TODO: prosba o wpisanie has?a i loginu
		  System.out.println("Podaj login:");
		  String login = bfr.readLine();
		  System.out.println("Podaj has?o:");
		  String haslo = bfr.readLine();

        /*TODO: sprawdzenie czy podane has?o i login zgadzaja sie z tymi
         przechowywanymi w obiekcie log Je?li tak, to ma zosta?
         wyswietlone "OK", jesli nie - prosze wyswietli? informacje o b?edzie
         */
		  if(log.check(login,haslo)){
		  	System.out.println("Haslo poprawne - zapraszam!");
		  }else{
		  	System.out.println("Zle haslo!");
		  }


	  }catch(IOException e){e.printStackTrace();}

    }
}
