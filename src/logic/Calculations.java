// src/logic/Calculations.java
package logic;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculations {
    private double solution = 0;

    public static void main(String[] args) {
        Calculations calc = new Calculations("3010*200");
        System.out.println(calc.getSolution());
    }

    public Calculations(String equation) {
        this.solution = solvePM(equation);
    }

    public double getSolution() {
        return solution;
    }

    private double solvePM(String equation) {
        double result = 0;
        Pattern pattern = Pattern.compile("([+-]?\\d+(?:\\.\\d+)?)");
        Matcher matcher = pattern.matcher(equation.replaceAll("\\s+", ""));


            while (matcher.find()) {
                result += Double.parseDouble(matcher.group());
            }
        return result;


    } // <-- Add this closing brace

} // <-- And this one for the class
