package enchere_ws.model;

import enchere_ws.DAOpostgres.Generique;
import jakarta.persistence.*;

@Entity
@Table(name="demande_rechargement")
public class MouvementCompte {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private int idclient ;
    private int typemouvement ;
    private double montant ;

    public MouvementCompte() {
    }

    public MouvementCompte(int idclient, int typemouvement, double montant) {
        this.idclient = idclient;
        this.typemouvement = typemouvement;
        this.montant = montant;
    }

    public MouvementCompte(Long id, int idclient, int typemouvement, double montant) {
        this.id = id;
        this.idclient = idclient;
        this.typemouvement = typemouvement;
        this.montant = montant;
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

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getTypemouvement() {
        return typemouvement;
    }

    public void setTypemouvement(int typemouvement) {
        this.typemouvement = typemouvement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }


    public void insertMouvement(){
        Generique gen = new Generique();
        try
        {
            gen.insertObject(this);
        }
        catch (Exception ex) {}
    }
}
