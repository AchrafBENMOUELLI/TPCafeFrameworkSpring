package org.example.tpcafeachraf_benmouelli.repositories;

import org.example.tpcafeachraf_benmouelli.entities.Article;
import org.example.tpcafeachraf_benmouelli.entities.TypeArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT a FROM Article a WHERE a.nomArticle = :nom")
    List<Article> getByNom(@Param("nom") String nom);

    @Query("SELECT a FROM Article a WHERE a.typeArticle = :type")
    List<Article> getByType(@Param("type") TypeArticle type);

    @Query("SELECT a FROM Article a WHERE a.prixArticle = :prix")
    List<Article> getByPrix(@Param("prix") float prix);

    @Query("SELECT COUNT(a) > 0 FROM Article a WHERE a.nomArticle = :nom")
    boolean existsByNom(@Param("nom") String nom);

    @Query("SELECT COUNT(a) FROM Article a WHERE a.typeArticle = :type")
    Long countByType(@Param("type") TypeArticle type);

    @Query("SELECT a FROM Article a WHERE LOWER(a.nomArticle) LIKE LOWER(CONCAT('%', :value, '%')) AND a.typeArticle = :type")
    List<Article> getByNomContainsAndType(@Param("value") String value, @Param("type") TypeArticle type);

    @Query("SELECT a FROM Article a WHERE a.prixArticle BETWEEN :min AND :max AND a.typeArticle IN :types")
    List<Article> getByPrixBetweenAndTypeIn(@Param("min") float min, @Param("max") float max, @Param("types") List<TypeArticle> types);

    @Query("SELECT a FROM Article a WHERE LOWER(a.nomArticle) LIKE LOWER(CONCAT(:prefix, '%')) ORDER BY a.prixArticle ASC")
    List<Article> getByNomStartsWithOrderByPrix(@Param("prefix") String prefix);

    @Query("SELECT a FROM Article a WHERE a.typeArticle = :type AND a.prixArticle = (SELECT MAX(a2.prixArticle) FROM Article a2 WHERE a2.typeArticle = :type)")
    List<Article> getMaxPrixByType(@Param("type") TypeArticle type);

    @Query("SELECT a FROM Article a WHERE a.nomArticle = :value OR a.typeArticle = :type ORDER BY a.prixArticle DESC")
    List<Article> getByNomOrTypeOrderByPrixDesc(@Param("value") String value, @Param("type") TypeArticle type);

    @Query("SELECT a FROM Article a WHERE LOWER(a.nomArticle) LIKE LOWER(CONCAT(:prefix, '%'))")
    List<Article> getByNomStartingWith(@Param("prefix") String prefix);

    @Query("SELECT a FROM Article a WHERE LOWER(a.nomArticle) LIKE LOWER(CONCAT('%', :suffix))")
    List<Article> getByNomEndingWith(@Param("suffix") String suffix);

    @Query("SELECT a FROM Article a WHERE a.typeArticle IS NULL")
    List<Article> getArticlesWithoutType();

    @Query("SELECT a FROM Article a WHERE a.prixArticle IS NOT NULL")
    List<Article> getArticlesWithPrix();

    /*@Query("SELECT a FROM Article a JOIN a.promotions p WHERE p.active = true")
    List<Article> getArticlesWithActivePromotions();*/

    @Query("SELECT a FROM Article a WHERE LOWER(a.nomArticle) LIKE LOWER(CONCAT('%', :value, '%')) AND a.prixArticle BETWEEN :min AND :max")
    List<Article> getByNomContainsAndPrixBetween(@Param("value") String value, @Param("min") float min, @Param("max") float max);
}
