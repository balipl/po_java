package lab_8.lab_1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("localhost", 6666);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;

        System.out.println("Wyślij komende: ");
        while ((userInput = stdIn.readLine()) != null) {

            Scanner ins = new Scanner(new FileReader("/home/grove/IdeaProjects/po_java/src/main/java/lab_8/lab_1/fetch.txt"));


            String sb = new String();
            while(ins.hasNext()) {
                sb = ins.next();
                out.println("LOGIN szymon;" + sb);
                String answer1 = in.readLine();
                System.out.println(answer1);
            }
            ins.close();
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}
