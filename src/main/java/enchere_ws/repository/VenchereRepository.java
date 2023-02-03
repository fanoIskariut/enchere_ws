package enchere_ws.repository;

import enchere_ws.model.Venchere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenchereRepository extends JpaRepository<Venchere, Long> {

    @Query(value = "SELECT * FROM venchere WHERE (dateenchere + duree) < now() AND venchere.idclientnado != ?",nativeQuery = true)
    List<Venchere> getSpecificEnchere(int id);
    @Query(value = "SELECT * FROM venchere WHERE (dateenchere + duree) < now() AND venchere.idclientnado = ?",nativeQuery = true)
    List<Venchere> getHistorique(int id);
}
