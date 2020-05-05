import java.util.ArrayList;
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

    public Calculator(){}

    public String input(){
        System.out.println("Bitte geben Sie ein String in form von '1+2' an:");
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        userInput = sc.next();

        userInput = userInput.trim();
        ArrayList arr = new ArrayList();
        arr.add(userInput.contains("+"));
        arr.add(userInput.contains("-"));
        arr.add(userInput.contains("/"));
        arr.add(userInput.contains("*"));

        int functiondef = -1;
        for(int i = 0; i < arr.size(); i++){
            if((boolean) arr.get(i)){
                functiondef = i;
                break;
            }
        }

        switch (functiondef) {
            case 0:{
                String[] parts = userInput.split("\\+");
                double a =Double.parseDouble(parts[0]);
                double b =Double.parseDouble(parts[1]);
                double res = add(a, b);
                return Double.toString(res);}
            case 1:{
                String[] parts = userInput.split("-");
                double a =Double.parseDouble(parts[0]);
                double b =Double.parseDouble(parts[1]);
                double res = sub(a, b);
                return Double.toString(res);}
            case 2:{
                String[] parts = userInput.split("/");
                double a =Double.parseDouble(parts[0]);
                double b =Double.parseDouble(parts[1]);
                double res = div(a, b);
                return Double.toString(res);}
            case 3:{
                String[] parts = userInput.split("\\*");
                double a =Double.parseDouble(parts[0]);
                double b =Double.parseDouble(parts[1]);
                double res = multi(a, b);
                return Double.toString(res);}
            case -1:
                throw new IllegalArgumentException();
            default:
                return "Falschen Operator eingegeben";
        }

    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.input());
    }

}