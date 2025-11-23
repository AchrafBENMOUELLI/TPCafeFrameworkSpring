package org.example.tpcafeachraf_benmouelli.services.commande;

import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.commande.CommandeRequest;
import org.example.tpcafeachraf_benmouelli.dto.commande.CommandeResponse;
import org.example.tpcafeachraf_benmouelli.entities.Commande;
import org.example.tpcafeachraf_benmouelli.entities.Detail_Commande;
import org.example.tpcafeachraf_benmouelli.mappers.commande.CommandeMapper;
import org.example.tpcafeachraf_benmouelli.mappers.detailscommande.DetailCommandeMapper;
import org.example.tpcafeachraf_benmouelli.repositories.ClientRepository;
import org.example.tpcafeachraf_benmouelli.repositories.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CommandeService implements ICommandeService {

    private final CommandeRepository commandeRepository;
    private final CommandeMapper commandeMapper;
    private final ClientRepository clientRepository;
    private final DetailCommandeMapper detailCommandeMapper;

    // ─────────────── Ajout d'une commande ───────────────
    @Override
    public CommandeResponse addCommande(CommandeRequest dto) {
        Commande commande = commandeMapper.toEntity(dto);

        // Lier le client
        if (dto.getClientId() != null) {
            clientRepository.findById(dto.getClientId())
                    .ifPresent(commande::setClient);
        }

        // Initialiser la liste des détails si null
        if (commande.getDetail_commande() == null) {
            commande.setDetail_commande(new ArrayList<>());
        }

        // Lier les détails
        if (dto.getDetails() != null) {
            dto.getDetails().forEach(detailDto -> {
                Detail_Commande detail = detailCommandeMapper.toEntity(detailDto);
                detail.setCommande(commande);
                commande.getDetail_commande().add(detail);
            });
        }

        Commande saved = commandeRepository.save(commande);
        return commandeMapper.toDto(saved);
    }

    // ─────────────── Ajout multiple ───────────────
    @Override
    public List<CommandeResponse> saveCommandes(List<CommandeRequest> dtos) {
        List<CommandeResponse> responses = new ArrayList<>();
        for (CommandeRequest dto : dtos) {
            responses.add(addCommande(dto)); // réutilise la méthode addCommande
        }
        return responses;
    }

    // ─────────────── Récupérer par ID ───────────────
    @Override
    public CommandeResponse selectCommandeById(long id) {
        return commandeRepository.findById(id)
                .map(commandeMapper::toDto)
                .orElse(null);
    }

    // ─────────────── Récupérer toutes les commandes ───────────────
    @Override
    public List<CommandeResponse> selectAllCommandes() {
        List<Commande> commandes = commandeRepository.findAll();
        return commandes.stream()
                .map(commandeMapper::toDto)
                .toList();
    }

    // ─────────────── Suppression par ID ───────────────
    @Override
    public void deleteCommandeById(long id) {
        commandeRepository.deleteById(id);
    }

    // ─────────────── Suppression de toutes les commandes ───────────────
    @Override
    public void deleteAllCommandes() {
        commandeRepository.deleteAll();
    }

    // ─────────────── Compter les commandes ───────────────
    @Override
    public long countingCommandes() {
        return commandeRepository.count();
    }

    // ─────────────── Vérifier existence ───────────────
    @Override
    public boolean verifCommande(long id) {
        return commandeRepository.existsById(id);
    }




//les affectations simples//
    @Override
    public void desaffecterClientDeCommande(long idCommande) {
        Commande commande = commandeRepository.findById(idCommande).get();
        commande.setClient(null);
        commandeRepository.save(commande);
    }
//////////////////////////////////////
}


// ─────────────── Anciennes méthodes conservées ───────────────
    /*
    @Override
    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public List<Commande> saveCommandes(List<Commande> commandes) {
        return commandeRepository.saveAll(commandes);
    }

    @Override
    public Commande selectCommandeById(long id) {
        return commandeRepository.findById(id).get();
    }

    @Override
    public List<Commande> selectAllCommandes() {
        return List.of();
    }

    @Override
    public List<Commande> selectAllCommandes(List<Commande> commandes) {
        return commandeRepository.findAll();
    }

    @Override
    public void deleteCommande(Commande commande) {
        commandeRepository.delete(commande);
    }

    @Override
    public void deleteAllCommandes() {
        commandeRepository.deleteAll();
    }

    @Override
    public void deleteCommandeById(long id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public long countingCommandes() {
        return commandeRepository.count();
    }

    @Override
    public boolean verifCommande(long id) {
        return commandeRepository.existsById(id);
    }
    */

