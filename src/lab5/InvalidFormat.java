package lab5;

public class InvalidFormat extends Exception {
    public InvalidFormat(String message, int nrLini) {
        super(message);
        this.message = "Nr lini: " + Integer.toString(nrLini) + " o tresci "  + message ;
    }

    @Override
    public String getMessage() {
        return message;
    }

    private String message;
}