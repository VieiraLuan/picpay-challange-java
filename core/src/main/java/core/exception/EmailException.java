package core.exception;

public class EmailException extends Exception {

    public EmailException(String message, String code) {
        super(message);
        this.code = code;
    }

    private String code;




    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
