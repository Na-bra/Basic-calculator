package logic;

public class InvalidOpratorsException extends Exception{
    public InvalidOpratorsException(){
        super("No exceptable operation found");
    }
}
