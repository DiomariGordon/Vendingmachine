package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class VendingMachineTests {
    VendingMachine vendingMachine = new VendingMachine();
    @Test
    public void purchaseItem_checkNull () {
        String result = vendingMachine.purchaseItem(new BigDecimal("10.00"), null);

        Assert.assertNotNull(result);
    }

    @Test
    public void getChange_checkChange() {
        String result = vendingMachine.getChange(new BigDecimal("6.95"));
        String expected = System.lineSeparator() + "Quarters: 27" + System.lineSeparator() + "Dimes: 2"
        + System.lineSeparator() + "Nickels: 0";
        Assert.assertEquals(result, expected);
    }

    @Test
    public void isDouble_checkIfInputIsDouble() {
        boolean expected = vendingMachine.isDouble("3.05");

        Assert.assertTrue(expected);
    }

    @Test
    public void getBalance_checkBalance() {
        vendingMachine.feedMoney(new BigDecimal("10.00"));
        BigDecimal result = new BigDecimal(String.valueOf(VendingMachine.getBalance()));
        BigDecimal expected = new BigDecimal("10.00");

        Assert.assertEquals(result, expected);
    }

    @Test
    public void feedMoney_checkMoneyFed() {
        vendingMachine.feedMoney(new BigDecimal("10.00"));
        BigDecimal result = new BigDecimal(String.valueOf(VendingMachine.getBalance()));
        BigDecimal expected = new BigDecimal("10.00");

        Assert.assertEquals(result, expected);
    }
}
