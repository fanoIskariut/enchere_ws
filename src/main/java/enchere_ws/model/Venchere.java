package enchere_ws.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity
public class Venchere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idproduit;
    private int idclientnado;
    private int montantenchere;
    private String produit;
    private Time duree;
    private LocalDateTime dateenchere;
    private double prixmin;
    private String client;
    private String email;

    public Venchere() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public int getIdclientnado() {
        return idclientnado;
    }

    public void setIdclientnado(int idclient) {
        this.idclientnado = idclient;
    }

    public int getMontantenchere() {
        return montantenchere;
    }

    public void setMontantenchere(int montantenchere) {
        this.montantenchere = montantenchere;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public Time getDuree() {
        return duree;
    }

    public void setDuree(Time duree) {
        this.duree = duree;
    }

    public LocalDateTime getDateenchere() {
        return dateenchere;
    }

    public void setDateenchere(LocalDateTime dateenchere) {
        this.dateenchere = dateenchere;
    }

    public double getPrixmin() {
        return prixmin;
    }

    public void setPrixmin(double prixmin) {
        this.prixmin = prixmin;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}