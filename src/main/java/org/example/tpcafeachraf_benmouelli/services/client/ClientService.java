package org.example.tpcafeachraf_benmouelli.services.client;

import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.client.ClientRequest;
import org.example.tpcafeachraf_benmouelli.dto.client.ClientResponse;
import org.example.tpcafeachraf_benmouelli.entities.Client;
import org.example.tpcafeachraf_benmouelli.mappers.client.ClientMapper;
import org.example.tpcafeachraf_benmouelli.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {

    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    // ─────────────── Nouvelles méthodes avec DTOs ───────────────
    @Override
    public ClientResponse addClient(ClientRequest clientRequest) {
        Client client = clientMapper.toEntity(clientRequest);
        Client savedClient = clientRepository.save(client);
        return clientMapper.toDto(savedClient);
    }

    @Override
    public List<ClientResponse> saveClients(List<ClientRequest> clientRequests) {
        List<Client> clients = clientRequests.stream()
                .map(clientMapper::toEntity)
                .collect(Collectors.toList());
        List<Client> savedClients = clientRepository.saveAll(clients);
        return savedClients.stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponse selectClient(long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<ClientResponse> selectAllClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteClientById(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void deleteAllClients() {
        clientRepository.deleteAll();
    }

    @Override
    public long countingClients() {
        return clientRepository.count();
    }

    @Override
    public boolean verifyClient(long id) {
        return clientRepository.existsById(id);
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
}
