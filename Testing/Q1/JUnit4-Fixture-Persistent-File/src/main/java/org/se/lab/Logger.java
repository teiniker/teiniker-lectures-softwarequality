package org.se.lab;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class Logger
{
    private final String LOGGER_NAME;
    private Path path;

    public Logger(String name)
    {
        LOGGER_NAME = name + ".log";
        path = Paths.get("target", LOGGER_NAME);
    }

    // Logging operations

    public void debug(String message)
    {
        log("DEBUG: " + message);
    }

    public void info(String message)
    {
        log("INFO: " + message);
    }

    public void warning(String message)
    {
        log("WARNING: " + message);
    }


    private void log(String message)
    {
        Date now = new Date();
        try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.APPEND))
        {
            writer.write(now + " - " + message + "\n");
        }
        catch(IOException e)
        {
            throw new IllegalStateException("Can't write to log file " + path.getFileName(), e);
        }
    }
}
