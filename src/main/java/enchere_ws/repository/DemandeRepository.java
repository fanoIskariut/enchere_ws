package enchere_ws.repository;


import enchere_ws.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
    @Query("SELECT u FROM Demande  u WHERE u.etat = :etat")
    List<Demande> findByEtat(@Param("etat") String etat);
    Demande findById(int id);

}
