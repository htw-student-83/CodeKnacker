package codeknacker;

public class WrongNumberException extends Exception{
    public WrongNumberException() { super(); }
    public WrongNumberException(String message) { super(message); }
    public WrongNumberException(String message, Throwable t) { super(message, t); }
}
