package com.example.blockchainnewyearmlh;

public class BlockInfo {
    private String sender;
    private String receiver;
    private int amount;

    public BlockInfo(String s, String r, int a) {
        this.sender = s;
        this.receiver = r;
        this.amount = a;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public int getAmount() {
        return amount;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSender() {
        return sender;
    }
}
