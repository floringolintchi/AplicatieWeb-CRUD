package com.costache.crud.services;

import com.costache.crud.entities.Client;
import com.costache.crud.entities.Product;
import com.costache.crud.repositories.ClientRepository;
import com.costache.crud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired private ClientRepository clientRepository;

    @Override
    public Iterable<Client> listAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Integer id) {
        return clientRepository.findOne(id);
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepository.delete(id);
    }
}
