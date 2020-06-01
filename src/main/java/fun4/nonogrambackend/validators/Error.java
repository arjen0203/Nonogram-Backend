package fun4.nonogrambackend.validators;

public class Error extends Result {
    public Error(String msg) {
        super(false, msg);
    }
}
