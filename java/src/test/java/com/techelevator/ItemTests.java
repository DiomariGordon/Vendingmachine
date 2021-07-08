package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ItemTests {
    Chip chip = new Chip("A1", "Potato Crisps", 3.05, "Chip");
    @Test
    public void getItemCost_checkCost() {
        double result = chip.getItemCost();
        double expected = 3.05;

        Assert.assertEquals(result, expected, 0);
    }

    @Test
    public void getItemName_checkName() {
        String result = chip.getItemName();
        String expected = "Potato Crisps";

        Assert.assertEquals(result, expected);
    }

    @Test
    public void getItemNumber_checkNumber() {
        String result = chip.getItemNumber();
        String expected = "A1";

        Assert.assertEquals(result, expected);
    }

    @Test
    public void getItemType_checkType() {
        String result = chip.getItemType();
        String expected = "Chip";

        Assert.assertEquals(result, expected);
    }
}
