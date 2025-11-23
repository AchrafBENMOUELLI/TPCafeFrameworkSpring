package org.example.tpcafeachraf_benmouelli.restControllers;

import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.article.ArticleRequest;
import org.example.tpcafeachraf_benmouelli.dto.article.ArticleResponse;
import org.example.tpcafeachraf_benmouelli.entities.Article;
import org.example.tpcafeachraf_benmouelli.services.article.IArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@AllArgsConstructor
public class ArticleRestController {

    private final IArticleService articleService;


    @PostMapping
    public ArticleResponse addArticle(@RequestBody ArticleRequest dto) {
        return articleService.addArticle(dto);
    }


    @PostMapping("/all")
    public List<ArticleResponse> addAllArticles(@RequestBody List<ArticleRequest> dtoList) {
        return articleService.saveArticles(dtoList);
    }


    @GetMapping
    public List<ArticleResponse> displayAllArticles() {
        return articleService.selectAllArticles();
    }

    @GetMapping("/{id}")
    public ArticleResponse displayArticleById(@PathVariable long id) {
        return articleService.selectArticleById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteArticleById(@PathVariable long id) {
        articleService.deleteArticleById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllArticles() {
        articleService.deleteAllArticles();
    }

    @GetMapping("/count")
    public long countAllArticles() {
        return articleService.countingArticles();
    }

    @GetMapping("/exists/{id}")
    public boolean existArticle(@PathVariable long id) {
        return articleService.verifyArticle(id);
    }

    /*les methodes simples*/
    @PostMapping("/add")
    public Article ajouterArticleEtPromotions(@RequestBody Article article) {
        return articleService.ajouterArticleEtPromotions(article);
    }
    //////////////////////////////////////
}
