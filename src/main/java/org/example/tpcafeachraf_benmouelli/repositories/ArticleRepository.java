package org.example.tpcafeachraf_benmouelli.repositories;

import org.example.tpcafeachraf_benmouelli.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
