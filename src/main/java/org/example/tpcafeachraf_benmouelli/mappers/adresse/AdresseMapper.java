package org.example.tpcafeachraf_benmouelli.mappers.adresse;

import org.example.tpcafeachraf_benmouelli.dto.adresse.AdresseRequest;
import org.example.tpcafeachraf_benmouelli.dto.adresse.AdresseResponse;
import org.example.tpcafeachraf_benmouelli.entities.Adresse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdresseMapper {
    AdresseResponse toDto(Adresse adresse);

    @Mapping(target = "idAdresse", ignore = true)
    Adresse toEntity(AdresseRequest request);
}
