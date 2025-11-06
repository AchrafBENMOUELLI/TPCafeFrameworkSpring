package org.example.tpcafeachraf_benmouelli.services.article;

import org.example.tpcafeachraf_benmouelli.dto.article.ArticleRequest;
import org.example.tpcafeachraf_benmouelli.dto.article.ArticleResponse;
import org.example.tpcafeachraf_benmouelli.entities.Article;

import java.util.List;

public interface IArticleService {

    // ✅ Nouvelle version avec DTO
    ArticleResponse addArticle(ArticleRequest articleRequest);
    ArticleResponse selectArticleById(long id);
    List<ArticleResponse> saveArticles(List<ArticleRequest> articlesRequest);
    List<ArticleResponse> selectAllArticles();
    void deleteArticleById(long id);
    void deleteAllArticles();
    long countingArticles();
    boolean verifyArticle(long id);

    /*
    Article addArticle(Article ar);
    Article selectArticleById(long id);
    List<Article> saveArticles(List<Article> ar);
    List<Article> selectAllArticles();
    List<Article> selectAllArticles(List<Article> ar);
    void deleteArticle(Article ar);
    void deleteAllArticles();
    void deleteArticleById(long id);
    long countingArticles();
    boolean verifyArticle(long id);
    */
}
