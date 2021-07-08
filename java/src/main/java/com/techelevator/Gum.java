package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item{
    @Override
    public String vend() {
        return "Chew Chew, Yum!";
    }

    public Gum(String itemNumber, String itemName, double itemCost, String itemType){
        super(itemNumber, itemName, itemCost, itemType);

    }
}
