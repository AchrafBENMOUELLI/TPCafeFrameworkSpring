package org.example.tpcafeachraf_benmouelli.mappers.commande;

import org.example.tpcafeachraf_benmouelli.dto.commande.CommandeRequest;
import org.example.tpcafeachraf_benmouelli.dto.commande.CommandeResponse;
import org.example.tpcafeachraf_benmouelli.entities.Commande;
import org.example.tpcafeachraf_benmouelli.mappers.client.ClientMapper;
import org.example.tpcafeachraf_benmouelli.mappers.detailscommande.DetailCommandeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, DetailCommandeMapper.class})
public interface CommandeMapper {
    CommandeResponse toDto(Commande commande);

   @Mapping(target = "idCommande", ignore = true)           // ID auto-généré
    @Mapping(target = "client", ignore = true)              // relation Client ignorée pour la création
    @Mapping(target = "detailCommandes", ignore = true)
    Commande toEntity(CommandeRequest request);
}
