package com.costache.crud.services;

import com.costache.crud.entities.Client;

public interface ClientService {

    Iterable<Client> listAllClients();

    Client getClientById(Integer id);

    Client saveClient(Client client);

    void deleteClient(Integer id);

}
