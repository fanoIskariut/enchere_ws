package enchere_ws.controller;

import enchere_ws.model.Erreur;
import enchere_ws.model.JsonDataSuccess;
import enchere_ws.model.JsonError;
import enchere_ws.model.Venchere;
import enchere_ws.repository.CategorieRepository;
import enchere_ws.repository.VenchereRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class VenchereController {
    private final VenchereRepository repository;

    public VenchereController(VenchereRepository repository){
        this.repository=repository;
    }

    //liste enchere ze tsy any le clien id
    @GetMapping("/encher/{id}")
    Object getEnchere(@PathVariable int id){
        try {
            JsonDataSuccess<Venchere> data = new JsonDataSuccess<>();
            data.setData(repository.getSpecificEnchere(id));
            return data;
        } catch(Exception ex){
            JsonError jsonerror = new JsonError();
            Erreur error = new Erreur();
            error.setCode(404);
            error.setMessage("Erreur");
            jsonerror.setError(error);
            return jsonerror;
        }
    }

    /*@GetMapping("/enchere/{id}")
    public List<Enchere> getSpecificEnchere(@PathVariable int id){
        System.out.println("Here's the id" + id);
        return er.getSpecificEnchere(id);
    }*/


    // historique le client id
    @GetMapping("/Historique/{id}")
    Object getHistorique(@PathVariable int id){
        System.out.println(id);
        try {
            JsonDataSuccess<Venchere> data = new JsonDataSuccess<>();
            data.setData(repository.getHistorique(id));
            return data;
        } catch(Exception ex){
            JsonError jsonerror = new JsonError();
            Erreur error = new Erreur();
            error.setCode(404);
            error.setMessage("Erreur");
            jsonerror.setError(error);
            return jsonerror;
        }
    }
}
