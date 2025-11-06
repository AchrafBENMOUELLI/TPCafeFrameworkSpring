package org.example.tpcafeachraf_benmouelli.services.carteFidelite;

import org.example.tpcafeachraf_benmouelli.dto.cartefidelite.CarteFideliteRequest;
import org.example.tpcafeachraf_benmouelli.dto.cartefidelite.CarteFideliteResponse;

import java.util.List;

public interface ICarteFideliteService {

    CarteFideliteResponse addCarteFidelite(CarteFideliteRequest carte);
    List<CarteFideliteResponse> saveCarteFidelites(List<CarteFideliteRequest> cartes);
    CarteFideliteResponse selectCarteFidelite(long id);
    List<CarteFideliteResponse> selectAllCarteFidelites();
    void deleteCarteFidelite(long id);
    void deleteAllCarteFidelites();
    long countingCarteFidelites();
    boolean verifyCarteFidelite(long id);

    // ──────────── Anciennes méthodes conservées ────────────
    /*
    CarteFidelite addCarteFidelite(CarteFidelite carte);
    List<CarteFidelite> saveCarteFidelites(List<CarteFidelite> cartes);
    CarteFidelite selectCarteFidelite(long id);
    List<CarteFidelite> selectAllCarteFidelites();
    List<CarteFidelite> selectAllCarteFidelites(List<CarteFidelite> cartes);
    void deleteCarteFidelite(CarteFidelite carte);
    void deleteAllCarteFidelites();
    void deleteCarteFidelite(long id);
    long countingCarteFidelites();
    boolean verifyCarteFidelite(long id);
    */
}
