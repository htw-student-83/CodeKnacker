package codeknacker;

public class NegativNumberException extends Exception{
    public NegativNumberException() { super(); }
    public NegativNumberException(String message) { super(message); }
    public NegativNumberException(String message, Throwable t) { super(message, t); }
}
