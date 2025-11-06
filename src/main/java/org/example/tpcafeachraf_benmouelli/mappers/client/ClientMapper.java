package org.example.tpcafeachraf_benmouelli.mappers.client;

import org.example.tpcafeachraf_benmouelli.dto.client.ClientRequest;
import org.example.tpcafeachraf_benmouelli.dto.client.ClientResponse;
import org.example.tpcafeachraf_benmouelli.entities.Client;
import org.example.tpcafeachraf_benmouelli.mappers.adresse.AdresseMapper;
import org.example.tpcafeachraf_benmouelli.mappers.cartefidelite.CarteFideliteMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AdresseMapper.class, CarteFideliteMapper.class})
public interface ClientMapper {
    ClientResponse toDto(Client client);

    @Mapping(target = "idClient", ignore = true)
    @Mapping(target = "adresse", ignore = true)
    @Mapping(target = "carteFidelite", ignore = true)
    @Mapping(target = "commandes", ignore = true)
    Client toEntity(ClientRequest request);
}
