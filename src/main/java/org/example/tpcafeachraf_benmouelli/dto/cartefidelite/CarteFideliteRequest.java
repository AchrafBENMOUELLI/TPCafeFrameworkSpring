package org.example.tpcafeachraf_benmouelli.dto.cartefidelite;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarteFideliteRequest {

    private int pointAccumules;
    private LocalDate dateCreation;

    // Si tu veux créer une carte avec un client existant :
    private Long clientId;
}
