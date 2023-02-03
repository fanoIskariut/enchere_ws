package enchere_ws.repository;

import enchere_ws.model.Enchere;
import enchere_ws.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnchereRepository extends JpaRepository<Enchere, Long> {
    //public List<Enchere> findByProduitId(int id);
}
