package com.example.Bank.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="api/v1/client")
public class ClientController {
    private final ClientDatabase clientDatabase = new ClientDatabase();

    @Autowired
    public ClientController() {
    }

    @GetMapping
    public List<Client> getClients(){
        ClientService clientService = new ClientService();
        clientService.setDatabase(this.clientDatabase);
        return clientService.getClients();
    }

    @PostMapping
    public void addClient(@RequestBody Client client){
        ClientService clientService = new ClientService();
        clientService.setDatabase(this.clientDatabase);
        clientService.addClient(client);
    }

    @DeleteMapping(path= "{clientId}")
    public void removeClient(@PathVariable("clientId") int clientId){
        ClientService clientService = new ClientService();
        clientService.setDatabase(this.clientDatabase);
        clientService.removeClient(clientId);
    }

    @GetMapping(path= "{clientId}/balance")
    public void getBalance(@PathVariable("clientId") int clientId){
        ClientService clientService = new ClientService();
        clientService.setDatabase(this.clientDatabase);
        clientService.getbalance(clientId);
    }

    @PutMapping(path= "{clientId}/deposit/{amount}")
    public void deposit(@PathVariable("clientId") int clientId, @PathVariable("amount") int amount){
        ClientService clientService = new ClientService();
        clientService.setDatabase(this.clientDatabase);
        clientService.deposit(clientId, amount);
    }

    @PutMapping(path= "{clientId}/withdraw/{amount}")
    public void withdraw(@PathVariable("clientId") int clientId, @PathVariable("amount") int amount){
        ClientService clientService = new ClientService();
        clientService.setDatabase(this.clientDatabase);
        clientService.withdraw(clientId, amount);
    }

    @PutMapping(path= "{clientId1}/{clientId2}/transfer/{amount}")
    public void transfer(@PathVariable("clientId1") int clientId1, @PathVariable("clientId2") int clientId2, @PathVariable("amount") int amount){
        ClientService clientService = new ClientService();
        clientService.setDatabase(this.clientDatabase);
        clientService.transfer(clientId1, clientId2,amount);
    }
}
