package core.exception;

public class TransactionPinExpection extends Exception {

    private String code;

    public TransactionPinExpection(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
