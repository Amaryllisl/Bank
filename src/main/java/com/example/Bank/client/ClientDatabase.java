package com.example.Bank.client;

import java.util.Vector;

public class ClientDatabase {

    private Boolean inUse=false;

    private Vector<Client> clientList = new Vector();
    private int clientCount = 0;

    public ClientDatabase() {
        this.test();
    }

    public void test() {
        this.addClient(new Client("Amaryllis", 1000,3456));
        this.addClient(new Client("Orin", 1000,7890));
        this.addClient(new Client("Kobe", 1000,1230));
    }

    public Vector<Client> getClientList() {
        return clientList;
    }

    public void addClient(Client client) {
        this.inUse = true;
        client.setClientId(clientCount);
        clientCount++;
        clientList.add(client);
        System.out.println("Client added...");
        this.inUse = false;
    }

    public void removeClient(int clientId ) {
        this.inUse = true;
        for (int i=0; i < clientList.size(); i++) {
            if (clientList.elementAt(i).getClientId() == clientId) {
                clientList.removeElementAt(i);
                System.out.println("Client deleted...");
            }
        }
        this.inUse = false;
    }

    public int getBalance(int clientId) {
        int balance=0;
        for (int i=0; i < clientList.size(); i++) {
            if (clientList.elementAt(i).getClientId() == clientId) {
                balance = clientList.elementAt(i).getBalance();
            }
        }
        return balance;
    }

    public void depositClient(int clientId, int amount ) {
        this.inUse = true;
        for (int i=0; i < clientList.size(); i++) {
            if (clientList.elementAt(i).getClientId() == clientId) {
                clientList.elementAt(i).deposit(amount);
            }
        }
        this.inUse = false;
    }

    public void withdrawClient(int clientId, int amount ) {
        this.inUse = true;
        for (int i=0; i < clientList.size(); i++) {
            if (clientList.elementAt(i).getClientId() == clientId) {
                clientList.elementAt(i).withdraw(amount);
            }
        }
        this.inUse = false;
    }

    public void transfer(int clientId1, int clientId2, int amount)
    {
        this.inUse = true;
        for (int i=0; i < clientList.size(); i++) {
            if (clientList.elementAt(i).getClientId() == clientId1) {
                clientList.elementAt(i).withdraw(amount);
            }
            if (clientList.elementAt(i).getClientId() == clientId2) {
                clientList.elementAt(i).deposit(amount);
            }
        }
        this.inUse = false;
    }

    public boolean isInUse() {
        return inUse;
    }
}
