// src/logic/Calculations.java
package logic;

import java.util.*;
import java.util.regex.*; // Regular expressions

public class Calculations {

    private double dblSolution;
    private String strSolution;

    public static void main(String[] args) {
        Calculations calc = new Calculations("30");
        System.out.println("String: " + calc.getStrSolution());
    }

    public Calculations(String equation) {
        dblSolution = solveBODMAS(equation);
        strSolution = decideDecimal(dblSolution);
    }

    public double getDblSolution() {
        return dblSolution;
    }

    public String getStrSolution() {
        return strSolution;
    }

    public void clear() {
        this.dblSolution = 0;
    }

    /** Solves simple arithmetic using BODMAS order (*,/ before +,-). */
    private double solveBODMAS(String equation) {
        String expr = equation.replaceAll("\\s+", "");

        // Tokenize numbers and operators
        Pattern pattern = Pattern.compile("(\\d+(?:\\.\\d+)?|[+\\-*/])");
        Matcher matcher = pattern.matcher(expr);

        List<String> tokens = new ArrayList<>();
        while (matcher.find()) tokens.add(matcher.group());

        // First pass: handle * and /
        for (int i = 0; i < tokens.size(); i++) {
            String t = tokens.get(i);
            if (t.equals("*") || t.equals("/")) {
                double left = Double.parseDouble(tokens.get(i - 1));
                double right = Double.parseDouble(tokens.get(i + 1));

                if (t.equals("/")) {
                    try {
                        zeroError(right);
                    } catch (ZeroErrorException ze) {
                        System.out.println(ze.getMessage());
                        return Double.NaN;
                    }
                }

                double result = t.equals("*") ? left * right : left / right;
                tokens.set(i - 1, Double.toString(result));
                tokens.remove(i); // remove operator
                tokens.remove(i); // remove right operand
                i--; // step back
            }
        }

        // Second pass: handle + and -
        double result = Double.parseDouble(tokens.get(0));
        for (int i = 1; i < tokens.size(); i += 2) {
            String op = tokens.get(i);
            double val = Double.parseDouble(tokens.get(i + 1));
            if (op.equals("+")) result += val;
            else if (op.equals("-")) result -= val;
        }

        return result;
    }

    /** Removes ".0" if the number is an integer. */
    public String decideDecimal(Double solution) {
        if (solution == null || solution.isNaN()) return "NaN";

        if (solution == Math.floor(solution)) {
            return String.valueOf(solution.intValue());
        } else {
            return String.valueOf(solution);
        }
    }

    /** Throws custom error if dividing by zero. */
    public void zeroError(Double number) throws ZeroErrorException {
        final double EPSILON = 1e-10;
        if (Math.abs(number) < EPSILON) {
            throw new ZeroErrorException("Division by zero is not allowed.");
        }
    }
}

// Custom exception
class ZeroErrorException extends Exception {
    public ZeroErrorException(String message) {
        super(message);
    }
}
