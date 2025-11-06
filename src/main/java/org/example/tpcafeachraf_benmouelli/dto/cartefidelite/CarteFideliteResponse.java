package org.example.tpcafeachraf_benmouelli.dto.cartefidelite;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.tpcafeachraf_benmouelli.dto.client.ClientResponse;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarteFideliteResponse {

    private long idCarteFidelite;
    private int pointAccumules;
    private LocalDate dateCreation;

    // Tu peux renvoyer un résumé du client
    private ClientResponse client;
}
