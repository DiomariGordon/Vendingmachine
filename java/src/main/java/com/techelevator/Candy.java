package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item {
    @Override
    public String vend() {
        return "Munch Munch, Yum!";
    }

    public Candy(String itemNumber, String itemName, double itemCost, String itemType){
        super(itemNumber, itemName, itemCost, itemType);

    }
}
