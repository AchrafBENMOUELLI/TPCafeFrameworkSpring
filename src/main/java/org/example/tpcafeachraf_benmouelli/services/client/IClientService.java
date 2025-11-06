package org.example.tpcafeachraf_benmouelli.services.client;

import org.example.tpcafeachraf_benmouelli.dto.client.ClientRequest;
import org.example.tpcafeachraf_benmouelli.dto.client.ClientResponse;

import java.util.List;

public interface IClientService {

    // Nouvelles méthodes utilisant DTOs
    ClientResponse addClient(ClientRequest clientRequest);
    List<ClientResponse> saveClients(List<ClientRequest> clientRequests);
    ClientResponse selectClient(long id);
    List<ClientResponse> selectAllClients();
    void deleteClientById(long id);
    void deleteAllClients();
    long countingClients();
    boolean verifyClient(long id);

    // ─────────────── Anciennes méthodes conservées ───────────────
    /*
    Client addclient(Client cl);
    List<Client> saveClients(List<Client> cl);
    Client selectClient(long id);
    List<Client> selectAllClients();
    List<Client> selectAllClients(List<Client> clients);
    void deleteClient(Client cl);
    void deleteAllClients();
    void deleteClientById(long id);
    long countingClients();
    boolean verifyClient(long id);
    */
}
