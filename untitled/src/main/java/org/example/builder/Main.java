package org.example.builder;

class AuctionItem {
    private String itemName;
    private String itemDescription;
    private double startingPrice;
    private String sellerUsername;

    public AuctionItem(String itemName, String itemDescription, double startingPrice, String sellerUsername) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.startingPrice = startingPrice;
        this.sellerUsername = sellerUsername;
    }

    @Override
    public String toString() {
        return "AuctionItem{" +
                "itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", startingPrice=" + startingPrice +
                ", sellerUsername='" + sellerUsername + '\'' +
                '}';
    }
}

interface AuctionItemBuilder {
    AuctionItemBuilder itemName(String itemName);

    AuctionItemBuilder itemDescription(String itemDescription);

    AuctionItemBuilder startingPrice(double startingPrice);

    AuctionItemBuilder sellerUsername(String sellerUsername);

    AuctionItem build();
}

class AuctionItemBuilderImpl implements AuctionItemBuilder {
    private String itemName;
    private String itemDescription;
    private double startingPrice;
    private String sellerUsername;

    @Override
    public AuctionItemBuilder itemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    @Override
    public AuctionItemBuilder itemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
        return this;
    }

    @Override
    public AuctionItemBuilder startingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
        return this;
    }

    @Override
    public AuctionItemBuilder sellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
        return this;
    }

    @Override
    public AuctionItem build() {
        return new AuctionItem(itemName, itemDescription, startingPrice, sellerUsername);
    }
}

class AuctionItemDirector {
    private AuctionItemBuilder builder;

    public AuctionItemDirector(AuctionItemBuilder builder) {
        this.builder = builder;
    }

    public AuctionItem construct() {
        return builder.itemName("Default Item")
                .itemDescription("Default Description")
                .startingPrice(0.0)
                .sellerUsername("Default Seller")
                .build();
    }
}


public class Main {
    public static void main(String[] args) {
        AuctionItemBuilder builder = new AuctionItemBuilderImpl();
        AuctionItemDirector director = new AuctionItemDirector(builder);

        // Створення лоту зі стандартними значеннями
        AuctionItem defaultItem = director.construct();
        System.out.println(defaultItem);

        // Створення лоту зі спеціальними значеннями
        AuctionItem customItem = builder.itemName("Custom Item")
                .itemDescription("Special Description")
                .startingPrice(100.0)
                .sellerUsername("Special Seller")
                .build();
        System.out.println(customItem);
    }
}
