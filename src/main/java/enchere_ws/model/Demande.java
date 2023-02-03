package enchere_ws.model;

import jakarta.persistence.*;

@Entity
@Table(name="demande")
public class Demande {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private int idclient;
    private double montant ;
    private int etat ;

    public Demande() {
    }

    public Demande(Long id, int idclient, double montant, int etat) {
        this.id = id;
        this.idclient = idclient;
        this.montant = montant;
        this.etat = etat;
    }

    public Demande(int idclient, double montant, int etat) {
        this.idclient = idclient;
        this.montant = montant;
        this.etat = etat;
    }

    public Demande(int idclient, double montant) {
        this.idclient = idclient;
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

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
