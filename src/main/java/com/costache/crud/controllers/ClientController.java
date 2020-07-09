package com.costache.crud.controllers;

import com.costache.crud.entities.Client;
import com.costache.crud.entities.Product;
import com.costache.crud.services.ClientService;
import com.costache.crud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ClientController {

    @Autowired private ClientService clientService;


    /**
     * List all client.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("clients", clientService.listAllClients());
        return "clients";
    }


    @RequestMapping("clients/{id}")
    public String showClient(@PathVariable Integer id, Model model) {
        model.addAttribute("client", clientService.getClientById(id));
        return "clientshow";
    }
    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("clients/new")
    public String newProduct(Model model) {
        model.addAttribute("client", new Client());
        return "clientform";
    }

    /**
     * Save product to database.
     *
     * @param client
     * @return
     */
    @RequestMapping(value = "clients", method = RequestMethod.POST)
    public String saveClient(Client client) {
        clientService.saveClient(client);
        return "redirect:/clients/" + client.getId();
    }

}
