package org.example.tpcafeachraf_benmouelli.dto.promotion;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.tpcafeachraf_benmouelli.dto.article.ArticleResponse;

import java.time.LocalDate;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionResponse {
    long idPromotion;
    String pourcentagePromo;
    LocalDate dateDebutPromo;
    LocalDate dateFinPromo;

    List<ArticleResponse> articles; // réutilisation de ton DTO d'article
}
