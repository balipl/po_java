package lab_2.ex_1.pkg1;

public class B extends A {

//int test = number;
//String test1 = name;

protected void decrement(){
    number -=3;
}

 void changeName(){
    name = "package B";
    }
  public B(int number, String text){
        super (number,text);
   }
   public B(){}
}
