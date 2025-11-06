package org.example.tpcafeachraf_benmouelli.mappers.promotion;

import org.example.tpcafeachraf_benmouelli.dto.promotion.PromotionRequest;
import org.example.tpcafeachraf_benmouelli.dto.promotion.PromotionResponse;
import org.example.tpcafeachraf_benmouelli.entities.Promotion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {org.example.tpcafeachraf_benmouelli.mappers.article.ArticleMapper.class})
public interface PromotionMapper {
    PromotionResponse toDto(Promotion promotion);

   /* @Mapping(target = "idPromotion", ignore = true) // ID auto-généré
    @Mapping(target = "articles", ignore = true)*/
    Promotion toEntity(PromotionRequest request);
}
