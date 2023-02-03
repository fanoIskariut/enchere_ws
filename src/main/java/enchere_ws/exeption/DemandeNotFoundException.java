package enchere_ws.exeption;

public class DemandeNotFoundException extends RuntimeException {
    public Long id;

    public DemandeNotFoundException(Long id){
        super("The Demande Rechargement with the id"+id+" does not exist");
    }
}
