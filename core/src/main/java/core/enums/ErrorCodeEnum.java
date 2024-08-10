package core.enums;

public enum ErrorCodeEnum {

    ON0001("Tax Number inválido", "ON0001"),
    ONl0002("", "ON0002"),

    TR0001("Usuário lojista não tem a função disponível", "TR0001"),
    TR0002("Saldo indisponível", "TR0002");
    private String message;
    private String code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
