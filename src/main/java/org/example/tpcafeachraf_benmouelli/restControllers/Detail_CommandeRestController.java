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


    @GetMapping
    public List<DetailCommandeResponse> displayAllDetails() {
        return detailCommandeService.selectAllDetailCommandes();
    }


    @PostMapping
    public DetailCommandeResponse addDetail(@RequestBody DetailCommandeRequest dto) {
        return detailCommandeService.addDetailCommande(dto);
    }


    @PostMapping("/addalldetails")
    public List<DetailCommandeResponse> addAllDetails(@RequestBody List<DetailCommandeRequest> dtos) {
        return detailCommandeService.saveDetailCommandes(dtos);
    }


    @GetMapping("/displaydetailbyId/{id}")
    public DetailCommandeResponse displayDetailById(@PathVariable long id) {
        return detailCommandeService.selectDetailCommande(id);
    }


    @DeleteMapping("/deletedetailbyId/{id}")
    public void deleteDetailById(@PathVariable long id) {
        detailCommandeService.deleteDetailCommandeById(id);
    }


    @DeleteMapping("/deletealldetails")
    public void deleteAllDetails() {
        detailCommandeService.deleteAllDetailCommandes();
    }


    @GetMapping("/countingdetails")
    public long countAllDetails() {
        return detailCommandeService.countingDetailCommandes();
    }


    @GetMapping("/existdetail/{id}")
    public boolean existDetail(@PathVariable long id) {
        return detailCommandeService.verifyDetailCommande(id);
    }
}
