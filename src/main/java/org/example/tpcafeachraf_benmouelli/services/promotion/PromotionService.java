package org.example.tpcafeachraf_benmouelli.services.promotion;

import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.promotion.PromotionRequest;
import org.example.tpcafeachraf_benmouelli.dto.promotion.PromotionResponse;
import org.example.tpcafeachraf_benmouelli.entities.Article;
import org.example.tpcafeachraf_benmouelli.entities.Promotion;
import org.example.tpcafeachraf_benmouelli.mappers.promotion.PromotionMapper;
import org.example.tpcafeachraf_benmouelli.repositories.ArticleRepository;
import org.example.tpcafeachraf_benmouelli.repositories.PromotionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PromotionService implements IPromotionService {

    private final PromotionRepository promotionRepository;
    private final ArticleRepository articleRepository;
    private final PromotionMapper promotionMapper;

    // ───────────── Ajouter une promotion avec articles ─────────────
    @Override
    public PromotionResponse addPromotion(PromotionRequest promotionRequest) {
        Promotion promotion = promotionMapper.toEntity(promotionRequest);

        // Lier les articles si fournis
        if (promotionRequest.getArticleIds() != null) {
            List<Article> articles = promotionRequest.getArticleIds().stream()
                    .map(id -> articleRepository.findById(id).orElse(null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            promotion.setArticles(articles);
        } else {
            promotion.setArticles(List.of());
        }


        Promotion saved = promotionRepository.save(promotion);

        return promotionMapper.toDto(saved);
    }

    // ───────────── Ajouter plusieurs promotions ─────────────
    @Override
    public List<PromotionResponse> savePromotions(List<PromotionRequest> promotionRequests) {
        return promotionRequests.stream()
                .map(this::addPromotion) // réutilise addPromotion
                .collect(Collectors.toList());
    }

    // ───────────── Sélectionner par ID ─────────────
    @Override
    public PromotionResponse selectPromotionById(long id) {
        Promotion promotion = promotionRepository.findById(id).orElseThrow();
        return promotionMapper.toDto(promotion);
    }

    // ───────────── Sélectionner toutes les promotions ─────────────
    @Override
    public List<PromotionResponse> selectAllPromotions() {
        return promotionRepository.findAll().stream()
                .map(promotionMapper::toDto)
                .collect(Collectors.toList());
    }

    // ───────────── Supprimer par ID ─────────────
    @Override
    public void deletePromotionById(long id) {
        promotionRepository.deleteById(id);
    }

    // ───────────── Supprimer toutes les promotions ─────────────
    @Override
    public void deleteAllPromotions() {
        promotionRepository.deleteAll();
    }

    // ───────────── Compter les promotions ─────────────
    @Override
    public long countingPromotions() {
        return promotionRepository.count();
    }

    // ───────────── Vérifier existence ─────────────
    @Override
    public boolean verifyPromotion(long id) {
        return promotionRepository.existsById(id);
    }
}
