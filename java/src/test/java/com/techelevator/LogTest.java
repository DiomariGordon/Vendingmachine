package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.nio.file.*;


public class LogTest {

    @Test
    public void writeLog_testOutput() {
        try {
            File testLog = new File("logs/Test Log.txt");
            Log log = new Log();
            Writer logWrite = new FileWriter(testLog, true);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
            LocalDateTime date = LocalDateTime.now();
            String text = date.format(formatter);
            String expected = text + " " + "FEED MONEY: " + ": $" + new BigDecimal("10.00") + " $" + new BigDecimal("8.50");

            if (testLog.createNewFile() || testLog.exists()) {
                logWrite.write(text + " " + "FEED MONEY: " + ": $" + new BigDecimal("10.00") + " $" + new BigDecimal("8.50"));
            }
            logWrite.close();

            Scanner scanLog = new Scanner(testLog);
            boolean equal = false;
            while(scanLog.hasNextLine()) {
                String line = scanLog.nextLine();
                if(expected.equals(line)) {
                    equal = true;
                }
            }
            scanLog.close();
            Assert.assertTrue(equal);
            try {
                Files.deleteIfExists(Paths.get("logs/Test Log.txt"));
            } catch(NoSuchFileException nsfe) {
                System.out.println("No such file");
            }
        } catch (IOException ioe) {
            System.out.println(String.format(" Error: %s", ioe.getMessage()));
        }
    }
}
