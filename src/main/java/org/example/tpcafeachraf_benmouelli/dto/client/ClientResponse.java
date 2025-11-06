package org.example.tpcafeachraf_benmouelli.dto.client;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.tpcafeachraf_benmouelli.dto.adresse.AdresseResponse;
import org.example.tpcafeachraf_benmouelli.dto.cartefidelite.CarteFideliteResponse;

import java.time.LocalDate;
import java.util.List;
import org.example.tpcafeachraf_benmouelli.dto.commande.CommandeResponse;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientResponse {
    private Long idClient;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    // 💳 Relations mappées avec d’autres DTOs
    private AdresseResponse adresse;
    private CarteFideliteResponse carteFidelite;
    private List<CommandeResponse> commandes;
}
