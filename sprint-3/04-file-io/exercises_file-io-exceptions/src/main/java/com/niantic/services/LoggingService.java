package com.niantic.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggingService {

    private String logType;

    public LoggingService(String logType)
    {
        this.logType = logType;

        ensureDirectoryExists(logType);
    }

    private static void ensureDirectoryExists(String directoryName)
    {
        File directory = new File(directoryName);
        if(!directory.exists()) directory.mkdir();
    }

    private File getLogFile()
    {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String fileName = String.format("%s/%s.log", logType, today.format(formatter));
        return new File(fileName);
    }

    public void writeToLog(String message)
    {
        var locationToWrite = getLogFile();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try(FileOutputStream stream = new FileOutputStream(locationToWrite, true);
            PrintWriter out = new PrintWriter(stream))
        {
            out.printf("%s %s\n",now.format(formatter), message);
        }
        catch(Exception e)
        {
            // NOM NOM
        }
    }
}
