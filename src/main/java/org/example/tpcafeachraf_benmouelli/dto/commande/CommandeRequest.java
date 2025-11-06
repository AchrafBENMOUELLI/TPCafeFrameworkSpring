package org.example.tpcafeachraf_benmouelli.dto.commande;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.tpcafeachraf_benmouelli.entities.StatusCommande;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommandeRequest {
    private LocalDate dateCommande;
    private float totalCommande;
    private StatusCommande statusCommande;

    // ⚙️ Relations : on envoie seulement les IDs
    private Long clientId;
}
