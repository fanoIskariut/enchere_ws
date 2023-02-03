package enchere_ws.exeption;

public class ClientNotFoundException extends RuntimeException {
    public Long id;

    public ClientNotFoundException(Long id){
        super("The user with the id"+id+" does not exist");
    }
}
