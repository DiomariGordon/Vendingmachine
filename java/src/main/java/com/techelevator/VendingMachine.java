package com.techelevator;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;


public class VendingMachine {
    private static BigDecimal balance = new BigDecimal("0");
    private static final Map<String, Double> items = new HashMap<String, Double>();
    private static final Map<String, Integer> stock = new HashMap<String, Integer>();
    private static final Map<String, String> itemNames = new HashMap<String, String>();
    private static final Map<String, Item> allItems = new HashMap<String, Item>();
    private static final ArrayList<Item> itemList = new ArrayList<Item>();

    public static BigDecimal getBalance() {
        return balance;
    }

    public void displayItems() {
        try {
            File input = new File("vendingmachine.csv");
            Scanner scanInput = new Scanner(input);

            while(scanInput.hasNextLine()) {
                String line = scanInput.nextLine();
                String[] itemArray = line.split("\\|");
                System.out.println(System.lineSeparator());
                for(String item : itemArray) {
                    if(isDouble(item)) {
                        System.out.print("$" +  item + "\t");
                    } else {
                        System.out.print(item + "\t");
                    }
                }
            }
            System.out.println(System.lineSeparator());
            scanInput.close();
        } catch(FileNotFoundException fnfe) {
            System.out.println(String.format(" Error: %s", fnfe.getMessage()));
        }
    }

    public void feedMoney(BigDecimal moneyFed){
        balance = balance.add(moneyFed);

        Log log = new Log();
        log.writeLog("FEED MONEY", moneyFed, balance);
    }

    public void setStock() {
        try {
            File input = new File("vendingmachine.csv");
            Scanner scanInput = new Scanner(input);
            while(scanInput.hasNextLine()) {
                String line = scanInput.nextLine();
                String[] itemArray = line.split("\\|");
                if (itemArray[3].equals("Chip")){
                    allItems.put(itemArray[0], new Chip(itemArray[0], itemArray[1], Double.parseDouble(itemArray[2]), itemArray[3]));
                }else if (itemArray[3].equals("Drink")){
                    allItems.put(itemArray[0], new Drink(itemArray[0], itemArray[1], Double.parseDouble(itemArray[2]), itemArray[3]));
                }else if (itemArray[3].equals("Gum")){
                    allItems.put(itemArray[0], new Gum(itemArray[0], itemArray[1], Double.parseDouble(itemArray[2]), itemArray[3]));
                }else if (itemArray[3].equals("Candy")){
                    allItems.put(itemArray[0], new Gum(itemArray[0], itemArray[1], Double.parseDouble(itemArray[2]), itemArray[3]));
                }
                stock.put(itemArray[0], 5);
//                double price = Double.parseDouble(itemArray[2]);
//                items.put(itemArray[0], price);
//                itemNames.put(itemArray[0], itemArray[1]);

            }


            scanInput.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(String.format(" Error: %s", fnfe.getMessage()));
        }

    }

