package org.example.singletone;

public class Main {
    public static void main(String[] args) {
        OnlineAuction onlineAuction = OnlineAuction.getInstance();
        OnlineAuction onlineAuction1 =  OnlineAuction.getInstance();

        System.out.println(onlineAuction1.equals(onlineAuction)); //true
        System.out.println(onlineAuction1 == onlineAuction); //true
    }
}
