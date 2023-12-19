package org.example.adapter;

interface AuctionSystem {
    void placeBid(String bidder, double amount);
    void closeAuction();
}

class OnlineAuctionSystem implements AuctionSystem {


    @Override
    public void placeBid(String bidder, double amount) {
        System.out.println(bidder + " placed a bid of $" + amount);
    }

    @Override
    public void closeAuction() {
        System.out.println("Auction closed. Winning bidder is...");
    }
}

class ExternalAuctionService {
    void makeOffer(String user, double offerAmount) {
        System.out.println("User " + user + " Offer " + offerAmount);
    }

    void endAuction() {
        System.out.println("Auction closed");
    }
}

class AuctionSystemAdapter implements AuctionSystem {
    private ExternalAuctionService externalAuctionService;

    public AuctionSystemAdapter(ExternalAuctionService externalAuctionService) {
        this.externalAuctionService = externalAuctionService;
    }

    @Override
    public void placeBid(String bidder, double amount) {
        externalAuctionService.makeOffer(bidder, amount);
    }

    @Override
    public void closeAuction() {
        externalAuctionService.endAuction();
    }
}

public class Main {
    public static void main(String[] args) {
        OnlineAuctionSystem auctionSystem = new OnlineAuctionSystem();
        ExternalAuctionService externalAuctionService = new ExternalAuctionService();

        AuctionSystem adapter = new AuctionSystemAdapter(externalAuctionService);

        adapter.placeBid("User123", 50.0);

        adapter.closeAuction();
    }
}
