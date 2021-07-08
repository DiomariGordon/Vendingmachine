package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CandyTest {
    @Test
    public void vend_checkStatementForCandy(){
        //itemNumber, itemName, itemCost, itemType
        //B3|Wonka Bar|1.50|Candy
        Candy candy = new Candy("B3","Wonka Bar",1.50,"Candy");
        String result = candy.vend();
        String expected = "Munch Munch, Yum!";

        Assert.assertEquals(result, expected);
    }
}
