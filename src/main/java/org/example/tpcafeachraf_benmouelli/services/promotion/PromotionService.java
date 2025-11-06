package org.example.tpcafeachraf_benmouelli.services.promotion;

import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.promotion.PromotionRequest;
import org.example.tpcafeachraf_benmouelli.dto.promotion.PromotionResponse;
import org.example.tpcafeachraf_benmouelli.entities.Promotion;
import org.example.tpcafeachraf_benmouelli.mappers.promotion.PromotionMapper;
import org.example.tpcafeachraf_benmouelli.repositories.PromotionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PromotionService implements IPromotionService {

    private PromotionRepository promotionRepository;
    private PromotionMapper promotionMapper;

    // ───────────── Nouvelles méthodes avec DTO ─────────────
    @Override
    public PromotionResponse addPromotion(PromotionRequest promotionRequest) {
        Promotion promotion = promotionMapper.toEntity(promotionRequest);
        Promotion saved = promotionRepository.save(promotion);
        return promotionMapper.toDto(saved);
    }

    @Override
    public List<PromotionResponse> savePromotions(List<PromotionRequest> promotionRequests) {
        List<Promotion> promotions = promotionRequests.stream()
                .map(promotionMapper::toEntity)
                .collect(Collectors.toList());
        List<Promotion> saved = promotionRepository.saveAll(promotions);
        return saved.stream()
                .map(promotionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PromotionResponse selectPromotionById(long id) {
        Promotion promotion = promotionRepository.findById(id).orElseThrow();
        return promotionMapper.toDto(promotion);
    }

    @Override
    public List<PromotionResponse> selectAllPromotions() {
        return promotionRepository.findAll().stream()
                .map(promotionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePromotionById(long id) {
        promotionRepository.deleteById(id);
    }

    @Override
    public void deleteAllPromotions() {
        promotionRepository.deleteAll();
    }

    @Override
    public long countingPromotions() {
        return promotionRepository.count();
    }

    @Override
    public boolean verifyPromotion(long id) {
        return promotionRepository.existsById(id);
    }

    // ───────────── Anciennes méthodes avec entité brute ─────────────
    /*
    public Promotion addPromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    public List<Promotion> savePromotions(List<Promotion> promotions) {
        return promotionRepository.saveAll(promotions);
    }

    public Promotion selectPromotionById(long id) {
        return promotionRepository.findById(id).get();
    }

    public List<Promotion> selectAllPromotions(List<Promotion> promotions) {
        return promotionRepository.findAll();
    }

    public void deletePromotion(Promotion promotion) {
        promotionRepository.delete(promotion);
    }

    public void deleteAllPromotions() {
        promotionRepository.deleteAll();
    }

    public void deletePromotionById(long id) {
        promotionRepository.deleteById(id);
    }

    public long countingPromotions() {
        return promotionRepository.count();
    }

    public boolean verifPromotion(long id) {
        return promotionRepository.existsById(id);
    }
    */
}
