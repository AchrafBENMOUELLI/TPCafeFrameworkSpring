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


    @Override
    public ArticleResponse addArticle(ArticleRequest dto) {
        Article article = articleMapper.toEntity(dto);
        Article saved = articleRepository.save(article);
        return articleMapper.toDto(saved);
    }


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


    @Override
    public ArticleResponse selectArticleById(long id) {
        return articleRepository.findById(id)
                .map(articleMapper::toDto)
                .orElse(null);
    }


    @Override
    public List<ArticleResponse> selectAllArticles() {
        return articleRepository.findAll()
                .stream()
                .map(articleMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public void deleteArticleById(long id) {
        articleRepository.deleteById(id);
    }


    @Override
    public void deleteAllArticles() {
        articleRepository.deleteAll();
    }


    @Override
    public long countingArticles() {
        return articleRepository.count();
    }


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

    @Override
    public void ajouterPromoEtAffecterAArticle(Promotion p, long idArticle) {
        Article article = articleRepository.findById(idArticle).get();
        article.getPromotions().add(p);
        articleRepository.save(article);
    }
////////////////////////////
}


////////////////////////////////////////////////////////////////////////////////////////////////

