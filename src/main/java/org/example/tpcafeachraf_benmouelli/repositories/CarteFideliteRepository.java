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
    List<CarteFidelite> findByExactPoints(@Param("pts") int pts);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.dateCreation = :date")
    List<CarteFidelite> findByCreationDate(@Param("date") LocalDate date);

    @Query("SELECT COUNT(cf) FROM CarteFidelite cf WHERE cf.pointAccumules > :pts")
    Long countByPointsGreaterThan(@Param("pts") int pts);

    @Query("DELETE FROM CarteFidelite cf WHERE cf.dateCreation < :date")
    void deleteCreatedBefore(@Param("date") LocalDate date);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.pointAccumules BETWEEN :min AND :max AND cf.dateCreation > :date")
    List<CarteFidelite> findByPointsBetweenAndCreatedAfter(@Param("min") int min, @Param("max") int max, @Param("date") LocalDate date);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.pointAccumules >= :pts ORDER BY cf.dateCreation ASC")
    List<CarteFidelite> findByMinPointsOrderByCreationDate(@Param("pts") int pts);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.dateCreation BETWEEN :start AND :end")
    List<CarteFidelite> findByCreationBetween(@Param("start") LocalDate start, @Param("end") LocalDate end);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.pointAccumules <= :pts OR cf.dateCreation < :date")
    List<CarteFidelite> findByPointsLessOrCreatedBefore(@Param("pts") int pts, @Param("date") LocalDate date);

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.pointAccumules = (SELECT MAX(c.pointAccumules) FROM CarteFidelite c)")
    CarteFidelite findCardWithMaxPoints();

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.dateCreation IS NULL")
    List<CarteFidelite> findByCreationDateIsNull();

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.pointAccumules IS NOT NULL")
    List<CarteFidelite> findByPointsIsNotNull();

    @Query("SELECT cf FROM CarteFidelite cf WHERE cf.client.nom = :nom AND cf.client.prenom = :prenom")
    List<CarteFidelite> findByClientName(@Param("nom") String nom, @Param("prenom") String prenom);

    @Query("SELECT cf FROM CarteFidelite cf ORDER BY cf.pointAccumules DESC")
    List<CarteFidelite> findTop5ByPoints();
}
