public class InvalidNumberException extends IllegalArgumentException {
    public InvalidNumberException(){
        super();
    }

    public InvalidNumberException(String message){
        super(message);
    }
}
