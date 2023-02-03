package enchere_ws.model;

import enchere_ws.DAOpostgres.Generique;
import enchere_ws.repository.ProduitRepository;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="produit")
public class Produit {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
   private int idclient;
   private String nomproduit;
   private int idcategorie;
   private Time dureeenchereminute;
   private Timestamp dateenchere;
   private double prixmin;

    public Produit() {
    }

    public Produit(int idclient, String nomproduit, int idcategorie, Time dureeenchereminute, double prixmin) {
        this.idclient = idclient;
        this.nomproduit = nomproduit;
        this.idcategorie = idcategorie;
        this.dureeenchereminute = dureeenchereminute;
        this.prixmin = prixmin;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int id_client) {
        this.idclient = id_client;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nom_produit) {
        this.nomproduit = nom_produit;
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int id_categorie) {
        this.idcategorie = id_categorie;
    }

    public Time getDureeenchereminute() {
        return dureeenchereminute;
    }

    public void setDureeenchereminute(Time duree_enchere_minute) {
        this.dureeenchereminute = duree_enchere_minute;
    }

    public Timestamp getDateenchere() {
        return dateenchere;
    }

    public void setDateenchere(Timestamp date_enchere) {
        this.dateenchere = date_enchere;
    }

    public double getPrixmin() {
        return prixmin;
    }

    public void setPrixmin(double prix_min) {
        this.prixmin = prix_min;
    }


    public void insertProduit(){
        Generique gen = new Generique();
        try
        {
            gen.insertProduit(this);
        }
        catch (Exception ex) {}
    }
    public List<Produit> getProduitss(int ids) throws Exception {
        Generique gen = new Generique();
        Produit etu = new Produit();
        List<Produit> le = new ArrayList<>();
        String id = String.valueOf(ids) ;
        String sql = "select * from produit where id = "+id;
        System.out.println(sql);
        try {
            List<Object> listEtude = gen.selectObjects(etu.getClass(),sql);
            for(Object ob: listEtude) {
                le.add((Produit)ob);
                System.out.println(le.size());
            }
            return le;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return le;
    }




}
