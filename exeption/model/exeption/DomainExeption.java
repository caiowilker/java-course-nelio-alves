package exeption.model.exeption;


public class DomainExeption extends RuntimeException{
    private static final long sarialVesionUID = 1L;

    public DomainExeption(String msg) {
        super(msg);
    }
}
