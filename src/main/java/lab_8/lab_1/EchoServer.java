package lab_8.lab_1;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.net.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer  {

    public static void main(String[] args)  throws IOException {
        short port = 6666;

        try(ServerSocket srv = new ServerSocket(port)){
            while(true) {
                Socket s = srv.accept();
                System.out.print("new connection accepted: ");
                System.out.println(s.getInetAddress());
                ExecutorService services = Executors.newFixedThreadPool(5);//inicjalizacja executora
                services.submit(new SockReader(s));
            }
        }
    }




}
