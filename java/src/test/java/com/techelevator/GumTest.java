package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class GumTest {
    @Test
    public void vend_checkStatementForGum(){
        //itemNumber, itemName, itemCost, itemType
        //D1|U-Chews|0.85|Gum
        Gum gum = new Gum("D1","U-Chews",0.85,"Gum");
        String result = gum.vend();
        String expected = "Chew Chew, Yum!";

        Assert.assertEquals(result, expected);
    }
}
