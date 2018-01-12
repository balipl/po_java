package lab_8.lab_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SockReader implements Runnable {

    private Scanner in;
    private PrintStream out;
    private Socket s;


    public SockReader(Socket s) throws IOException {

        this(s.getInputStream(), s.getOutputStream());
        this.s = s;
    }

    public SockReader(InputStream input,OutputStream output) {
        in = new Scanner(input);
        out = new PrintStream(output);
    }


    public static Integer actualID = 0000000000;
    public void run() {
        //tworze serverSocket

try {
        String inputLine;


        while ((!Thread.currentThread().isInterrupted()) && in.hasNextLine() ) {
            inputLine = in.nextLine();
            String[] inputWords = null;
            String[] user = null;

            inputWords = inputLine.split(" ");

            if (inputWords[0].equals("LOGIN")) {
                if (inputWords.length == 2) {
                    user = inputWords[1].split(";");
                    if (user.length == 2) {
                        if (user[0].equals("szymon") && user[1].equals("haslo")) {
                            out.println("Hasło poprawne. Twoj ID to" + getUID());
                            continue;
                        } else {
                            int distance = LevenshteinDistance.computeLevenshteinDistance(user[1], "haslo");
                            out.println("Błędne hasło. Dystans to" + distance);
                            continue;
                        }
                    }
                } else {
                    out.println("Musisz podać login i hasło");
                    continue;
                }
            }

            if (inputWords[0].equals("LOGOUT")) {
                if (inputWords.length == 2) {
                    out.println("true");
                    continue;
                } else {
                    out.println("false");
                    continue;
                }


            }
            if (inputWords[0].equals("LS")) {
                if (inputWords.length == 2 && inputWords[1].equals(getActualID())) {
                    Path dir = Paths.get("/home/grove/Dokumenty/Server");
                    String exitString = new String();
                    try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                        for (Path file : stream) {
                            exitString += file.getFileName();
                        }
                    }
                    out.println(exitString);
                    continue;
                } else {
                    out.println("false");
                    continue;
                }

            }
            if (inputWords[0].equals("GET")) {
                if (inputWords.length == 3 && inputWords[1].equals(getActualID())) {
                    Scanner scanner = new Scanner(new FileReader("filename.txt"));
                    StringBuilder sb = new StringBuilder();
                    String exitString = scanner.next();

                    scanner.close();
                    out.println(exitString);
                    continue;
                } else {
                    out.println("false");
                    continue;
                }
            } else {
                out.println("Brak takiej komendy");
                continue;
            }

        }


        //zamykanie wszystkich wejsc/wyjsc/ portow
        out.close();
        in.close();

}catch (IOException e){e.printStackTrace();}
    }

    private static String getUID(){
        actualID++;
        String tmp = "0000000000" + actualID.toString();
        String stringUID = tmp.substring(tmp.length() - 10);

        return stringUID;
    }
    private static String getActualID(){
        String tmp = "0000000000" + actualID.toString();
        String stringUID = tmp.substring(tmp.length() - 10);
        return stringUID;
    }
}
