// src/logic/Calculations.java
package logic;
import java.util.*;
import java.util.regex.*; // Regular expression

public class Calculations {
    private double solution = 0;

    public static void main(String[] args) {
        Calculations calc = new Calculations("30/0");
        System.out.println(calc.getSolution());
    }

    public Calculations(String equation) {
        this.solution = solveBODMAS(equation);
    }

    public double getSolution() {
        return solution;
    }

    public void clear(){
        this.solution = 0;
    }

    private double solveBODMAS(String equation) {
        String expr = equation.replaceAll("\\s+", "");

        // Creates pattern and matches it
        Pattern pattern = Pattern.compile("(\\d+(?:\\.\\d+)?|[+\\-*/])");
        Matcher matcher = pattern.matcher(expr);


        List<String> tokens = new ArrayList<>();
        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        // First pass: handle * and /
        for (int i = 0; i < tokens.size(); i++) {
            // Stores * and / operators for solving
            if (tokens.get(i).equals("*") || tokens.get(i).equals("/")) {
                double left = Double.parseDouble(tokens.get(i - 1));
                double right = Double.parseDouble(tokens.get(i + 1));

                // Ensures that zero error does not occur
                if (tokens.get(i).equals("/")){
                    try {
                        zeroError(right);
                    } catch (ZeroErrorException ze){
                        System.out.println(ze.getMessage());
                        return Double.NaN;
                    }
                }
                double result = tokens.get(i).equals("*") ? left * right : left / right;
                tokens.set(i - 1, Double.toString(result));
                tokens.remove(i); // remove operator
                tokens.remove(i); // remove right operand
                i--; // step back to recheck
            }
        }

        // Second pass: handle + and -
        double result = Double.parseDouble(tokens.getFirst());
        for (int i = 1; i < tokens.size(); i += 2) {
            String op = tokens.get(i);
            double val = Double.parseDouble(tokens.get(i + 1));
            if (op.equals("+")) result += val;
            else if (op.equals("-")) result -= val;
        }
        return result;
    }

    public void zeroError(Double number) throws ZeroErrorException {
        final double EPSILON = 1e-10;
        if (Math.abs(number) < EPSILON) {
            throw new ZeroErrorException("Division by zero is not allowed.");
        }
    }

}


