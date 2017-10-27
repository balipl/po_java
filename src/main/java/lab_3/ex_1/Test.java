package lab_3.ex_1;
import lab_3.ex_1.ExerciseOne;

import java.util.LinkedList;

public class Test {
public static void main(String[] argv){
    ExerciseOne a = new ExerciseOne();
    System.out.println(a.Method1(4.5));

    LinkedList<Double> listaM = new LinkedList<Double>();
    listaM.add(3.);
    listaM.add(4.2);
    listaM.add(1.3);


    System.out.println(a.Method2(listaM));
}
}
