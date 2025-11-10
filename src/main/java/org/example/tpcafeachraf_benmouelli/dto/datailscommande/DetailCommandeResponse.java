package org.example.tpcafeachraf_benmouelli.dto.datailscommande;

import lombok.*;
import org.example.tpcafeachraf_benmouelli.dto.article.ArticleResponse;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailCommandeResponse {
    private long idDetailCommande;
    private int quantiteArticle;
    private float sousTotalDetailArticle;
    private float sousTotalDetailArticleApresPromo;

    private Long articleId;
}
