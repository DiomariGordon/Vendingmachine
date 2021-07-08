package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    public void writeLog(String whatWasDone, BigDecimal moneySpent, BigDecimal balance) {
        try {
            File log = new File("logs/Log.txt");
            Writer logWrite = new FileWriter(log, true);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
            LocalDateTime date = LocalDateTime.now();
            String text = date.format(formatter);
            if(log.createNewFile() || log.exists()) {
                logWrite.write(text + " " + whatWasDone + ": $" + moneySpent + " $" + balance + System.lineSeparator());
            }
            logWrite.close();

        } catch (IOException ioe) {
            System.out.println(String.format(" Error: %s", ioe.getMessage()));
        }
    }

}
