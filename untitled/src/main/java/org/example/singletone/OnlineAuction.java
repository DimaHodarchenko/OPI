package org.example.singletone;

public class OnlineAuction {
    private static OnlineAuction instance;

    private OnlineAuction() {

    }

    public static OnlineAuction getInstance() {
        if (instance == null) {
            instance = new OnlineAuction();
        }
        return instance;
    }
}

