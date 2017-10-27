package main.java.lab_2.ex_1.pkg1;

/* Pola o dost?pie pakietowym s? dost?ne w klasach pochodnych kt?re s? w tym samym pakiecie*/
public class A {
 int number;
protected String name;

public A(int number, String name){};
public A(){};

public int getNumber(){
    return number;
}

public void callDecrement(){
    decrement();
}
public void callChangeName(){
    changeName();
}
public void callIncrement(){
   increment();
}
private void increment(){
    number+=1;
}
protected void decrement(){
    number-=1;
}
void changeName(){
    name = "A";
    }

}
