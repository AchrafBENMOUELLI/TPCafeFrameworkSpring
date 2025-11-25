package org.example.tpcafeachraf_benmouelli.services.adresse;

import org.example.tpcafeachraf_benmouelli.dto.adresse.AdresseRequest;
import org.example.tpcafeachraf_benmouelli.dto.adresse.AdresseResponse;
import org.example.tpcafeachraf_benmouelli.entities.Adresse;
import org.example.tpcafeachraf_benmouelli.entities.Client;

import java.util.List;

public interface IAdresseService {

    // ✅ Nouvelle version avec DTOs
    AdresseResponse addAdresse(AdresseRequest adresseRequest);
    List<AdresseResponse> saveAdresses(List<AdresseRequest> adressesRequest);
    AdresseResponse selectAdresseById(long id);
    List<AdresseResponse> selectAllAdresses();
    void deleteAdresseById(long id);
    void deleteAllAdresses();
    long countingAdresses();
    boolean verifAdresse(long id);

    //les affectation simples//
    String affecterAdresseAClient(String rue,long cin);

    void ajouterEtAffecterAdresseAClient(Adresse ad, Client c);
    ///////////////////////////








    /*
    Adresse addAdresse(Adresse ad);
    List<Adresse> saveAdresses(List<Adresse> adresses);
    Adresse selectAdresseById(long id);
    List<Adresse> selectAllAdresses(List<Adresse> adresses);
    List<Adresse> selectAllAdresses();
    void deleteAdresse(Adresse ad);
    void deleteAllAdresses();
    void deleteAdresseById(long id);
    long countingAdresses();
    boolean verifAdresse(long id);
    */
}
