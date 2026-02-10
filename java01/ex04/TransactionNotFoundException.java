public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(String errorMssg) {
        super(errorMssg);
    }    
}