package org.example.tpcafeachraf_benmouelli.services.commande;

import org.example.tpcafeachraf_benmouelli.dto.commande.CommandeRequest;
import org.example.tpcafeachraf_benmouelli.dto.commande.CommandeResponse;

import java.util.List;

public interface ICommandeService {

    // ─────────────── Nouvelles méthodes avec DTOs ───────────────
    CommandeResponse addCommande(CommandeRequest commandeRequest);
    List<CommandeResponse> saveCommandes(List<CommandeRequest> commandeRequests);
    CommandeResponse selectCommandeById(long id);
    List<CommandeResponse> selectAllCommandes();
    void deleteCommandeById(long id);
    void deleteAllCommandes();
    long countingCommandes();
    boolean verifCommande(long id);

    // ─────────────── Anciennes méthodes conservées ───────────────
    /*
    Commande addCommande(Commande commande);
    List<Commande> saveCommandes(List<Commande> commandes);
    Commande selectCommandeById(long id);
    List<Commande> selectAllCommandes();
    List<Commande> selectAllCommandes(List<Commande> commandes);
    void deleteCommande(Commande commande);
    void deleteAllCommandes();
    void deleteCommandeById(long id);
    long countingCommandes();
    boolean verifCommande(long id);
    */
}
