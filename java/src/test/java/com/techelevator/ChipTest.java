package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ChipTest {
    @Test
    public void vend_checkStatementForChip(){
//        itemNumber, itemName, itemCost, itemType
        Chip chip = new Chip("A1","Potato Crisps",3.05,"Chip");
        String result = chip.vend();
        String expected = "Crunch Crunch, Yum!";

        Assert.assertEquals(result, expected);
    }
}
