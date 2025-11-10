package org.example.tpcafeachraf_benmouelli.mappers.commande;

import org.example.tpcafeachraf_benmouelli.dto.commande.CommandeRequest;
import org.example.tpcafeachraf_benmouelli.dto.commande.CommandeResponse;
import org.example.tpcafeachraf_benmouelli.entities.Commande;
import org.example.tpcafeachraf_benmouelli.mappers.client.ClientMapper;
import org.example.tpcafeachraf_benmouelli.mappers.detailscommande.DetailCommandeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, DetailCommandeMapper.class})
public interface CommandeMapper {

    @Mapping(target = "client", source = "client")
    @Mapping(target = "detailCommandes", source = "detail_commande")
    CommandeResponse toDto(Commande commande);

    List<CommandeResponse> toDtoList(List<Commande> commandes);

    @Mapping(target = "idCommande", ignore = true)
    @Mapping(target = "client", ignore = true) // côté création, on lie manuellement
    @Mapping(target = "detail_commande", ignore = true)
    Commande toEntity(CommandeRequest dto);
}

