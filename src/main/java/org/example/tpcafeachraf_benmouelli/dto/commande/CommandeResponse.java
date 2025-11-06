package org.example.tpcafeachraf_benmouelli.dto.commande;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.tpcafeachraf_benmouelli.dto.client.ClientResponse;
import org.example.tpcafeachraf_benmouelli.dto.datailscommande.DetailCommandeResponse;

import java.time.LocalDate;
import java.util.List;
import org.example.tpcafeachraf_benmouelli.entities.StatusCommande;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommandeResponse {
    private Long idCommande;
    private LocalDate dateCommande;
    private float totalCommande;
    private StatusCommande statusCommande;

    // 🔗 Relations
    private ClientResponse client;
    private List<DetailCommandeResponse> detailCommandes;
}
