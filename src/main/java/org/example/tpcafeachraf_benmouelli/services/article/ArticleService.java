package org.example.tpcafeachraf_benmouelli.services.article;

import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.article.ArticleRequest;
import org.example.tpcafeachraf_benmouelli.dto.article.ArticleResponse;
import org.example.tpcafeachraf_benmouelli.entities.Article;
import org.example.tpcafeachraf_benmouelli.entities.Promotion;
import org.example.tpcafeachraf_benmouelli.mappers.article.ArticleMapper;
import org.example.tpcafeachraf_benmouelli.repositories.ArticleRepository;
import org.example.tpcafeachraf_benmouelli.repositories.PromotionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArticleService implements IArticleService {

    private final ArticleRepository articleRepository;
    private final PromotionRepository promotionRepository;
    private final ArticleMapper articleMapper;

    // Ajouter un article
    @Override
    public ArticleResponse addArticle(ArticleRequest dto) {
        Article article = articleMapper.toEntity(dto);
        Article saved = articleRepository.save(article);
        return articleMapper.toDto(saved);
    }

    // Ajouter plusieurs articles
    @Override
    public List<ArticleResponse> saveArticles(List<ArticleRequest> articlesRequest) {
        List<Article> articles = articlesRequest.stream()
                .map(articleMapper::toEntity)
                .collect(Collectors.toList());
        List<Article> saved = articleRepository.saveAll(articles);
        return saved.stream()
                .map(articleMapper::toDto)
                .collect(Collectors.toList());
    }

    // Sélection par ID
    @Override
    public ArticleResponse selectArticleById(long id) {
        return articleRepository.findById(id)
                .map(articleMapper::toDto)
                .orElse(null);
    }

    // Sélection de tous les articles
    @Override
    public List<ArticleResponse> selectAllArticles() {
        return articleRepository.findAll()
                .stream()
                .map(articleMapper::toDto)
                .collect(Collectors.toList());
    }

    // Supprimer par ID
    @Override
    public void deleteArticleById(long id) {
        articleRepository.deleteById(id);
    }

    // Supprimer tous les articles
    @Override
    public void deleteAllArticles() {
        articleRepository.deleteAll();
    }

    // Compter les articles
    @Override
    public long countingArticles() {
        return articleRepository.count();
    }

    // Vérifier existence par ID
    @Override
    public boolean verifyArticle(long id) {
        return articleRepository.existsById(id);
    }
//les affectations simples//
    @Override
    public Article ajouterArticleEtPromotions(Article article) {
        Article savedArticle = articleRepository.save(article);

        if (article.getPromotions() != null) {
            for (Promotion promo : article.getPromotions()) {
                if (!promo.getArticles().contains(savedArticle)) {
                    promo.getArticles().add(savedArticle);
                }
            }
            savedArticle.setPromotions(article.getPromotions());
        }
        return articleRepository.save(savedArticle);
    }

    @Override
    public void affecterPromotionAArticle(long idArticle, long idPromo) {
        Article article = articleRepository.findById(idArticle).get();
        Promotion promo = promotionRepository.findById(idPromo).get();

        article.getPromotions().add(promo);
        articleRepository.save(article);
    }

    @Override
    public void desaffecterPromotionDUnArticle(long idArticle, long idPromo) {
        Article article = articleRepository.findById(idArticle).get();
        Promotion promo = promotionRepository.findById(idPromo).get();

        article.getPromotions().remove(promo);
        articleRepository.save(article);
    }
////////////////////////////
}


////////////////////////////////////////////////////////////////////////////////////////////////


//package org.example.tpcafeachraf_benmouelli.services.article;
//
//import lombok.AllArgsConstructor;
//import org.example.tpcafeachraf_benmouelli.dto.article.ArticleRequest;
//import org.example.tpcafeachraf_benmouelli.dto.article.ArticleResponse;
//import org.example.tpcafeachraf_benmouelli.entities.Article;
//import org.example.tpcafeachraf_benmouelli.mappers.article.ArticleMapper;
//import org.example.tpcafeachraf_benmouelli.repositories.ArticleRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@AllArgsConstructor
//public class ArticleService implements IArticleService {
//
//    private ArticleRepository articleRepository;
//    private ArticleMapper articleMapper;
//
//    //////////////////////////////////////////
//    // 🔄 Nouvelle version avec DTOs
//    @Override
//    public ArticleResponse addArticle(ArticleRequest dto) {
//        Article article = articleMapper.toEntity(dto);
//        Article saved = articleRepository.save(article);
//        return articleMapper.toDto(saved);
//    }
//    //////////////////////////////////////////
//    /* Ancienne version :
//    @Override
//    public Article addArticle(Article ar) {
//        return articleRepository.save(ar);
//    }
//    */
//
//    //////////////////////////////////////////
//    // 🔄 Nouvelle version avec DTOs
//    @Override
//    public ArticleResponse selectArticleById(long id) {
//        Article article = articleRepository.findById(id).orElse(null);
//        return (article != null) ? articleMapper.toDto(article) : null;
//    }
//    //////////////////////////////////////////
//    /* Ancienne version :
//    @Override
//    public Article selectArticleById(long id) {
//        return articleRepository.findById(id).get();
//    }
//    */
//
//    //////////////////////////////////////////
//    // 🔄 Sauvegarde de plusieurs articles via DTO
//    @Override
//    public List<ArticleResponse> saveArticles(List<ArticleRequest> articlesRequest) {
//        List<Article> articles = articlesRequest.stream()
//                .map(articleMapper::toEntity)
//                .collect(Collectors.toList());
//
//        List<Article> saved = articleRepository.saveAll(articles);
//        return saved.stream()
//                .map(articleMapper::toDto)
//                .collect(Collectors.toList());
//    }
//    //////////////////////////////////////////
//    /* Ancienne version :
//    @Override
//    public List<Article> saveArticles(List<Article> ar) {
//        return articleRepository.saveAll(ar);
//    }
//    */
//
//    //////////////////////////////////////////
//    // 🔄 Récupérer tous les articles
//    @Override
//    public List<ArticleResponse> selectAllArticles() {
//        return articleRepository.findAll()
//                .stream()
//                .map(articleMapper::toDto)
//                .collect(Collectors.toList());
//    }
//    //////////////////////////////////////////
//    /* Ancienne version :
//    @Override
//    public List<Article> selectAllArticles() {
//        return articleRepository.findAll();
//    }
//    */
//
//    //////////////////////////////////////////
//    // 🔄 Supprimer un article par ID
//    @Override
//    public void deleteArticleById(long id) {
//        articleRepository.deleteById(id);
//    }
//
//    //////////////////////////////////////////
//    // 🔄 Supprimer tous les articles
//    @Override
//    public void deleteAllArticles() {
//        articleRepository.deleteAll();
//    }
//
//    //////////////////////////////////////////
//    // 🔄 Compter le nombre total d’articles
//    @Override
//    public long countingArticles() {
//        return articleRepository.count();
//    }
//
//    //////////////////////////////////////////
//    // 🔄 Vérifier si un article existe par ID
//    @Override
//    public boolean verifyArticle(long id) {
//        return articleRepository.existsById(id);
//    }
//
//    //////////////////////////////////////////
//    /* Anciennes méthodes non utilisées :
//    @Override
//    public List<Article> selectAllArticles(List<Article> ar) {
//        return List.of();
//    }
//
//    @Override
//    public void deleteArticle(Article ar) {
//        articleRepository.delete(ar);
//    }
//    */
//}
