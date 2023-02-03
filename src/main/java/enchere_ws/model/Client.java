package enchere_ws.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Client {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String username ;
    private String motdepasse;
    private int sexe ;
    private String email ;

    public Client() {
    }

    public Client(Long id, String username, String motdepasse, int sexe, String email) {
        this.id = id;
        this.username = username;
        this.motdepasse = motdepasse;
        this.sexe = sexe;
        this.email = email;
    }

    public Client(String username, String motdepasse, int sexe, String email) {
        this.username = username;
        this.motdepasse = motdepasse;
        this.sexe = sexe;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String mot_de_pass) {
        this.motdepasse = mot_de_pass;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
