package enchere_ws.model;

import enchere_ws.DAOpostgres.Generique;

import java.util.ArrayList;
import java.util.List;

public class Encherir {
    public int idproduit ;
    public  int idclient ;
    public double montantenchere ;
    public String email;

    public Encherir() {
    }

    public Encherir(int idproduit, int idclient, double montantenchere, String email) {
        this.idproduit = idproduit;
        this.idclient = idclient;
        this.montantenchere = montantenchere;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
////// liste encherir / client

    public List<Encherir> getEncherir(int id) throws Exception {
        Generique gen = new Generique();
        Encherir etu = new Encherir();
        List<Encherir> le = new ArrayList<>();
        String sql = "select * from encherir where idproduit ="+id;
        System.out.println(sql);
        try {
            List<Object> listEtude = gen.selectObjects(etu.getClass(),sql);
            for(Object ob: listEtude) {
                le.add((Encherir)ob);
            }
            return le;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return le;
    }
}
