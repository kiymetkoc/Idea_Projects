package tests;

public class Parent {
    public static void main(String[] args) {
        int a=2;
        int b= 3;
        int Sum = a+b;
        System.out.println("Sum is "+Sum);

        System.out.println();

        Methods m= new Methods();
        m.ValidateHeader();
        System.out.println( m.Validate());


    }


}
