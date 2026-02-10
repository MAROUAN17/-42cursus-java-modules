public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String errorMssg) {
        super(errorMssg);
    }    
}