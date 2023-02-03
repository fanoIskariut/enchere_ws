package enchere_ws.controller;

import com.sun.source.tree.TryTree;
import enchere_ws.DAOpostgres.Generique;
import enchere_ws.model.*;
import enchere_ws.repository.CategorieRepository;
import enchere_ws.repository.EnchereRepository;
import enchere_ws.repository.MouvementCompteRepository;
import enchere_ws.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
public class EnchereController {
    private final EnchereRepository repository;

    public  ProduitRepository Porepository;


    public EnchereController(EnchereRepository repository){this.repository=repository;}

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private MouvementCompteRepository moveproduitRepository;



  /*  @GetMapping("/Categorie")
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
    }*/



    //Encherire
   @PostMapping("/enchere/save")
  Object newEnchere(@RequestBody Enchere newEnchere)throws Exception{
       try{
           String idd =  String.valueOf(newEnchere.getIdproduit()) ;
           int id = Integer.valueOf(idd);
           double prixS=newEnchere.getMontantenchere();
           Vproduit vpo = new Vproduit();

                     List<Vproduit> vp = vpo.getRvol(id);
                    JsonDataSuccess<Vproduit> data = new JsonDataSuccess();
                    data.setData(vp);
                 double prixD = vp.get(0).getPrixmin();
            System.out.println(prixS +"inf"+prixD);
           if(prixS < prixD){

                throw new Exception("le montant insere est inferieur au prix minimum :"+prixD);
           }

       }
       catch (Exception ex){
           JsonError err = new JsonError();
           Erreur e = new Erreur();
           e.setCode(404);
           e.setMessage(ex.getMessage());
           err.setError(e);
           return err;
       }


       return repository.save(newEnchere);
   }

    @GetMapping("/encherir/{idproduit}")
    Object all(@PathVariable int idproduit){
        try{
            Encherir enc = new Encherir();
            List<Encherir> en = enc.getEncherir(idproduit);
            JsonDataSuccess<Encherir> data = new JsonDataSuccess();
            data.setData(en);
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



       //

   /* @PostMapping
    public void save(@RequestBody Enchere newEnchere) throws Exception {
        Enchere enchere = new Enchere();
        enchere.setIdclientnado(newEnchere.getIdclientnado());
        enchere.setIdproduit(newEnchere.getIdproduit());

        List<Enchere> encheres = repository.findByProduitId(newEnchere.getIdproduit());

        if (encheres.isEmpty()) {
            Produit prod = produitRepository.findById(newEnchere.getIdproduit());
            if (newEnchere.getMontantenchere()<= prod.getPrixmin()) {
                throw new Exception("Montant insuffisant");
            } else {
                enchere.setMontantenchere(newEnchere.getMontantenchere());
            }
        } else {

            // Partie qui prend le montant le plus elevé de la table enchere
            double montant_plus_eleve = encheres.get(0).getMontantenchere();
            for (int i = 1; i < encheres.size(); i++) {
                if (montant_plus_eleve < encheres.get(i).getMontantenchere()) {
                    montant_plus_eleve = encheres.get(i).getMontantenchere();
                }
            }
            //////

            // Partie qui calcule le montant actuel du client

            List<MouvementCompte> mouvement_comptes = moveproduitRepository.findByClientId(newEnchere.getIdclientnado());

            double montant_actuel = 0;
            for (int i = 0; i < mouvement_comptes.size(); i++) {
                if (mouvement_comptes.get(i).getTypemouvement()== 1) {
                    montant_actuel = montant_actuel + mouvement_comptes.get(i).getMontant();
                } else {
                    montant_actuel = montant_actuel - mouvement_comptes.get(i).getMontant();
                }
            }
            //////

            if (montant_plus_eleve > newEnchere.getMontantenchere()) {
                throw new Exception("Montant insuffisant");
            } else if (montant_actuel < newEnchere.getMontantenchere()) {
                throw new Exception("Montant trop eleve");
            } else {
                enchere.setMontantenchere(newEnchere.getMontantenchere());
            }
        }

        repository.save(enchere);
    }*/


}
