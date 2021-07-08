package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.Scanner;

public class SalesReport {
    public void writeSalesReport(String itemName, BigDecimal cost) {
        try {
            File log = new File("logs/Sales Report.txt");
            boolean contains = false;

            if(log.exists() || log.createNewFile()) {
                Scanner scanLog = new Scanner(log);
                while(scanLog.hasNextLine()) {
                    String line = scanLog.nextLine();
                    String[] lineArray = line.split("\\|");
                    if(lineArray[0].equals(itemName)) {
                        Writer logWrite = new FileWriter(log);
                        contains = true;
                        double newSum = Double.parseDouble(lineArray[1]);
                        newSum += cost.doubleValue();
                        logWrite.write(itemName+ "|" + newSum + System.lineSeparator());
                        logWrite.close();
                    }
                }
                scanLog.close();
                //Scanner scanLog2 = new Scanner(log);
                Writer logWrite2 = new FileWriter(log, true);
                    if (!contains) {
                        logWrite2.write(itemName + "|" + cost + System.lineSeparator());
                    }
                logWrite2.close();
            }


        } catch (IOException ioe) {
            System.out.println(String.format(" Error: %s", ioe.getMessage()));
        }
    }

}
