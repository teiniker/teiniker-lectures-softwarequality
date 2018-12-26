## Example: JUnit4-Fixture-Persistent-ClassVariable

This example shows the use of a static field in a Test Fixture.
Since this is a persistent fixture, the static field must be re-set in 
the teardown phase.

```java
public class UserTest
{
    ...
    @After
    public void teardown()
    {
        LongSequence.resetSequenceNumber(); 
    }
    ...
}
```

If we omit the teardown, only the first test run would work, all further 
attempts would fail.

*Egon Teiniker, 2018, GPL v3.0*