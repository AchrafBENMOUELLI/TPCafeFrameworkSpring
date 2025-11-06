package org.example.tpcafeachraf_benmouelli.dto.article;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDetailCommandeResponse {
    private long idDetailCommande;
    private int quantiteArticle;
    private float sousTotalDetailArticle;
    private float sousTotalDetailArticleApresPromo;
}
