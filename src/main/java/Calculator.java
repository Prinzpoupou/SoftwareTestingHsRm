import java.util.Scanner;

public class Calculator {

    public double add(double a, double b) {
        return a+b;
    }

    public double sub(double a, double b) {
        return a-b;
    }

    public double multi(double a, double b) {
        return a*b;
    }

    public double div(double a, double b) {
        if(b==0){
            throw new ArithmeticException();
        }
        return a/b;
    }

    public int add(int a, int b) {
        return a+b;
    }

    public int sub(int a, int b) {
        return a-b;
    }

    public int multi(int a, int b) {
        return a*b;
    }

    public int div(int a, int b) {
        if(b==0){
            throw new ArithmeticException();
        }
        return a/b;
    }

    public Calculator(){}

}