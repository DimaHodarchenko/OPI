package org.example.prototype;

class AuctionItem implements Cloneable {
    private String itemName;
    private double currentBid;

    public AuctionItem(String itemName, double currentBid) {
        this.itemName = itemName;
        this.currentBid = currentBid;
    }

    public String getItemName() {
        return itemName;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    public AuctionItem clone() throws CloneNotSupportedException {
        return (AuctionItem) super.clone();
    }
}

public class Main {
    public static void main(String[] args) {
        AuctionItem prototypeItem = new AuctionItem("Painting", 100.0);

        try {
            AuctionItem clonedItem = prototypeItem.clone();

            clonedItem.setCurrentBid(150.0);

            System.out.println("Original Item: " + prototypeItem.getItemName() + " - Current Bid: " + prototypeItem.getCurrentBid());
            System.out.println("Cloned Item: " + clonedItem.getItemName() + " - Current Bid: " + clonedItem.getCurrentBid());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