    public String purchaseItem(BigDecimal bal, String itemNumber) {
        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.print("What's The Item Number: ");
//            String itemNumber = scan.nextLine();
            SalesReport sales = new SalesReport();
            balance = bal;
            BigDecimal price = BigDecimal.valueOf(allItems.get(itemNumber).getItemCost());
            BigDecimal beforeBalance = balance;
            Item item = allItems.get(itemNumber);
            int counter = stock.get(itemNumber);
            if (price.compareTo(balance) <= 0) {
                if (stock.get(itemNumber) > 0) {
                    counter--;
                    balance = balance.subtract(price);
                    stock.put(itemNumber, counter);
                    // log here
                    Log log = new Log();
                    log.writeLog(item.getItemName(), beforeBalance, balance);
                    sales.writeSalesReport(allItems.get(itemNumber).getItemName(), price);
                    return item.vend();
                } else {
                    return System.lineSeparator() + "Out of stock. Please select another product.";
                }
            } else {
                return System.lineSeparator() + "Insufficient funds.";
            }
        } catch (NullPointerException npe) {
            return System.lineSeparator() + "Error: Item does not exist. Please reselect product.";
        }

//        Item item = allItems.get(itemNumber);
//        double price = item.getItemCost();
//        BigDecimal priceBig = BigDecimal.valueOf(price);
//        if(priceBig.compareTo(balance) <= 0) {
//            System.out.println(price);
//            item.vend();
//        }

//        for (Map.Entry<String,Item> item : allItems.entrySet()){
//            if (item.getKey().equals(itemNumber)){
//                String key = item.get(itemNumber);
//                Item value = item.getValue();
//                if (value.getItemCost)
//            }
//        }



//        if(items.containsKey(itemNumber)) {
//            BigDecimal price = BigDecimal.valueOf(items.get(itemNumber));
//
//
//            if (price.compareTo(balance) <= 0){
//                try {
//                    File input = new File("vendingmachine.csv");
//                    Scanner inputScan = new Scanner(input);
//                    while(inputScan.hasNextLine()) {
//                        String line = inputScan.nextLine();
//                        Log log = new Log();
//                        if(line.contains(itemNumber)) {
//                            String itemArray[] = line.split("\\|");
//                            if(itemArray[itemArray.length-1].equals("Chip")) {
//                                if(stock.get(itemNumber) > 0) {
//                                    Chip chip = new Chip();
//                                    chip.vendChip();
//                                    BigDecimal beforeBalance = new BigDecimal(String.valueOf(balance));
//                                    balance = balance.subtract(price);
//                                    log.writeLog(itemNames.get(itemNumber) + " " + itemNumber, beforeBalance, balance);
//                                    for(Map.Entry entry : stock.entrySet()) {
//                                        if(entry.getKey().equals(itemNumber)) {
//                                            stock.put(itemNumber, ((int)entry.getValue() - 1));
//                                            System.out.println(entry);
//                                        }
//                                    }
//
//
//                                } else {
//                                    System.out.println("Out of stock.");
//                                }
//                            } else if(itemArray[itemArray.length-1].equals("Gum")) {
//                                if(stock.get(itemNumber) > 0) {
//                                    Gum gum = new Gum();
//                                    gum.vendGum();
//                                    BigDecimal beforeBalance = new BigDecimal(String.valueOf(balance));
//                                    balance = balance.subtract(price);
//                                    log.writeLog(itemNames.get(itemNumber) + " " + itemNumber, beforeBalance, balance);
//                                    for(Map.Entry entry : stock.entrySet()) {
//                                        if(entry.getKey().equals(itemNumber)) {
//                                            stock.put(itemNumber, ((int)entry.getValue() - 1));
//                                            System.out.println(entry);
//                                        }
//                                    }
//                                }  else {
//                                    System.out.println("Out of stock.");
//                                }
//                            } else if(itemArray[itemArray.length-1].equals("Drink")) {
//                                if(stock.get(itemNumber) > 0) {
//                                    Drink drink = new Drink();
//                                    drink.vendDrink();
//                                    BigDecimal beforeBalance = new BigDecimal(String.valueOf(balance));
//                                    balance = balance.subtract(price);
//                                    log.writeLog(itemNames.get(itemNumber) + " " + itemNumber, beforeBalance, balance);
//                                    for(Map.Entry entry : stock.entrySet()) {
//                                        if(entry.getKey().equals(itemNumber)) {
//                                            stock.put(itemNumber, ((int)entry.getValue() - 1));
//                                            System.out.println(entry);
//                                        }
//                                    }
//                                } else {
//                                    System.out.println("Out of stock.");
//                                }
//                            } else if(itemArray[itemArray.length-1].equals("Candy")) {
//                                if(stock.get(itemNumber) > 0) {
//                                    Candy candy = new Candy();
//                                    candy.vendCandy();
//                                    BigDecimal beforeBalance = new BigDecimal(String.valueOf(balance));
//                                    balance = balance.subtract(price);
//                                    log.writeLog(itemNames.get(itemNumber) + " " + itemNumber, beforeBalance, balance);
//                                    for(Map.Entry entry : stock.entrySet()) {
//                                        if(entry.getKey().equals(itemNumber)) {
//                                            stock.put(itemNumber, ((int)entry.getValue() - 1));
//                                            System.out.println(entry);
//                                        }
//                                    }
//                                } else {
//                                    System.out.println("Out of stock.");
//                                }
//                            }
//                        }
//                    }
//                } catch (FileNotFoundException fnfe) {
//                    System.out.println(String.format(" Error: %s", fnfe.getMessage()));
//                }
//            } else {
//                System.out.println("Insufficient Funds");
//            }
//        } else {
//            System.out.println("Item does not exist.");
//        }
    }

    public String getChange(BigDecimal bal) {
        balance = bal;
        if(balance != null) {
            BigDecimal quarter = new BigDecimal(".25");
            BigDecimal dime = new BigDecimal(".10");
            BigDecimal nickel = new BigDecimal(".05");
            BigDecimal numberOfQuarters = new BigDecimal("0");
            BigDecimal numberOfDimes = new BigDecimal("0");
            BigDecimal numberOfNickels = new BigDecimal("0");
            BigDecimal beforeBalance = new BigDecimal(String.valueOf(balance));
            if (balance.compareTo(BigDecimal.ZERO) > 0) {
                numberOfQuarters = balance.divide(quarter, 0, 1);
                balance = balance.subtract(numberOfQuarters.multiply(quarter));
                //System.out.println("Quarters: " + numberOfQuarters);
                if (balance.compareTo(BigDecimal.ZERO) > 0) {
                    numberOfDimes = balance.divide(dime, 0, 1);
                    balance = balance.subtract(numberOfDimes.multiply(dime));
                    //System.out.println("Dimes: " + numberOfDimes);
                    if (balance.compareTo(BigDecimal.ZERO) > 0) {
                        numberOfNickels = balance.divide(nickel, 0, 1);
                        balance = balance.subtract(numberOfNickels.multiply(nickel));
                        //System.out.println("Nickels: " + numberOfNickels);
                    }
                }
                Log log = new Log();
                log.writeLog("GIVE CHANGE", beforeBalance, balance);
            }
            return System.lineSeparator() +"Quarters: " + numberOfQuarters + System.lineSeparator() + "Dimes: " + numberOfDimes +
                    System.lineSeparator() + "Nickels: " + numberOfNickels;
        } else {
            return "No available balance.";
        }
    }

    public boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

}
