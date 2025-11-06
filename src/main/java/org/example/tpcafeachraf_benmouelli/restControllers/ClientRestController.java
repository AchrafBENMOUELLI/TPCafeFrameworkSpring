package org.example.tpcafeachraf_benmouelli.restControllers;

import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.client.ClientRequest;
import org.example.tpcafeachraf_benmouelli.dto.client.ClientResponse;
import org.example.tpcafeachraf_benmouelli.services.client.IClientService;
import org.springframework.web.bind.annotation.*;

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

    // ─────────────── Anciennes méthodes conservées en commentaire ───────────────
    /*
    @GetMapping
    public List<Client> displayallclients() {
        return clientService.selectAllClients();
    }

    @PostMapping
    public Client addclient(@RequestBody Client client) {
        return clientService.addclient(client);
    }

    @PostMapping("/addallclient")
    public List<Client> addallclient(@RequestBody List<Client> clients) {
        return clientService.saveClients(clients);
    }

    @GetMapping("/displayclientbyId/{id}")
    public Client displayclientbyId(@PathVariable long id) {
        return clientService.selectClient(id);
    }

    @DeleteMapping("/deleteclientbyId/{id}")
    public void deleteclientbyId(@PathVariable long id) {
        clientService.deleteClientById(id);
    }

    @DeleteMapping("/deleteclients")
    public void deleteallclients(@RequestBody List<Client> clients ) {
        clientService.deleteAllClients();
    }

    @GetMapping("/countallclient")
    public long countallclient() {
        return clientService.countingClients();
    }

    @GetMapping("/existclient/{id}")
    public boolean existclient(@PathVariable long id) {
        return clientService.verifyClient(id);
    }
    */
}
