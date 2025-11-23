package org.example.tpcafeachraf_benmouelli.repositories;

import org.example.tpcafeachraf_benmouelli.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.example.tpcafeachraf_benmouelli.entities.TypeArticle;


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

    List<Client> findByCommandes_Detail_commande_Article_NomArticle(String nomArticle);

    List<Client> findByNomContainingIgnoreCaseAndCommandes_Detail_commande_Article_TypeArticle(String nom, TypeArticle typeArticle);

    //les affectations simple//
    Client findByIdClient(long cin);
    ///////////////////////////
}
