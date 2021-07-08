package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DrinkTest {
    @Test
    public void vend_checkStatementForDrink(){
        //itemNumber, itemName, itemCost, itemType
        //C3|Mountain Melter|1.50|Drink
        Drink drink = new Drink("C3","Mountain Melter",1.50,"Drink");
        String result = drink.vend();
        String expected = "Glug Glug, Yum!";

        Assert.assertEquals(result, expected);
    }
}
