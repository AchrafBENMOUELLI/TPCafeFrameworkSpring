package org.example.tpcafeachraf_benmouelli.services.client;

import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.client.ClientRequest;
import org.example.tpcafeachraf_benmouelli.dto.client.ClientResponse;
import org.example.tpcafeachraf_benmouelli.entities.CarteFidelite;
import org.example.tpcafeachraf_benmouelli.entities.Client;
import org.example.tpcafeachraf_benmouelli.entities.Commande;
import org.example.tpcafeachraf_benmouelli.mappers.client.ClientMapper;
import org.example.tpcafeachraf_benmouelli.repositories.AdresseRepository;
import org.example.tpcafeachraf_benmouelli.repositories.CarteFideliteRepository;
import org.example.tpcafeachraf_benmouelli.repositories.ClientRepository;
import org.example.tpcafeachraf_benmouelli.repositories.CommandeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final AdresseRepository adresseRepository;
    private final CarteFideliteRepository carteFideliteRepository;
    private final CommandeRepository commandeRepository;

    // ───────────── Ajouter un client avec ses relations ─────────────
    @Override
    public ClientResponse addClient(ClientRequest clientRequest) {
        // Convertir le DTO en entity
        Client client = clientMapper.toEntity(clientRequest);

        // Lier l'adresse si elle existe
        if (clientRequest.getAdresseId() != null) {
            adresseRepository.findById(clientRequest.getAdresseId())
                    .ifPresent(client::setAdresse);
        }

        // Lier la carte fidélité si elle existe
        if (clientRequest.getCarteFideliteId() != null) {
            carteFideliteRepository.findById(clientRequest.getCarteFideliteId())
                    .ifPresent(carte -> {
                        client.setCarteFidelite(carte);
                        carte.setClient(client); // lien bidirectionnel
                    });
        }

        // Sauvegarder le client
        Client savedClient = clientRepository.save(client);

        // Retourner le DTO complet avec relations
        return clientMapper.toDto(savedClient);
    }

    // ───────────── Ajouter plusieurs clients ─────────────
    @Override
    public List<ClientResponse> saveClients(List<ClientRequest> clientRequests) {
        List<Client> clients = clientRequests.stream()
                .map(req -> {
                    Client c = clientMapper.toEntity(req);
                    if (req.getAdresseId() != null) {
                        adresseRepository.findById(req.getAdresseId()).ifPresent(c::setAdresse);
                    }
                    if (req.getCarteFideliteId() != null) {
                        carteFideliteRepository.findById(req.getCarteFideliteId())
                                .ifPresent(carte -> {
                                    c.setCarteFidelite(carte);
                                    carte.setClient(c);
                                });
                    }
                    return c;
                })
                .collect(Collectors.toList());

        List<Client> savedClients = clientRepository.saveAll(clients);
        return savedClients.stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    // ───────────── Sélectionner un client avec relations ─────────────
    @Override
    public ClientResponse selectClient(long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toDto) // mapper gère les relations
                .orElse(null);
    }

    // ───────────── Sélectionner tous les clients ─────────────
    @Override
    public List<ClientResponse> selectAllClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    // ───────────── Supprimer un client ─────────────
    @Override
    public void deleteClientById(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void deleteAllClients() {
        clientRepository.deleteAll();
    }

    // ───────────── Compter les clients ─────────────
    @Override
    public long countingClients() {
        return clientRepository.count();
    }

    // ───────────── Vérifier l’existence ─────────────
    @Override
    public boolean verifyClient(long id) {
        return clientRepository.existsById(id);
    }



//les affectations simples//
    @Override
    public void affecterCarteAClient(long idCarte, long idClient) {
        Client client = clientRepository.findById(idClient).get();
        CarteFidelite carteFidelite = carteFideliteRepository.findById(idCarte).get();
        client.setCarteFidelite(carteFidelite);
        clientRepository.save(client);
    }

    @Override
    public void affecterCommandeAClient(long idCommande, long idClient) {
        Client client = clientRepository.findById(idClient).get();
        Commande commande = commandeRepository.findById(idCommande).get();
        commande.setClient(client);
        commandeRepository.save(commande);
    }

    @Override
    public void affecterCommandeAClient(LocalDate dateCommande, String nomClient, String prenomClient) {
        Client client = clientRepository.findByNomAndPrenom(nomClient, prenomClient);
        Commande commande = commandeRepository.findByDateCommande(dateCommande);
        commande.setClient(client);
        commandeRepository.save(commande);
    }

    @Override
    public Client ajouterClientEtCarteFidelite(Client client) {
        Client savedClient = clientRepository.save(client);
        CarteFidelite carte = new CarteFidelite();
        carte.setClient(savedClient);
        savedClient.setCarteFidelite(carte);
        return clientRepository.save(savedClient);
    }

    ////////////////////////////////

////////////////////////////
}


// ─────────────── Anciennes méthodes conservées en commentaire ───────────────
    /*
    @Override
    public Client addclient(Client cl) {
        return clientRepository.save(cl);
    }

    @Override
    public List<Client> saveClients(List<Client> cl) {
        return clientRepository.saveAll(cl);
    }

    @Override
    public Client selectClient(long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> selectAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> selectAllClients(List<Client> clients) {
        return clientRepository.findAll();
    }

    @Override
    public void deleteClient(Client cl) {
        clientRepository.delete(cl);
    }

    @Override
    public void deleteAllClients() {
        clientRepository.deleteAll();
    }

    @Override
    public void deleteClientById(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public long countingClients() {
        return clientRepository.count();
    }

    @Override
    public boolean verifyClient(long id) {
        return clientRepository.existsById(id);
    }
    */

