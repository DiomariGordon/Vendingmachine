package com.techelevator;

public abstract class Item {
    private String itemNumber;
    private String itemName;
    private String itemType;
    private double itemCost;


    public Item(String itemNumber, String itemName, double itemCost, String itemType){
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemCost = itemCost;
    }

    public double getItemCost() {
        return this.itemCost;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemNumber() {
        return this.itemNumber;
    }

    public String getItemType() {
        return this.itemType;
    }

    public abstract String vend();

//    public String vend() {
//
//    }

}
