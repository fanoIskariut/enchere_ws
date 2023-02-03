package enchere_ws.controller;

import enchere_ws.model.*;
import enchere_ws.repository.ProduitRepository;
import enchere_ws.repository.ProduitclientRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class ProduitclientController {
    private final ProduitclientRepository repository;

    public ProduitclientController(ProduitclientRepository repository){
        this.repository=repository;
    }
// liste produit nalefa le ola rehetra
    @GetMapping("/Produitclient/{id}")
    Object getProduitClient(@PathVariable int id){
        System.out.println(id);
        try {
            JsonDataSuccess<Produitclient> data = new JsonDataSuccess<>();
            data.setData(repository.rechercheBYidclient(id));
            return data;
        } catch(Exception ex){
            ex.printStackTrace();
            JsonError jsonerror = new JsonError();
            Erreur error = new Erreur();
            error.setCode(404);
            error.setMessage("Erreur");
            jsonerror.setError(error);
            return jsonerror;
        }
    }

    // liste apotra @ notification
    @GetMapping("/Produitclientvita/{id}")
    Object getProduitClientvita(@PathVariable int id){
        System.out.println(id);
        try {
            JsonDataSuccess<Produitclient> data = new JsonDataSuccess<>();
            data.setData(repository.produitVita(id));
            return data;
        } catch(Exception ex){
            ex.printStackTrace();
            JsonError jsonerror = new JsonError();
            Erreur error = new Erreur();
            error.setCode(404);
            error.setMessage("Erreur");
            jsonerror.setError(error);
            return jsonerror;
        }
    }

    // liste produit rehetra izay eta = 1
    @GetMapping("/ProduitTsyclient")
    Object getProduitTsyClient(){
        try {
            JsonDataSuccess<Produitclient> data = new JsonDataSuccess<>();
            data.setData(repository.produitTsyclient());
            return data;
        } catch(Exception ex){
            ex.printStackTrace();
            JsonError jsonerror = new JsonError();
            Erreur error = new Erreur();
            error.setCode(404);
            error.setMessage("Erreur");
            jsonerror.setError(error);
            return jsonerror;
        }
    }
// description produit
    @GetMapping("/Produit/{id}")
    Object getProduit(@PathVariable int id){
        System.out.println(id);
        try {
            JsonDataSuccess<Produitclient> data = new JsonDataSuccess<>();
            data.setData(repository.produitBYId(id));
            return data;
        } catch(Exception ex){
            ex.printStackTrace();
            JsonError jsonerror = new JsonError();
            Erreur error = new Erreur();
            error.setCode(404);
            error.setMessage("Erreur");
            jsonerror.setError(error);
            return jsonerror;
        }
    }
    // revherche avenser
    @PostMapping("/produit/recherche")
    Object all(@RequestBody Recherche recherche ){
        try{
            String nomcategorie = recherche.getNomproduit();
            double prixmin= recherche.getPrixmin();
            String nomproduit=recherche.getNomproduit();
            JsonDataSuccess<Produitclient> data = new JsonDataSuccess();
            data.setData(repository.recherche(nomproduit,prixmin,nomcategorie));
            return data;
        }
        catch(Exception ex){
            JsonError err = new JsonError();
            Erreur e = new Erreur();
            e.setCode(404);
            e.setMessage("Error found");
            err.setError(e);
            return err;
        }
    }


}
