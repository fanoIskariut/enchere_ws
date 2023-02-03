package enchere_ws.model;

import enchere_ws.DAOpostgres.Generique;

import java.util.ArrayList;
import java.util.List;

public class Vproduit {

    public int idproduit , idclient ;
    public int idcategorie ;
    public double prixmin ;

    public Vproduit() {
    }

    public Vproduit(int idproduit, int idclient, int idcategorie, double prixmin) {
        this.idproduit = idproduit;
        this.idclient = idclient;
        this.idcategorie = idcategorie;
        this.prixmin = prixmin;
    }

    public Vproduit(int idclient, int idcategorie, double prixmin) {
        this.idclient = idclient;
        this.idcategorie = idcategorie;
        this.prixmin = prixmin;
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

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public double getPrixmin() {
        return prixmin;
    }

    public void setPrixmin(double prixmin) {
        this.prixmin = prixmin;
    }
    public List<Vproduit> getRvol(int id) throws Exception {
        Generique gen = new Generique();
        Vproduit etu = new Vproduit();
        List<Vproduit> le = new ArrayList<>();
        String sql = "select * from vproduit where idproduit ="+id;
        System.out.println(sql);
        try {
            List<Object> listEtude = gen.selectObjects(etu.getClass(),sql);
            for(Object ob: listEtude) {
                le.add((Vproduit)ob);
            }
            return le;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return le;
    }
}
