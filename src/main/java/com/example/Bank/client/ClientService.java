package com.example.Bank.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService extends Thread{
    private ClientDatabase clientDatabase;

    public ClientService() {
    }

    public void setDatabase(ClientDatabase clientDatabase) {
        this.clientDatabase = clientDatabase;
    }
    public List<Client> getClients(){
        while (clientDatabase.isInUse()) {}
        return clientDatabase.getClientList();
    }
    public void addClient(Client client){
        while (clientDatabase.isInUse()) {}
        clientDatabase.addClient(client);
    }
    public void removeClient(int clientId){
        while (clientDatabase.isInUse()) {}
        clientDatabase.removeClient(clientId);
    }
    public int getbalance(int clientId){
        while (clientDatabase.isInUse()) {}
        return clientDatabase.getBalance(clientId);
    }
    public void deposit(int clientId, int amount){
        while (clientDatabase.isInUse()) {}
        clientDatabase.depositClient(clientId, amount);
    }
    public void withdraw(int clientId, int amount){
        while (clientDatabase.isInUse()) {}
        clientDatabase.withdrawClient(clientId, amount);
    }
    public void transfer(int clientId1,int clientId2, int amount){
        while (clientDatabase.isInUse()) {}
        clientDatabase.transfer(clientId1, clientId2, amount);
    }
}
