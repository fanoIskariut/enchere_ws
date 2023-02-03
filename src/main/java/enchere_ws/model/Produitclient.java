package enchere_ws.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.sql.Time;
import java.sql.Timestamp;
@Entity
public class Produitclient {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private int idclient ;
    private String nomproduit ;
    private int idcategori;
    private String nomcategorie;
    private Time dureeenchereminute ;
    private int statu ;
    private Timestamp dateenchere   ;
    private double prixmin;
    private String email;
    private String username;

    public Produitclient() {
    }

    public Produitclient(Long id, int idclient, String nomproduit,int idcategori,  String nomcategorie, Time dureeenchereminute, int statu, Timestamp dateenchere, double prixmin,String email , String username) {
        this.id = id;
        this.idclient = idclient;
        this.nomproduit = nomproduit;
        this.idcategori=idcategori;
        this.nomcategorie = nomcategorie;
        this.dureeenchereminute = dureeenchereminute;
        this.statu = statu;
        this.dateenchere = dateenchere;
        this.prixmin = prixmin;
        this.email=email;
        this.username=username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdcategori() {
        return idcategori;
    }

    public void setIdcategori(int idcategori) {
        this.idcategori = idcategori;
    }

    public Produitclient(int idclient, String nomproduit, int idcategori, String nomcategorie, Time dureeenchereminute, int statu, Timestamp dateenchere, double prixmin, String email , String username) {
        this.idclient = idclient;
        this.nomproduit = nomproduit;
        this.idcategori=idcategori;
        this.nomcategorie = nomcategorie;
        this.dureeenchereminute = dureeenchereminute;
        this.statu = statu;
        this.dateenchere = dateenchere;
        this.prixmin = prixmin;
        this.email=email;
        this.username=username;
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

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public String getNomcategorie() {
        return nomcategorie;
    }

    public void setNomcategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }

    public Time getDureeenchereminute() {
        return dureeenchereminute;
    }

    public void setDureeenchereminute(Time dureeenchereminute) {
        this.dureeenchereminute = dureeenchereminute;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

    public Timestamp getDateenchere() {
        return dateenchere;
    }

    public void setDateenchere(Timestamp dateenchere) {
        this.dateenchere = dateenchere;
    }

    public double getPrixmin() {
        return prixmin;
    }

    public void setPrixmin(double prixmin) {
        this.prixmin = prixmin;
    }
}
