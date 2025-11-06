package org.example.tpcafeachraf_benmouelli.mappers.article;

import org.example.tpcafeachraf_benmouelli.dto.article.ArticleDetailCommandeResponse;
import org.example.tpcafeachraf_benmouelli.entities.Detail_Commande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArticleDetailCommandeMapper {
    ArticleDetailCommandeResponse toDto(Detail_Commande detailCommande);
}

