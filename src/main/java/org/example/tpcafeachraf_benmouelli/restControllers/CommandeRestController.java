package org.example.tpcafeachraf_benmouelli.restControllers;

import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.commande.CommandeRequest;
import org.example.tpcafeachraf_benmouelli.dto.commande.CommandeResponse;
import org.example.tpcafeachraf_benmouelli.services.commande.ICommandeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")
@AllArgsConstructor
public class CommandeRestController {

    private final ICommandeService commandeService;

    // ─────────────── Afficher toutes les commandes ───────────────
    @GetMapping
    public List<CommandeResponse> displayAllCommandes() {
        return commandeService.selectAllCommandes();
    }

    // ─────────────── Ajouter une commande ───────────────
    @PostMapping
    public CommandeResponse addCommande(@RequestBody CommandeRequest dto) {
        return commandeService.addCommande(dto);
    }

    // ─────────────── Ajouter plusieurs commandes ───────────────
    @PostMapping("/addallcommandes")
    public List<CommandeResponse> addAllCommandes(@RequestBody List<CommandeRequest> dtos) {
        return commandeService.saveCommandes(dtos);
    }

    // ─────────────── Afficher une commande par ID ───────────────
    @GetMapping("/displaycommandebyId/{id}")
    public CommandeResponse displayCommandeById(@PathVariable long id) {
        return commandeService.selectCommandeById(id);
    }

    // ─────────────── Supprimer une commande par ID ───────────────
    @DeleteMapping("/deletecommandebyId/{id}")
    public void deleteCommandeById(@PathVariable long id) {
        commandeService.deleteCommandeById(id);
    }

    // ─────────────── Supprimer toutes les commandes ───────────────
    @DeleteMapping("/deleteallcommandes")
    public void deleteAllCommandes() {
        commandeService.deleteAllCommandes();
    }

    // ─────────────── Compter les commandes ───────────────
    @GetMapping("/countingcommandes")
    public long countAllCommandes() {
        return commandeService.countingCommandes();
    }

    // ─────────────── Vérifier l’existence d’une commande ───────────────
    @GetMapping("/existcommande/{id}")
    public boolean existCommande(@PathVariable long id) {
        return commandeService.verifCommande(id);
    }


    /*les methodes simpels*/
    @PostMapping("/{idCommande}/desaffecter-client")
    public void desaffecterClientDeCommande(@PathVariable long idCommande) {
        commandeService.desaffecterClientDeCommande(idCommande);
    }
    //////////////////////////////////////





    /*
    // Anciennes méthodes utilisant l’entité Commande
    @GetMapping
    public List<Commande> displayallCommandes() { ... }

    @PostMapping
    public Commande addcommande(@RequestBody Commande commande) { ... }

    @PostMapping("/addallcommandes")
    public List<Commande> addallcommandes(@RequestBody List<Commande> commandes) { ... }

    @GetMapping("/displaycommandebyId/{id}")
    public Commande displaycommandebyId(@PathVariable long id) { ... }

    @DeleteMapping("/deletecommandebyId/{id}")
    public void deletecommandebyId(@PathVariable long id) { ... }
    */
}
