package org.example.tpcafeachraf_benmouelli.mappers.cartefidelite;

import org.example.tpcafeachraf_benmouelli.dto.cartefidelite.CarteFideliteRequest;
import org.example.tpcafeachraf_benmouelli.dto.cartefidelite.CarteFideliteResponse;
import org.example.tpcafeachraf_benmouelli.entities.CarteFidelite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarteFideliteMapper {
    @Mapping(target = "client", ignore = true)
    CarteFideliteResponse toDto(CarteFidelite carteFidelite);

   @Mapping(target = "idCarteFidelite", ignore = true)
   @Mapping(target = "client", ignore = true)
    CarteFidelite toEntity(CarteFideliteRequest request);
}
