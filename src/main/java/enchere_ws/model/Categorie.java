package enchere_ws.model;
import jakarta.persistence.*;

@Entity
@Table(name = "categorie")
public class Categorie {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String nomcategorie;
     private int    pourcentage;

    public Categorie() {
    }

    public Categorie(Long id, String nomcategorie, int pourcentage) {
        this.id = id;
        this.nomcategorie = nomcategorie;
        this.pourcentage = pourcentage;
    }

    public Categorie(String nomcategorie, int pourcentage) {
        this.nomcategorie = nomcategorie;
        this.pourcentage = pourcentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomcategorie() {
        return nomcategorie;
    }

    public void setNomcategorie(String nom_categorie) {
        this.nomcategorie = nom_categorie;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }
}
