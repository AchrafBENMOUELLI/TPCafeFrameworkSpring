package org.example.tpcafeachraf_benmouelli.dto.adresse;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdresseRequest {
    private String rue;
    private String ville;
    private int codePostal;
}
