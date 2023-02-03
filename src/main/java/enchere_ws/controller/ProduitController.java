package enchere_ws.controller;

import enchere_ws.model.*;
import enchere_ws.repository.DemandeRepository;
import enchere_ws.repository.ProduitRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
public class ProduitController {
    private final ProduitRepository repository;

    //public ProduitController(ProduitRepository repository){this.repository=repository;}
    public ProduitController(ProduitRepository repository){
        this.repository=repository;
    }

    //ajouter produit
    @PostMapping("/Produit/save")
    public void newProduite(@RequestBody Produit newProduit) {
        Produit move = new Produit();
        move.setIdclient(newProduit.getIdclient());
        move.setIdcategorie(newProduit.getIdcategorie());
        move.setNomproduit(newProduit.getNomproduit());
        move.setDureeenchereminute(newProduit.getDureeenchereminute());
        move.setPrixmin(newProduit.getPrixmin());
        move.insertProduit();
    }


}
