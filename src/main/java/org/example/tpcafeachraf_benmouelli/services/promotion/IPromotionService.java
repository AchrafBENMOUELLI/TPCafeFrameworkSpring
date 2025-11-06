package org.example.tpcafeachraf_benmouelli.services.promotion;

import org.example.tpcafeachraf_benmouelli.dto.promotion.PromotionRequest;
import org.example.tpcafeachraf_benmouelli.dto.promotion.PromotionResponse;

import java.util.List;

public interface IPromotionService {

    // ───────────── Nouvelles méthodes avec DTO ─────────────
    PromotionResponse addPromotion(PromotionRequest promotionRequest);
    List<PromotionResponse> savePromotions(List<PromotionRequest> promotionRequests);
    PromotionResponse selectPromotionById(long id);
    List<PromotionResponse> selectAllPromotions();
    void deletePromotionById(long id);
    void deleteAllPromotions();
    long countingPromotions();
    boolean verifyPromotion(long id);

    // ───────────── Anciennes méthodes avec entité brute ─────────────
    /*
    Promotion addPromotion(Promotion promotion);
    List<Promotion> savePromotions(List<Promotion> promotions);
    Promotion selectPromotionById(long id);
    List<Promotion> selectAllPromotions();
    void deletePromotion(Promotion promotion);
    void deleteAllPromotions();
    void deletePromotionById(long id);
    long countingPromotions();
    boolean verifPromotion(long id);
    */
}
