package org.example.tpcafeachraf_benmouelli.services.detail_commande;

import org.example.tpcafeachraf_benmouelli.dto.datailscommande.DetailCommandeRequest;
import org.example.tpcafeachraf_benmouelli.dto.datailscommande.DetailCommandeResponse;

import java.util.List;

public interface IDetail_commandeSerivce {

    // ✅ Nouvelles méthodes utilisant DTOs
    DetailCommandeResponse addDetailCommande(DetailCommandeRequest dto);
    List<DetailCommandeResponse> saveDetailCommandes(List<DetailCommandeRequest> dtos);
    DetailCommandeResponse selectDetailCommande(long id);
    List<DetailCommandeResponse> selectAllDetailCommandes();
    void deleteDetailCommandeById(long id);
    void deleteAllDetailCommandes();
    long countingDetailCommandes();
    boolean verifyDetailCommande(long id);

    // ─────────────── Anciennes méthodes conservées ───────────────
    /*
    Detail_Commande addDetail_commande(Detail_Commande dc);
    List<Detail_Commande> saveDetail_commande(List<Detail_Commande> detailCommandes);
    Detail_Commande selectDetail_commande(long id);
    List<Detail_Commande> selectDetail_commandes();
    List<Detail_Commande> selectDetail_commandes(List<Detail_Commande> detailCommandes );
    void deleteDetail_commandeById(long id);
    void deleteDetail_commandes(Detail_Commande dc);
    void deleteAllDetail_commandes();
    long countingDetail_commandes();
    boolean verifyDetail_commande(long id);
    */
}
