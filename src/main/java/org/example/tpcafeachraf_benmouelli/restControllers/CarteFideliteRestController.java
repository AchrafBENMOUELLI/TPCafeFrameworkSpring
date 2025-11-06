package org.example.tpcafeachraf_benmouelli.restControllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.cartefidelite.CarteFideliteRequest;
import org.example.tpcafeachraf_benmouelli.dto.cartefidelite.CarteFideliteResponse;
import org.example.tpcafeachraf_benmouelli.services.carteFidelite.ICarteFideliteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartefidelite")
@AllArgsConstructor
@Tag(name = "CarteFidelite", description = "Endpoints pour la gestion des cartes de fidélité")
public class CarteFideliteRestController {

    private final ICarteFideliteService carteFideliteService;

    @GetMapping
    @Operation(
            summary = "Récupérer toutes les cartes fidélité",
            description = "Retourne la liste complète des cartes de fidélité enregistrées",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cartes récupérées avec succès"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            }
    )
    public List<CarteFideliteResponse> displayAllCarteFidelite() {
        return carteFideliteService.selectAllCarteFidelites();
    }

    @PostMapping
    @Operation(
            summary = "Ajouter une carte fidélité",
            description = "Crée une nouvelle carte fidélité dans le système"
    )
    public CarteFideliteResponse addCarteFidelite(@RequestBody CarteFideliteRequest request) {
        return carteFideliteService.addCarteFidelite(request);
    }

    @PostMapping("/addall")
    @Operation(
            summary = "Ajouter plusieurs cartes fidélité",
            description = "Permet d’ajouter une liste de cartes de fidélité"
    )
    public List<CarteFideliteResponse> addAllCarteFidelites(@RequestBody List<CarteFideliteRequest> requests) {
        return carteFideliteService.saveCarteFidelites(requests);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Afficher une carte fidélité par ID",
            description = "Retourne les informations détaillées d'une carte fidélité spécifique"
    )
    public CarteFideliteResponse displayCarteFideliteById(@PathVariable long id) {
        return carteFideliteService.selectCarteFidelite(id);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Supprimer une carte fidélité",
            description = "Supprime une carte fidélité selon son ID"
    )
    public void deleteCarteFideliteById(@PathVariable long id) {
        carteFideliteService.deleteCarteFidelite(id);
    }

    @DeleteMapping("/deleteAll")
    @Operation(
            summary = "Supprimer toutes les cartes fidélité",
            description = "Supprime toutes les cartes fidélité du système"
    )
    public void deleteAllCarteFidelites() {
        carteFideliteService.deleteAllCarteFidelites();
    }

    @GetMapping("/count")
    @Operation(
            summary = "Compter le nombre de cartes fidélité",
            description = "Retourne le nombre total de cartes enregistrées"
    )
    public long countAllCarteFidelites() {
        return carteFideliteService.countingCarteFidelites();
    }

    @GetMapping("/exists/{id}")
    @Operation(
            summary = "Vérifier l’existence d’une carte fidélité",
            description = "Renvoie true si la carte existe, sinon false"
    )
    public boolean existCarteFidelite(@PathVariable long id) {
        return carteFideliteService.verifyCarteFidelite(id);
    }

    // ──────────────── Anciennes méthodes conservées ────────────────
    /*
    @GetMapping
    public List<CarteFidelite> displayallCarteFidelite() {
        return carteFideliteService.selectAllCarteFidelites();
    }

    @PostMapping
    public CarteFidelite addcartefidelite(@RequestBody CarteFidelite carteFidelite) {
        return carteFideliteService.addCarteFidelite(carteFidelite);
    }

    @PostMapping("/addallcartefidelite")
    public List<CarteFidelite> addallCartefidelite(@RequestBody List<CarteFidelite> carteFidelites) {
        return carteFideliteService.saveCarteFidelites(carteFidelites);
    }

    @PostMapping("/displaycartefidelitebyId/{id}")
    public CarteFidelite displaycartefidelitebyId(@PathVariable long id) {
        return carteFideliteService.selectCarteFidelite(id);
    }

    @DeleteMapping("/deletecartefidelitebyId/{id}")
    public void deleteCartefidelitebyId(@PathVariable long id) {
        carteFideliteService.deleteCarteFidelite(id);
    }

    @DeleteMapping("/deleteallcartefidelite")
    public void deleteallCartefidelite(@RequestBody List<CarteFidelite> carteFidelites) {
        carteFideliteService.deleteAllCarteFidelites();
    }

    @GetMapping("/countallcartefidelite")
    public long countallcartefidelite() {
        return carteFideliteService.countingCarteFidelites();
    }

    @GetMapping("/existcartefid/{id}")
    public boolean existcartefid(@PathVariable long id) {
        return carteFideliteService.verifyCarteFidelite(id);
    }
    */
}
