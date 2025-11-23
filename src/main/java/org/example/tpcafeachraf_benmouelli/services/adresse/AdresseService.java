package org.example.tpcafeachraf_benmouelli.services.adresse;

import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.adresse.AdresseRequest;
import org.example.tpcafeachraf_benmouelli.dto.adresse.AdresseResponse;
import org.example.tpcafeachraf_benmouelli.entities.Adresse;
import org.example.tpcafeachraf_benmouelli.entities.Client;
import org.example.tpcafeachraf_benmouelli.mappers.adresse.AdresseMapper;
import org.example.tpcafeachraf_benmouelli.repositories.AdresseRepository;
import org.example.tpcafeachraf_benmouelli.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdresseService implements IAdresseService {

    private  AdresseRepository adresseRepository;
    private ClientRepository clientRepository;
    private  AdresseMapper adresseMapper;

    /* @Override
    public Adresse addAdresse(Adresse ad) {
        return adresseRepository.save(ad);
    } */
    ////////////////////////////////////////////////////////
    // Nouvelle version avec DTO
    @Override
    public AdresseResponse addAdresse(AdresseRequest request) {
        Adresse adresse = adresseMapper.toEntity(request);
        Adresse saved = adresseRepository.save(adresse);
        return adresseMapper.toDto(saved);
    }
    ////////////////////////////////////////////////////////
    /* @Override
    public List<Adresse> saveAdresses(List<Adresse> adresses) {
        return adresseRepository.saveAll(adresses);
    } */
    ////////////////////////////////////////////////////////
    //  Nouvelle version avec DTO
    @Override
    public List<AdresseResponse> saveAdresses(List<AdresseRequest> adressesRequest) {
        List<Adresse> adresses = adressesRequest.stream()
                .map(adresseMapper::toEntity)
                .collect(Collectors.toList());
        List<Adresse> saved = adresseRepository.saveAll(adresses);
        return saved.stream().map(adresseMapper::toDto).collect(Collectors.toList());
    }
    ////////////////////////////////////////////////////////

    /* @Override
    public Adresse selectAdresseById(long id) {
        return adresseRepository.findById(id).get();
    } */
    ////////////////////////////////////////////////////////
    //  Nouvelle version avec DTO
    @Override
    public AdresseResponse selectAdresseById(long id) {
        Adresse adresse = adresseRepository.findById(id).orElse(null);
        return (adresse != null) ? adresseMapper.toDto(adresse) : null;
    }
    ////////////////////////////////////////////////////////

    /* @Override
    public List<Adresse> selectAllAdresses(List<Adresse> adresses) {
        return adresseRepository.findAll();
    } */
    ////////////////////////////////////////////////////////
    //  Nouvelle version avec DTO
    @Override
    public List<AdresseResponse> selectAllAdresses() {
        return adresseRepository.findAll()
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }
    ////////////////////////////////////////////////////////

    /* @Override
    public void deleteAdresse(Adresse ad) {
        adresseRepository.delete(ad);
    } */
    ////////////////////////////////////////////////////////
    //  Nouvelle version simplifiée
    @Override
    public void deleteAdresseById(long id) {
        adresseRepository.deleteById(id);
    }
    ////////////////////////////////////////////////////////

    /* @Override
    public void deleteAllAdresses() {
        adresseRepository.deleteAll();
    } */
    ////////////////////////////////////////////////////////
    @Override
    public void deleteAllAdresses() {
        adresseRepository.deleteAll();
    }
    ////////////////////////////////////////////////////////

    @Override
    public long countingAdresses() {
        return adresseRepository.count();
    }

    @Override
    public boolean verifAdresse(long id) {
        return adresseRepository.existsById(id);
    }



    //les affectations simples//
    @Override
    public String affecterAdresseAClient(String rue, long cin) {
        Adresse adresse = adresseRepository.findByRue(rue);
        Client client = clientRepository.findByCin(cin);
        client.setAdresse(adresse);
        clientRepository.save(client);
        return "Adresse affectée avec succès au client " + client.getNom();
    }
    ////////////////////////////
}
