package org.example.tpcafeachraf_benmouelli.repositories;

import org.example.tpcafeachraf_benmouelli.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

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

    List<Client> findByCarteFidelite_PtsAccumulesGreaterThan(Integer pts);

    List<Client> findByCarteFidelite_PtsAccumulesGreaterThanEqual(Integer pts);

    List<Client> findByCarteFidelite_PtsAccumulesBetween(Integer min, Integer max);

    List<Client> findByCommandes_Articles_Nom(String nomArticle);

    List<Client> findByNomContainingIgnoreCaseAndCommandes_Articles_Type(String nom, String typeArticle);

    //les affectations simple//
    Client findByCin(long cin);
    ///////////////////////////
}
