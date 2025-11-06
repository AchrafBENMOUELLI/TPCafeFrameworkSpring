package org.example.tpcafeachraf_benmouelli.dto.promotion;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionRequest {
    String pourcentagePromo;
    LocalDate dateDebutPromo;
    LocalDate dateFinPromo;
    List<Long> articleIds; // IDs des articles concernés
}

