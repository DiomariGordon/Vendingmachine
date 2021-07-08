package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Item {
    @Override
    public String vend() {
        return "Glug Glug, Yum!";
    }


    public Drink(String itemNumber, String itemName, double itemCost, String itemType){
        super(itemNumber, itemName, itemCost, itemType);

    }
}
