package lab_1.ex_1.myPackage;

import lab_1.ex_1.javaIn.JIn ;

public class HelloWorld {
    public static void main(String [] argv){
        System.out.print("Type your name: ");
        String name = JIn.getString();
        if(name.equals("Kasia")) name = "Margaryna";
        System.out.println("Hello World");
        System.out.println("And hello "+name);
        ///xxxxśćś
    }
}
