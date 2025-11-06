package org.example.tpcafeachraf_benmouelli.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
    @OneToMany(mappedBy = "article")
    List<Detail_Commande> detailCommandes;
    @ManyToMany
    List<Promotion> promotions;
    /////////////////////////////
}
