package org.example.tpcafeachraf_benmouelli.repositories;

import org.example.tpcafeachraf_benmouelli.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    @Query(value = "SELECT * FROM commande WHERE StatusCommande = ?1", nativeQuery = true)
    List<Commande> findByStatus(String status);

    @Query(value = "SELECT * FROM commande WHERE dateCommande = ?1", nativeQuery = true)
    List<Commande> findByDateExact(LocalDate date);

    @Query(value = "SELECT StatusCommande, COUNT(*) AS nb_commandes FROM commande GROUP BY StatusCommande", nativeQuery = true)
    List<Object[]> countByStatus();

    @Modifying
    @Query(value = "DELETE FROM commande WHERE dateCommande < ?1", nativeQuery = true)
    void deleteBeforeDate(LocalDate date);

    @Query(value = "SELECT * FROM commande WHERE dateCommande BETWEEN ?1 AND ?2 AND StatusCommande = ?3", nativeQuery = true)
    List<Commande> findBetweenDatesWithStatus(LocalDate start, LocalDate end, String status);

    @Query(value = "SELECT * FROM commande WHERE totalCommande > ?1 AND StatusCommande <> ?2", nativeQuery = true)
    List<Commande> findTotalGreaterThanAndStatusNot(float total, String status);

    @Query(value = "SELECT * FROM commande WHERE StatusCommande IN ?1 ORDER BY dateCommande ASC", nativeQuery = true)
    List<Commande> findByStatusInOrderByDate(List<String> statuses);

    @Query(value = "SELECT * FROM commande WHERE dateCommande < ?1 AND totalCommande BETWEEN ?2 AND ?3", nativeQuery = true)
    List<Commande> findBeforeDateWithTotalRange(LocalDate date, float minTotal, float maxTotal);

    @Query(value = "SELECT * FROM commande WHERE StatusCommande LIKE ?1", nativeQuery = true)
    List<Commande> findStatusEndingWith(String pattern);

    @Query(value = "SELECT * FROM commande WHERE StatusCommande IS NULL", nativeQuery = true)
    List<Commande> findWithoutStatus();

    @Query(value = "SELECT * FROM commande WHERE totalCommande IS NOT NULL", nativeQuery = true)
    List<Commande> findWithTotal();

    @Query(value = "SELECT c.*, dc.*, cl.* FROM commande c LEFT JOIN detail_commande dc ON c.idCommande = dc.commande_idCommande LEFT JOIN client cl ON c.client_id = cl.idClient", nativeQuery = true)
    List<Object[]> findWithDetailsAndClient();

    @Query(value = "SELECT * FROM commande ORDER BY dateCommande DESC LIMIT 3", nativeQuery = true)
    List<Commande> findTop3Recent();



    /*les affectation simples*/
    Commande findByDateCommande(LocalDate dateCommande);
    //////////////////////////////////////////////
}
