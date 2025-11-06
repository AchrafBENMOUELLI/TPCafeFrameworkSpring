package org.example.tpcafeachraf_benmouelli.restControllers;

import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.datailscommande.DetailCommandeRequest;
import org.example.tpcafeachraf_benmouelli.dto.datailscommande.DetailCommandeResponse;
import org.example.tpcafeachraf_benmouelli.services.detail_commande.IDetail_commandeSerivce;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detailcommande")
@AllArgsConstructor
public class Detail_CommandeRestController {

    private final IDetail_commandeSerivce detailCommandeService;

    // 🔹 Récupérer tous les détails de commande
    @GetMapping
    public List<DetailCommandeResponse> displayAllDetails() {
        return detailCommandeService.selectAllDetailCommandes();
    }

    // 🔹 Ajouter un détail de commande
    @PostMapping
    public DetailCommandeResponse addDetail(@RequestBody DetailCommandeRequest dto) {
        return detailCommandeService.addDetailCommande(dto);
    }

    // 🔹 Ajouter plusieurs détails de commande
    @PostMapping("/addalldetails")
    public List<DetailCommandeResponse> addAllDetails(@RequestBody List<DetailCommandeRequest> dtos) {
        return detailCommandeService.saveDetailCommandes(dtos);
    }

    // 🔹 Récupérer un détail de commande par ID
    @GetMapping("/displaydetailbyId/{id}")
    public DetailCommandeResponse displayDetailById(@PathVariable long id) {
        return detailCommandeService.selectDetailCommande(id);
    }

    // 🔹 Supprimer un détail de commande par ID
    @DeleteMapping("/deletedetailbyId/{id}")
    public void deleteDetailById(@PathVariable long id) {
        detailCommandeService.deleteDetailCommandeById(id);
    }

    // 🔹 Supprimer tous les détails de commande
    @DeleteMapping("/deletealldetails")
    public void deleteAllDetails() {
        detailCommandeService.deleteAllDetailCommandes();
    }

    // 🔹 Compter tous les détails de commande
    @GetMapping("/countingdetails")
    public long countAllDetails() {
        return detailCommandeService.countingDetailCommandes();
    }

    // 🔹 Vérifier si un détail de commande existe
    @GetMapping("/existdetail/{id}")
    public boolean existDetail(@PathVariable long id) {
        return detailCommandeService.verifyDetailCommande(id);
    }
}
