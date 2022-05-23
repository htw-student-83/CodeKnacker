package codeknackerUI;

public class NetworkException extends Throwable {

    public NetworkException() { super(); }
    public NetworkException(String message) { super(message); }
    public NetworkException(String message, Throwable t) { super(message, t); }
}
