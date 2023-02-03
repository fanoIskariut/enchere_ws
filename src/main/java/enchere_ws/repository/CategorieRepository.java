package enchere_ws.repository;

import enchere_ws.model.Categorie;
import enchere_ws.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
