package org.example.tpcafeachraf_benmouelli.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name ="detailcommande")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Detail_Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idDetailCommande;
    @Column(name="QuantiteArticle")
    int quantiteArticle;
    @Column(name="SousTotalDetailArticle")
    float sousTotalDetailArticle;
    @Column(name="SousTotalDetailArticleApresPromo")
    float sousTotalDetailArticleApresPromo;
    ///////////////////////////////////////////
    @ManyToOne
    Commande commande;
    @ManyToOne
    Article article;
    ///////////////////////////////////////////
}
