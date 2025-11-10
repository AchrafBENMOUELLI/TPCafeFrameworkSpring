package org.example.tpcafeachraf_benmouelli.mappers.detailscommande;

import org.example.tpcafeachraf_benmouelli.dto.datailscommande.DetailCommandeRequest;
import org.example.tpcafeachraf_benmouelli.dto.datailscommande.DetailCommandeResponse;
import org.example.tpcafeachraf_benmouelli.entities.Detail_Commande;
import org.example.tpcafeachraf_benmouelli.mappers.article.ArticleMapper;
import org.example.tpcafeachraf_benmouelli.mappers.commande.CommandeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CommandeMapper.class, ArticleMapper.class})
public interface DetailCommandeMapper {
    @Mapping(target = "articleId", source = "article.idArticle")
    DetailCommandeResponse toDto(Detail_Commande detailCommande);
    @Mapping(target = "idDetailCommande", ignore = true)
    @Mapping(target = "commande", ignore = true)   // lié dans service
    @Mapping(target = "article", ignore = true)    // lié dans service
    Detail_Commande toEntity(DetailCommandeRequest request);
}
