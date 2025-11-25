package org.example.tpcafeachraf_benmouelli.services.article;

import org.example.tpcafeachraf_benmouelli.dto.article.ArticleRequest;
import org.example.tpcafeachraf_benmouelli.dto.article.ArticleResponse;
import org.example.tpcafeachraf_benmouelli.entities.Article;
import org.example.tpcafeachraf_benmouelli.entities.Promotion;

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

    //less affectation ssimples//
    Article ajouterArticleEtPromotions(Article article);

    //*bonus*//
    void affecterPromotionAArticle(long idArticle, long idPromo);
    void desaffecterPromotionDUnArticle(long idArticle, long idPromo);
    ///////////////////////////////
    void ajouterPromoEtAffecterAArticle(Promotion p , long idArticle);


}
