package enchere_ws.exeption;

import java.sql.Date;

public class ProduitNotFoundException extends RuntimeException{


    public ProduitNotFoundException(int id_categorie){
        super("The produit with the categorie"+id_categorie+" does not exist");
    }
    public ProduitNotFoundException(String date_enchere){
        super("The produit with the categorie"+date_enchere+" does not exist");

    }
}
