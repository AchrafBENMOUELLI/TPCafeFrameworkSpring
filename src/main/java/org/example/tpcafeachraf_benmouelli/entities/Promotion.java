package org.example.tpcafeachraf_benmouelli.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "promotion")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idPromotion;
    @Column(name="PourcentagePromo")
    String pourcentagePromo;
    @Temporal(TemporalType.DATE)
    @Column(name="DateDebutPromo")
    LocalDate dateDebutPromo;
    @Temporal(TemporalType.DATE)
    @Column(name="DateFinPromo")
    LocalDate dateFinPromo;
    ///////////////////////////
    @ManyToMany(mappedBy = "promotions")
    private List<Article> articles = new ArrayList<>();

    ////////////////////////////
}
