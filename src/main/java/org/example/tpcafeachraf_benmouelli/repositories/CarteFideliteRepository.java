package org.example.tpcafeachraf_benmouelli.repositories;

import org.example.tpcafeachraf_benmouelli.entities.CarteFidelite;
import org.example.tpcafeachraf_benmouelli.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CarteFideliteRepository extends JpaRepository<CarteFidelite, Long> {
    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.pointAccumules = :pts")
    List<CarteFidelite> getByPointAccumules(@Param("pts") int pts);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.pointAccumules > :pts")
    List<CarteFidelite> getByPointAccumulesGreaterThan(@Param("pts") int pts);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.pointAccumules >= :pts")
    List<CarteFidelite> getByPointAccumulesGreaterOrEqual(@Param("pts") int pts);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.pointAccumules < :pts")
    List<CarteFidelite> getByPointAccumulesLessThan(@Param("pts") int pts);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.pointAccumules <= :pts")
    List<CarteFidelite> getByPointAccumulesLessOrEqual(@Param("pts") int pts);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.pointAccumules BETWEEN :min AND :max")
    List<CarteFidelite> getByPointAccumulesBetween(@Param("min") int min, @Param("max") int max);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.dateCreation = :date")
    List<CarteFidelite> getByDateCreation(@Param("date") LocalDate date);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.dateCreation > :date")
    List<CarteFidelite> getCreatedAfter(@Param("date") LocalDate date);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.dateCreation < :date")
    List<CarteFidelite> getCreatedBefore(@Param("date") LocalDate date);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.client.idClient = :idClient")
    CarteFidelite getByClientId(@Param("idClient") Long idClient);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.client.nom = :nom")
    List<CarteFidelite> getByClientNom(@Param("nom") String nom);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.client.prenom = :prenom")
    List<CarteFidelite> getByClientPrenom(@Param("prenom") String prenom);

    @Query("SELECT cf FROM CarteFidelite cf WHERE LOWER(cf.client.nom) LIKE LOWER(CONCAT('%', :value, '%'))")
    List<CarteFidelite> getByClientNomContains(@Param("value") String value);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.client.adresse.ville = :ville")
    List<CarteFidelite> getByClientVille(@Param("ville") String ville);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.client IN :clients")
    List<CarteFidelite> getByClientList(@Param("clients") List<Client> clients);
}
