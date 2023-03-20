package com.example.Bank.client;


public class Client {

    private int clientId;
    private String name;
    private int balance;
    private int account;

    public Client() {

    }
    public Client(String name,
                  int balance,
                  int account) {
        this.name = name;
        this.balance = balance;
        this.account = account;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", account=" + account +
                '}';
    }

    public void withdraw(int amount) {
        this.balance=this.balance-amount;
    }
    public void deposit(int amount) {
        this.balance=this.balance+amount;
    }
}
