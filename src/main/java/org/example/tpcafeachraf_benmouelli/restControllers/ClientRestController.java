package org.example.tpcafeachraf_benmouelli.restControllers;

import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.client.ClientRequest;
import org.example.tpcafeachraf_benmouelli.dto.client.ClientResponse;
import org.example.tpcafeachraf_benmouelli.entities.Client;
import org.example.tpcafeachraf_benmouelli.services.client.IClientService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientRestController {

    private final IClientService clientService;

    // ─────────────── Nouvelles méthodes avec DTOs ───────────────

    @GetMapping
    public List<ClientResponse> displayAllClients() {
        return clientService.selectAllClients();
    }

    @PostMapping
    public ClientResponse addClient(@RequestBody ClientRequest clientRequest) {
        return clientService.addClient(clientRequest);
    }

    @PostMapping("/addallclients")
    public List<ClientResponse> addAllClients(@RequestBody List<ClientRequest> clientRequests) {
        return clientService.saveClients(clientRequests);
    }

    @GetMapping("/displayclientbyid/{id}")
    public ClientResponse displayClientById(@PathVariable long id) {
        return clientService.selectClient(id);
    }

    @DeleteMapping("/deleteclientbyid/{id}")
    public void deleteClientById(@PathVariable long id) {
        clientService.deleteClientById(id);
    }

    @DeleteMapping("/deleteallclients")
    public void deleteAllClients() {
        clientService.deleteAllClients();
    }

    @GetMapping("/countclients")
    public long countClients() {
        return clientService.countingClients();
    }

    @GetMapping("/existclient/{id}")
    public boolean existClient(@PathVariable long id) {
        return clientService.verifyClient(id);
    }

    /*les methodes des affectation simples*/
    //////////////////////////////////////////////////////
    @PostMapping("/{idClient}/carte/{idCarte}")
    public void affecterCarteAClient(@PathVariable long idClient, @PathVariable long idCarte) {
        clientService.affecterCarteAClient(idCarte, idClient);
    }

    //////////////////////////////////////////////////////
    @PostMapping("/{idClient}/commande/{idCommande}")
    public void affecterCommandeAClient(@PathVariable long idClient, @PathVariable long idCommande) {
        clientService.affecterCommandeAClient(idCommande, idClient);
    }

    ////////////////////////////////////////////////////////
    @PostMapping("/commande/assign")
    public void affecterCommandeAClient(@RequestParam String nomClient,
                                        @RequestParam String prenomClient,
                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateCommande) {
        clientService.affecterCommandeAClient(dateCommande, nomClient, prenomClient);
    }

    ////////////////////////////////////////////////////////
    @PostMapping("/add")
    public Client ajouterClientEtCarteFidelite(@RequestBody Client client) {
        return clientService.ajouterClientEtCarteFidelite(client);
    }

}
