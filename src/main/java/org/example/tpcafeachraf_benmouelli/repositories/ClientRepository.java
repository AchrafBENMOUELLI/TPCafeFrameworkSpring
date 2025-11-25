package org.example.tpcafeachraf_benmouelli.repositories;

import org.example.tpcafeachraf_benmouelli.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.example.tpcafeachraf_benmouelli.entities.TypeArticle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Long> {
   List<Client> findByNom(String nom);

    List<Client> findByPrenom(String prenom);

    Client findByNomAndPrenom(String nom, String prenom);

    boolean existsByNom(String nom);

    Long countByDateNaissanceAfter(LocalDate date);

    List<Client> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(String nom, String prenom);

    List<Client> findByNomContainingIgnoreCaseAndPrenomContainingIgnoreCase(String nom, String prenom);

    List<Client> findByDateNaissanceBetween(LocalDate start, LocalDate end);

    List<Client> findByNomStartingWithIgnoreCaseAndDateNaissanceBefore(String prefix, LocalDate date);

    List<Client> findByAdresse_Ville(String ville);

    List<Client> findByNomContainingIgnoreCaseOrderByPrenomAsc(String nom);

    List<Client> findByNomContainingIgnoreCaseOrderByPrenomDesc(String nom);

    List<Client> findByNomStartingWithIgnoreCase(String ch);

    List<Client> findByPrenomEndingWithIgnoreCase(String ch);

    List<Client> findByDateNaissanceIsNull();

    List<Client> findByAdresseIsNotNull();

    List<Client> findByAdresse_VilleIn(List<String> villes);

    List<Client> findByCarteFidelite_PointAccumulesGreaterThan(Integer pts);

    List<Client> findByCarteFidelite_PointAccumulesGreaterThanEqual(Integer pts);

    List<Client> findByCarteFidelite_PointAccumulesBetween(Integer min, Integer max);
/*
    List<Client> findByCommandesDetail_commandeArticleNomArticle(String nomArticle);
*/
@Query("SELECT c FROM Client c JOIN c.commandes com JOIN com.detail_commande d JOIN d.article a WHERE a.nomArticle = :nomArticle")
List<Client> findClientsByNomArticle(@Param("nomArticle") String nomArticle);
/*
 List<Client> findByNomContainingIgnoreCaseAndCommandesDetail_commandeTypeArticle(String nom, TypeArticle typeArticle);
*/
@Query("""
    SELECT c FROM Client c 
    JOIN c.commandes com 
    JOIN com.detail_commande d 
    WHERE LOWER(c.nom) LIKE LOWER(CONCAT('%', :nom, '%')) 
""")
List<Client> findClientsByNomAndTypeArticle(
        @Param("nom") String nom,
        @Param("typeArticle") TypeArticle typeArticle
);

 //les affectations simple//
    Client findByIdClient(long cin);
    ///////////////////////////
}
