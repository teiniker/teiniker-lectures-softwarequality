package org.se.lab;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LoggerTest
{
    private Path path = Paths.get("target", "simple.log");
    private Logger log;

    @Before
    public void setup() throws IOException
    {
        // setup
        Files.createFile(path);
        log = new Logger("simple");
    }

	@After
	public void teardown() throws IOException
	{
	    // teardown
        Files.deleteIfExists(path);
	}
	
	
	@Test
	public void testLogger() throws IOException
    {
        // exercise
        log.debug("open()");
        log.debug("send()");
        log.debug("close()");

        // verify
        long numberOfLines = Files.lines(path).count();
        assertEquals(3, numberOfLines);

        List<String> lines = Files.readAllLines(path);
        lines.forEach(System.out::println);
    }
	
}
