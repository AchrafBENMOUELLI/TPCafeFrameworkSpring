package org.example.tpcafeachraf_benmouelli.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Client")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idClient;
    @Column(name="LastName")
    String nom;
    @Column(name="FirstName")
    String prenom;
    @Temporal(TemporalType.DATE)
    @Column(name="dateNaissance")
    LocalDate dateNaissance;
    //////////////////////////////////////////////
    //relations
    @OneToOne
    Adresse adresse;
    @OneToOne(mappedBy = "client")
    CarteFidelite carteFidelite;
    @OneToMany(mappedBy = "client")
    List<Commande> commandes;
    //////////////////////////////////////////////
}
