public class NameCannotBeEmptyException  extends RuntimeException {

    public NameCannotBeEmptyException(String message) throws RuntimeException {
        super(message);
    }
}