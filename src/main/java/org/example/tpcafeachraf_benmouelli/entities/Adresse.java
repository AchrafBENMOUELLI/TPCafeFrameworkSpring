package org.example.tpcafeachraf_benmouelli.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Adresse")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idAdresse;
    @Column(name = "rue")
    String rue;
    @Column(name = "ville")
    String ville;
    @Column(name = "codePostal")
    int codePostal;

}
