package org.example.tpcafeachraf_benmouelli.dto.article;

import lombok.*;
import org.example.tpcafeachraf_benmouelli.entities.TypeArticle;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleResponse {
    private long idArticle;
    private String nomArticle;
    private float prixArticle;
    private TypeArticle typeArticle;

    // Relation avec les détails de commande
    private List<ArticleDetailCommandeResponse> detailCommandes;
}
