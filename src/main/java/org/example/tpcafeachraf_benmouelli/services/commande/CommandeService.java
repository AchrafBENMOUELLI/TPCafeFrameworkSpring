package org.example.tpcafeachraf_benmouelli.services.commande;

import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.commande.CommandeRequest;
import org.example.tpcafeachraf_benmouelli.dto.commande.CommandeResponse;
import org.example.tpcafeachraf_benmouelli.entities.Commande;
import org.example.tpcafeachraf_benmouelli.mappers.commande.CommandeMapper;
import org.example.tpcafeachraf_benmouelli.repositories.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommandeService implements ICommandeService {

    private CommandeRepository commandeRepository;
    private CommandeMapper commandeMapper;

    // ─────────────── Nouvelles méthodes avec DTOs ───────────────
    @Override
    public CommandeResponse addCommande(CommandeRequest dto) {
        Commande commande = commandeMapper.toEntity(dto);
        Commande saved = commandeRepository.save(commande);
        return commandeMapper.toDto(saved);
    }

    @Override
    public List<CommandeResponse> saveCommandes(List<CommandeRequest> dtos) {
        List<Commande> commandes = dtos.stream()
                .map(commandeMapper::toEntity)
                .toList();
        List<Commande> savedList = commandeRepository.saveAll(commandes);
        return savedList.stream()
                .map(commandeMapper::toDto)
                .toList();
    }

    @Override
    public CommandeResponse selectCommandeById(long id) {
        Commande commande = commandeRepository.findById(id).orElse(null);
        return (commande != null) ? commandeMapper.toDto(commande) : null;
    }

    @Override
    public List<CommandeResponse> selectAllCommandes() {
        List<Commande> commandes = commandeRepository.findAll();
        return commandes.stream()
                .map(commandeMapper::toDto)
                .toList();
    }

    @Override
    public void deleteCommandeById(long id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public void deleteAllCommandes() {
        commandeRepository.deleteAll();
    }

    @Override
    public long countingCommandes() {
        return commandeRepository.count();
    }

    @Override
    public boolean verifCommande(long id) {
        return commandeRepository.existsById(id);
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
}
