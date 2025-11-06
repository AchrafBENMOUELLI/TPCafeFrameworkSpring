package org.example.tpcafeachraf_benmouelli.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "cartefidelite")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CarteFidelite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idCarteFidelite;
    @Column(name="PointAccumules")
    int pointAccumules;
    @Temporal(TemporalType.DATE)
    @Column(name="DateCreation")
    LocalDate dateCreation;
    ////////////////////////////////////
    @OneToOne
    Client client;
    ////////////////////////////////////
}
