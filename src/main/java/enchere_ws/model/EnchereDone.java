package enchere_ws.model;

import jakarta.persistence.*;

@Entity
@Table(name="encheredone")
public class EnchereDone {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private int idproduit ;
    private int idclient ;
    private double montantenchere;

    public EnchereDone() {
    }

    public EnchereDone(Long id, int idproduit, int idclient, double montantenchere) {
        this.id = id;
        this.idproduit = idproduit;
        this.idclient = idclient;
        this.montantenchere = montantenchere;
    }

    public EnchereDone(int idproduit, int idclient, double montantenchere) {
        this.idproduit = idproduit;
        this.idclient = idclient;
        this.montantenchere = montantenchere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public double getMontantenchere() {
        return montantenchere;
    }

    public void setMontantenchere(double montantenchere) {
        this.montantenchere = montantenchere;
    }
}
