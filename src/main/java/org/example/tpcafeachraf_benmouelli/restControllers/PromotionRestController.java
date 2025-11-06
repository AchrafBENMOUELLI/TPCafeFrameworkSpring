package org.example.tpcafeachraf_benmouelli.restControllers;

import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.promotion.PromotionRequest;
import org.example.tpcafeachraf_benmouelli.dto.promotion.PromotionResponse;
import org.example.tpcafeachraf_benmouelli.services.promotion.IPromotionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotion")
@AllArgsConstructor
public class PromotionRestController {

    private final IPromotionService promotionService;

    // ───────────── Nouvelles méthodes avec DTO ─────────────
    @GetMapping
    public List<PromotionResponse> displayAllPromotions() {
        return promotionService.selectAllPromotions();
    }

    @PostMapping
    public PromotionResponse addPromotion(@RequestBody PromotionRequest promotionRequest) {
        return promotionService.addPromotion(promotionRequest);
    }

    @PostMapping("/addall")
    public List<PromotionResponse> addAllPromotions(@RequestBody List<PromotionRequest> promotionRequests) {
        return promotionService.savePromotions(promotionRequests);
    }

    @GetMapping("/{id}")
    public PromotionResponse displayPromotionById(@PathVariable long id) {
        return promotionService.selectPromotionById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePromotionById(@PathVariable long id) {
        promotionService.deletePromotionById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllPromotions() {
        promotionService.deleteAllPromotions();
    }

    @GetMapping("/count")
    public long countAllPromotions() {
        return promotionService.countingPromotions();
    }

    @GetMapping("/exists/{id}")
    public boolean existPromotion(@PathVariable long id) {
        return promotionService.verifyPromotion(id);
    }

    // ───────────── Anciennes méthodes avec entité brute ─────────────
    /*
    @GetMapping
    public List<Promotion> displayallpromotions() { ... }

    @PostMapping
    public Promotion addpromotion(@RequestBody Promotion promotion) { ... }

    @PostMapping("/addallPromotion")
    public List<Promotion> addallpromotion(@RequestBody List<Promotion> promotions) { ... }

    @GetMapping("/displaypromotionbyId/{id}")
    public Promotion displaypromotionbyId(@PathVariable int id) { ... }

    @DeleteMapping("/deletepromotionbyId/{id}")
    public void deletepromotionbyId(@PathVariable int id) { ... }

    @DeleteMapping("/deleteallpromotion")
    public void deleteallpromotion(@RequestBody List<Promotion> promotions) { ... }

    @GetMapping("/countallpromotion")
    public long countallpromotion() { ... }

    @GetMapping("/existpromotion/{id}")
    public boolean existpromotion(@PathVariable int id) { ... }
    */
}
