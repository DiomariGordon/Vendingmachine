package com.techelevator;

public class Chip extends Item{
    public Chip(String itemNumber, String itemName, double itemCost, String itemType){
        super(itemNumber, itemName, itemCost, itemType);
    }

    @Override
    public String vend() {
        return "Crunch Crunch, Yum!";
    }
}
