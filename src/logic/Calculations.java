package logic;


public class Calculations {

    static int solution;
    static Integer oprands [];

public static void main(String[] args) {

    Calculations calc = new Calculations("30+20+20");
    String numberString1 = "Faggot";
    System.out.println(calc.convertString(numberString1));
    }

    public Calculations (String equation){
        StringBuilder sb = new StringBuilder();
        String fequation =  equation.trim();

    }
    public void add(String equation){
       String[] oprands  = equation.split("\\+");
       for (String oprand : oprands ){
           solution += convertString(oprand);
       }
    }

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




}
