package org.example.tpcafeachraf_benmouelli.mappers.article;

import org.example.tpcafeachraf_benmouelli.dto.article.ArticleRequest;
import org.example.tpcafeachraf_benmouelli.dto.article.ArticleResponse;
import org.example.tpcafeachraf_benmouelli.entities.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ArticleDetailCommandeMapper.class)
public interface ArticleMapper {
    ArticleResponse toDto(Article article);
    @Mapping(target = "idArticle", ignore = true)
    @Mapping(target = "detailCommandes", ignore = true) // lié dans service
    @Mapping(target = "promotions", ignore = true)     // optionnel, éviter boucle
    Article toEntity(ArticleRequest request);
}
