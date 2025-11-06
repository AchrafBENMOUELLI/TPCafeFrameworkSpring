package org.example.tpcafeachraf_benmouelli.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "commande")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idCommande;
    @Temporal(TemporalType.DATE)
    @Column(name="dateCommande")
    LocalDate dateCommande;
    @Column(name="TotalCommande")
    float totalCommande;
    @Column(name="StatusCommande")
    @Enumerated(EnumType.STRING)
    StatusCommande statusCommande;
    /////////////////////////////
    @ManyToOne
    Client client;
    @OneToMany(mappedBy = "commande")
    List<Detail_Commande> detail_commande;
    ////////////////////////////
}
