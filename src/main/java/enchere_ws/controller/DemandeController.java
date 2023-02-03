package enchere_ws.controller;

import enchere_ws.exeption.DemandeNotFoundException;
import enchere_ws.model.*;
import enchere_ws.repository.DemandeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class DemandeController {
    private final DemandeRepository repository;

    public DemandeController(DemandeRepository repository){
        this.repository=repository;
    }
//lisye demande de rechargement compte non valider
    @GetMapping("/DemandeRechargement")
    Object all(){
        try{
            JsonDataSuccess<Demande> data = new JsonDataSuccess();
            //data.setData(repository.findAll());
            //DemandeRechargement demande = repository.findByEtat(0);
            data.setData(repository.findByEtat("0"));
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
 // insertion deamnde rechargement
    @PostMapping("/DemandeRechargement/save")
    Demande newDemandeRechargement(@RequestBody Demande newDemande) {
        return repository.save(newDemande);
    }


 // validation demande rechargement + insertion mouvement de conte
    @PutMapping("/DemandeRechargement/{id}")
    public ResponseEntity<Demande> updateDemande(@PathVariable(value = "id") Long Id) {
        Demande demande = repository.findById(Id).orElseThrow(() -> new DemandeNotFoundException(Id));
        int valide = 1 ;
        demande.setEtat(valide);
        final Demande updated = repository.save(demande);
        MouvementCompte move = new MouvementCompte();
        MouvementCompteController moveC = new MouvementCompteController();
        move.setIdclient(updated.getIdclient());
        move.setTypemouvement(1);
        move.setMontant(updated.getMontant());
        move.insertMouvement();
        return ResponseEntity.ok(updated);
    }
}
