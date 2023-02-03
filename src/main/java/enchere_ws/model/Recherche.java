package enchere_ws.model;

public class Recherche {
    private String nomcategorie;
    private double prixmin;
    private String nomproduit;

    public Recherche() {
    }

    public Recherche(String nomcategorie, double prixmin,String nomproduit) {
        this.nomcategorie = nomcategorie;
        this.prixmin = prixmin;
        this.nomproduit=nomproduit;
    }

    public Recherche(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }

    public Recherche(double prixmin) {
        this.prixmin = prixmin;
    }

    public Recherche(String nomcategorie, String nomproduit) {
        this.nomcategorie = nomcategorie;
        this.nomproduit = nomproduit;
    }

    public String getIdcategorie() {
        return nomcategorie;
    }

    public void setIdcategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }

    public double getPrixmin() {
        return prixmin;
    }

    public void setPrixmin(double prixmin) {
        this.prixmin = prixmin;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }
}
