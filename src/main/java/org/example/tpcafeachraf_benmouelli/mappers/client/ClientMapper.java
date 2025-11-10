package org.example.tpcafeachraf_benmouelli.mappers.client;

import org.example.tpcafeachraf_benmouelli.dto.client.ClientRequest;
import org.example.tpcafeachraf_benmouelli.dto.client.ClientResponse;
import org.example.tpcafeachraf_benmouelli.entities.Client;
import org.example.tpcafeachraf_benmouelli.mappers.adresse.AdresseMapper;
import org.example.tpcafeachraf_benmouelli.mappers.cartefidelite.CarteFideliteMapper;
import org.example.tpcafeachraf_benmouelli.mappers.commande.CommandeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AdresseMapper.class, CarteFideliteMapper.class, CommandeMapper.class})
public interface ClientMapper {

    // ✅ Convertir entity en DTO avec toutes les relations
    @Mapping(target = "commandes", ignore = true)
    ClientResponse toDto(Client client);

    // ⚙️ Convertir DTO en entity pour création/update
    @Mapping(target = "idClient", ignore = true)        // on ignore l'id lors de la création
    @Mapping(target = "adresse", ignore = true)        // sera lié dans le service
    @Mapping(target = "carteFidelite", ignore = true)  // sera lié dans le service
    @Mapping(target = "commandes", ignore = true)      // sera rempli automatiquement si besoin
    Client toEntity(ClientRequest request);
}
