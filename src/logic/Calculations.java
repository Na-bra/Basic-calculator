package logic;


import java.util.ArrayList;
import java.util.Objects;

public class Calculations {

    static double solution = 0;
    static ArrayList<String> strEquations = new ArrayList<String>();

public static void main(String[] args) {

    Calculations calc = new Calculations("30+20+300");
        System.out.println(solution);
    }

    public Calculations (String equation){
        this.chooseOperator(equation);

    }

    // Calculation functions

    public void add(String equation){
        equation.strip();
       String[] operations = equation.split("\\+");
       for (String operand : operations){
           solution += convertString(operand);
       }
    }

    public void sub(String equation){
        equation.strip();
        String[] operations = equation.split("-");
        for (String operand : operations){
            solution -= convertString(operand);
        }
    }

    public void storeEquations(String op){

    }

    public void chooseOperator(String equation) {
        int operatorCount = 0;
        StringBuilder sb = new StringBuilder();
        String formattedString = "";
        if (equation == null) {
            System.out.println("Error null");
        }
        for (int i = 0; i < Objects.requireNonNull(equation).length(); i++) {
            formattedString = String.valueOf(sb.append(equation.charAt(i)));
            if (equation.charAt(i) == '+') {
                operatorCount++;
                if (operatorCount == 2) {
                    add(formattedString);
                    operatorCount = 0;
                    formattedString ="";
                }
            }
            if (equation.charAt(i) == '-') {
                operatorCount++;
                if (operatorCount == 2) {
                    sub(formattedString);
                    operatorCount = 0;
                    formattedString = "";
                }
            }
        }
    }



    // Return double so it can calculate any input
    public Double convertString(String numberString) {
        Double numberInt = null;
        try {
            numberInt = Double.parseDouble(numberString);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format");
            return null;
        }
        return numberInt;
    }

    public void invalidOperation(String equation) throws InvalidOpratorsException {
     if (!equation.contains("+") && !equation.contains("-") && !equation.contains("/")
            && !equation.contains("x")){
            throw new InvalidOpratorsException();
     }

    }

    public Integer toInteger(Integer value){
        return null;
    }
}
