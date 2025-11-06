package org.example.tpcafeachraf_benmouelli.services.detail_commande;

import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.datailscommande.DetailCommandeRequest;
import org.example.tpcafeachraf_benmouelli.dto.datailscommande.DetailCommandeResponse;
import org.example.tpcafeachraf_benmouelli.entities.Detail_Commande;
import org.example.tpcafeachraf_benmouelli.mappers.detailscommande.DetailCommandeMapper;
import org.example.tpcafeachraf_benmouelli.repositories.DetailCommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class Detail_commandeService implements IDetail_commandeSerivce {

    private DetailCommandeRepository detailCommandeRepository;
    private DetailCommandeMapper detailCommandeMapper;

    // ✅ Nouvelles méthodes avec DTO
    @Override
    public DetailCommandeResponse addDetailCommande(DetailCommandeRequest dto) {
        Detail_Commande entity = detailCommandeMapper.toEntity(dto);
        Detail_Commande saved = detailCommandeRepository.save(entity);
        return detailCommandeMapper.toDto(saved);
    }

    @Override
    public List<DetailCommandeResponse> saveDetailCommandes(List<DetailCommandeRequest> dtos) {
        List<Detail_Commande> entities = dtos.stream()
                .map(detailCommandeMapper::toEntity)
                .collect(Collectors.toList());
        List<Detail_Commande> saved = detailCommandeRepository.saveAll(entities);
        return saved.stream().map(detailCommandeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public DetailCommandeResponse selectDetailCommande(long id) {
        return detailCommandeRepository.findById(id)
                .map(detailCommandeMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<DetailCommandeResponse> selectAllDetailCommandes() {
        return detailCommandeRepository.findAll().stream()
                .map(detailCommandeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDetailCommandeById(long id) {
        detailCommandeRepository.deleteById(id);
    }

    @Override
    public void deleteAllDetailCommandes() {
        detailCommandeRepository.deleteAll();
    }

    @Override
    public long countingDetailCommandes() {
        return detailCommandeRepository.count();
    }

    @Override
    public boolean verifyDetailCommande(long id) {
        return detailCommandeRepository.existsById(id);
    }

    // ─────────────── Anciennes méthodes conservées ───────────────
    /*
    @Override
    public Detail_Commande addDetail_commande(Detail_Commande dc) {
        return detailCommandeRepository.save(dc);
    }

    @Override
    public List<Detail_Commande> saveDetail_commande(List<Detail_Commande> detailCommandes) {
        return detailCommandeRepository.saveAll(detailCommandes);
    }

    @Override
    public Detail_Commande selectDetail_commande(long id) {
        return detailCommandeRepository.findById(id).get();
    }

    @Override
    public List<Detail_Commande> selectDetail_commandes() {
        return List.of();
    }

    @Override
    public List<Detail_Commande> selectDetail_commandes(List<Detail_Commande> detailCommandes) {
        return detailCommandeRepository.findAll();
    }

    @Override
    public void deleteDetail_commandes(Detail_Commande dc) {
        detailCommandeRepository.delete(dc);
    }
    */
}
