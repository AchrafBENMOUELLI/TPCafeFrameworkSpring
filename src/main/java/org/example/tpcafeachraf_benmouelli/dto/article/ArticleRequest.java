package org.example.tpcafeachraf_benmouelli.dto.article;

import lombok.*;
import org.example.tpcafeachraf_benmouelli.entities.TypeArticle;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleRequest {
    private String nomArticle;
    private float prixArticle;
    private TypeArticle typeArticle;
}
