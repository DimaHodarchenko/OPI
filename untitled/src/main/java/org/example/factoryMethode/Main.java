package org.example.factoryMethode;

interface Auction {
    void startAuction();
}

class ProductAuction implements Auction {
    @Override
    public void startAuction() {
        System.out.println("Стартує аукціон для продажу товарів");
    }
}

class ArtAuction implements Auction {
    @Override
    public void startAuction() {
        System.out.println("Стартує аукціон для продажу картин");
    }
}

interface AuctionFactory {
    Auction createAuction();
}

class ProductAuctionFactory implements AuctionFactory {
    @Override
    public Auction createAuction() {
        return new ProductAuction();
    }
}

class ArtAuctionFactory implements AuctionFactory {
    @Override
    public Auction createAuction() {
        return new ArtAuction();
    }
}

public class Main {
    public static void main(String[] args) {
        AuctionFactory productAuctionFactory = new ProductAuctionFactory();
        Auction productAuction = productAuctionFactory.createAuction();
        productAuction.startAuction();

        AuctionFactory artAuctionFactory = new ArtAuctionFactory();
        Auction artAuction = artAuctionFactory.createAuction();
        artAuction.startAuction();
    }
}
