package org.example.tpcafeachraf_benmouelli.dto.datailscommande;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailCommandeRequest {
    private long commandeId;
    private long articleId;
    private int quantiteArticle;
    private float sousTotalDetailArticle;
    private float sousTotalDetailArticleApresPromo;
}
