package enchere_ws.repository;

import enchere_ws.model.Produit;
import enchere_ws.model.Produitclient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProduitclientRepository extends JpaRepository<Produitclient, Long> {
    @Query(value = "select * from produitclient where idclient = ?1  ", nativeQuery = true)
    List<Produitclient> rechercheBYidclient(int idclient );
    @Query(value = "select * from produitclient where idclient = ?1 order by (dureeenchereminute+dateenchere) desc ", nativeQuery = true)
    List<Produitclient> produitVita(int idclient );
    @Query(value = "select * from produitclient where statu != 0 ", nativeQuery = true)
    List<Produitclient> produitTsyclient();
    @Query(value = "select * from produitclient where id=?1 ", nativeQuery = true)
    List<Produitclient> produitBYId(int idproduit);
    @Query(value = "select * from produitclient where (nomproduit =?1 or prixmin <=?2 or nomcategorie =?3)  AND statu=1 ", nativeQuery = true)
    List<Produitclient> recherche(String nomproduit, double prixmin,String nomcategorie);
}
