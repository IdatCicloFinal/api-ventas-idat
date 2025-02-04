package pe.edu.idat.api_ventas_idat.exception;

public class ResourceNotFoundException
    extends RuntimeException {

    public ResourceNotFoundException(
            String message){
        super(message);
    }
}
