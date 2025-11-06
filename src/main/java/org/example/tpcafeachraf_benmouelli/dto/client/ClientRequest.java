package org.example.tpcafeachraf_benmouelli.dto.client;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientRequest {
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    // ⚙️ On envoie seulement les IDs des entités liées dans le Request
    private Long adresseId;
    private Long carteFideliteId;
}
