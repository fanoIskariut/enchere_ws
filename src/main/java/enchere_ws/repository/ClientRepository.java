package enchere_ws.repository;

import enchere_ws.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmailAndMotdepasse(String email,String mot_de_pass);
}
