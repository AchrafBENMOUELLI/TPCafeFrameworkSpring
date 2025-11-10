package org.example.tpcafeachraf_benmouelli.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "article")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idArticle;
    @Column(name="nomArticle")
    String nomArticle;
    @Column(name="PrixArticle")
    float prixArticle;
    @Column(name="TypeArticle")
    @Enumerated(EnumType.STRING)
    TypeArticle typeArticle;
    /////////////////////////////
    @ManyToMany
    @JoinTable(
            name = "article_promotions", // le nom exact de ta table intermédiaire
            joinColumns = @JoinColumn(name = "articles_id_article"),        // colonne vers Article
            inverseJoinColumns = @JoinColumn(name = "promotions_id_promotion") // colonne vers Promotion
    )
    private List<Promotion> promotions = new ArrayList<>();

}
