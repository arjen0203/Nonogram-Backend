package fun4.nonogrambackend.validators;

public class Success extends Result {
    public Success() {
        super(true, "");
    }

    public Success(String msg) {
        super(true, msg);
    }
}
