package enchere_ws.repository;

import enchere_ws.model.Demande;
import enchere_ws.model.MouvementCompte;
import enchere_ws.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    @Query(value = "select * from produit where idcategorie =?1 AND prixmin >=?2 ", nativeQuery = true)
    List<Produit> recherche(int idcategorie,double prixmin);

    @Query(value = "select * from produit where idcategorie = ?1  ", nativeQuery = true)
    List<Produit> rechercheBYCategorie(int idcategorie );

    @Query(value = "select * from produit where dateenchere = ?1  ", nativeQuery = true)
    List<Produit> rechercheBYDate(Date dateenchere );

    @Query(value = "select * from produit where prixmin >=?1  ", nativeQuery = true)
    List<Produit> rechercheBYPrix(double prixmin );
    @Query(value = " select * from produit where idclient !=?1  ", nativeQuery = true)
    List<Produit> selectProduit(int idclient );

    public Produit findById(int id);








}
