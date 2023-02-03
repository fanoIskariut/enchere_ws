package enchere_ws.controller;

import enchere_ws.model.*;
import enchere_ws.repository.CategorieRepository;
import enchere_ws.repository.DemandeRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class CategorieController {
    private final CategorieRepository repository;

    public CategorieController(CategorieRepository repository){
        this.repository=repository;
    }

    //liste categori
    @GetMapping("/Categorie")
    Object all(){
        try{
            JsonDataSuccess<Categorie> data = new JsonDataSuccess();
            data.setData(repository.findAll());
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
    //insere categori
    @PostMapping("/Categorie/save")
    Categorie newCategorie(@RequestBody Categorie newCategorie) {return repository.save(newCategorie);}
}
