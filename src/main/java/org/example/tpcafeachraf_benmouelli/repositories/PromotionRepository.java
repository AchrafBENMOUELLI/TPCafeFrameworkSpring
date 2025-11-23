package org.example.tpcafeachraf_benmouelli.repositories;
import org.example.tpcafeachraf_benmouelli.entities.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    @Query(value = "SELECT * FROM promotion WHERE PourcentagePromo = ?1", nativeQuery = true)
    List<Promotion> findByPourcentage(String pourcentage);

    @Query(value = "SELECT * FROM promotion WHERE DateDebutPromo = ?1", nativeQuery = true)
    List<Promotion> findByDateDebut(LocalDate dateDebut);

    @Query(value = "SELECT * FROM promotion WHERE DateFinPromo = ?1", nativeQuery = true)
    List<Promotion> findByDateFin(LocalDate dateFin);

    @Query(value = "SELECT COUNT(*) > 0 FROM promotion WHERE PourcentagePromo = ?1", nativeQuery = true)
    boolean existsByPourcentage(String pourcentage);

    @Query(value = "SELECT COUNT(*) FROM promotion WHERE DateDebutPromo > ?1", nativeQuery = true)
    Long countByDateDebutAfter(LocalDate date);

    @Query(value = "SELECT * FROM promotion WHERE DateDebutPromo <= ?1 AND DateFinPromo >= ?1", nativeQuery = true)
    List<Promotion> findActiveAtDate(LocalDate date);

    @Query(value = "SELECT * FROM promotion WHERE PourcentagePromo = ?1 AND DateDebutPromo BETWEEN ?2 AND ?3", nativeQuery = true)
    List<Promotion> findByPourcentageAndDateDebutBetween(String pourcentage, LocalDate start, LocalDate end);

    @Query(value = "SELECT * FROM promotion WHERE DateDebutPromo <= ?1 AND DateFinPromo >= ?1", nativeQuery = true)
    List<Promotion> findValidAtDate(LocalDate date);

    @Query(value = "SELECT * FROM promotion WHERE PourcentagePromo IN ?1 ORDER BY DateDebutPromo ASC", nativeQuery = true)
    List<Promotion> findByPourcentagesOrderByDateDebut(List<String> pourcentages);

    @Query(value = "SELECT * FROM promotion WHERE DateDebutPromo <= CURRENT_DATE AND DateFinPromo >= CURRENT_DATE ORDER BY PourcentagePromo ASC", nativeQuery = true)
    List<Promotion> findActiveOrderByPourcentage();

    @Query(value = "SELECT * FROM promotion WHERE DateFinPromo IS NULL", nativeQuery = true)
    List<Promotion> findWithoutDateFin();

    @Query(value = "SELECT * FROM promotion WHERE PourcentagePromo IS NOT NULL", nativeQuery = true)
    List<Promotion> findWithPourcentage();

    @Query(value = "SELECT p.*, a.* FROM promotion p LEFT JOIN article_promotions ap ON p.idPromotion = ap.promotions_id_promotion LEFT JOIN article a ON ap.articles_id_article = a.idArticle", nativeQuery = true)
    List<Object[]> findWithArticles();

    @Query(value = "SELECT * FROM promotion WHERE DateFinPromo < CURRENT_DATE", nativeQuery = true)
    List<Promotion> findExpired();
}
