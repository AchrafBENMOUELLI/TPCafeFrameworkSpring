package org.example.tpcafeachraf_benmouelli.services.carteFidelite;

import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.cartefidelite.CarteFideliteRequest;
import org.example.tpcafeachraf_benmouelli.dto.cartefidelite.CarteFideliteResponse;
import org.example.tpcafeachraf_benmouelli.entities.CarteFidelite;
import org.example.tpcafeachraf_benmouelli.mappers.cartefidelite.CarteFideliteMapper;
import org.example.tpcafeachraf_benmouelli.repositories.CarteFideliteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarteFideliteService implements ICarteFideliteService {

    private CarteFideliteRepository carteFideliteRepository;
    private CarteFideliteMapper carteFideliteMapper;

    @Override
    public CarteFideliteResponse addCarteFidelite(CarteFideliteRequest request) {
        CarteFidelite carte = carteFideliteMapper.toEntity(request);
        CarteFidelite saved = carteFideliteRepository.save(carte);
        return carteFideliteMapper.toDto(saved);
    }

    @Override
    public List<CarteFideliteResponse> saveCarteFidelites(List<CarteFideliteRequest> cartes) {
        List<CarteFidelite> entities = cartes.stream()
                .map(carteFideliteMapper::toEntity)
                .collect(Collectors.toList());
        return carteFideliteRepository.saveAll(entities).stream()
                .map(carteFideliteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarteFideliteResponse selectCarteFidelite(long id) {
        CarteFidelite carte = carteFideliteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carte fidélité introuvable avec id : " + id));
        return carteFideliteMapper.toDto(carte);
    }

    @Override
    public List<CarteFideliteResponse> selectAllCarteFidelites() {
        return carteFideliteRepository.findAll().stream()
                .map(carteFideliteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCarteFidelite(long id) {
        carteFideliteRepository.deleteById(id);
    }

    @Override
    public void deleteAllCarteFidelites() {
        carteFideliteRepository.deleteAll();
    }

    @Override
    public long countingCarteFidelites() {
        return carteFideliteRepository.count();
    }

    @Override
    public boolean verifyCarteFidelite(long id) {
        return carteFideliteRepository.existsById(id);
    }

    // ──────────────── Anciennes méthodes conservées ────────────────
    /*
    @Override
    public CarteFidelite addCarteFidelite(CarteFidelite carte) {
        return carteFideliteRepository.save(carte);
    }

    @Override
    public List<CarteFidelite> saveCarteFidelites(List<CarteFidelite> cartes) {
        return carteFideliteRepository.saveAll(cartes);
    }

    @Override
    public CarteFidelite selectCarteFidelite(long id) {
        return carteFideliteRepository.findById(id).get();
    }

    @Override
    public List<CarteFidelite> selectAllCarteFidelites() {
        return carteFideliteRepository.findAll();
    }

    @Override
    public List<CarteFidelite> selectAllCarteFidelites(List<CarteFidelite> cartes) {
        return carteFideliteRepository.findAll();
    }

    @Override
    public void deleteCarteFidelite(CarteFidelite carte) {
        carteFideliteRepository.delete(carte);
    }

    @Override
    public void deleteAllCarteFidelites() {
        carteFideliteRepository.deleteAll();
    }

    @Override
    public void deleteCarteFidelite(long id) {
        carteFideliteRepository.deleteById(id);
    }

    @Override
    public long countingCarteFidelites() {
        return carteFideliteRepository.count();
    }

    @Override
    public boolean verifyCarteFidelite(long id) {
        return carteFideliteRepository.existsById(id);
    }
    */
}
