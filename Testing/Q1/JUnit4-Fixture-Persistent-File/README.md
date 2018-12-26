## Example: JUnit4-Fixture-Persistent-File

This example shows the use of Files in a Test Fixture.
Since this is a persistent fixture, the file must be created in the setup and 
destroyed again during the teardown phase.

```java
public class LoggerTest
{
    private Path path = Paths.get("target", "simple.log");
    private Logger log;

    @Before
    public void setup() throws IOException
    {
        Files.createFile(path);
        log = new Logger("simple");
    }
    @After
    public void teardown() throws IOException
    {
        Files.deleteIfExists(path); 
    }
    ...
}
```

If we omit the teardown, only the first test run would work, all further 
attempts would fail.

*Egon Teiniker, 2018, GPL v3.0*