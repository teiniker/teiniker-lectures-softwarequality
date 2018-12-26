## Example: JUnit4-Fixture-Persistent-JPA

This example shows the use of a database fixture.

In this example, we use a two-step approach:

1. First, the database schema is created once (when loading the test class) 
via a SQL script. This schema will be deleted on teardown via a second SQL 
script.

```java
    ...
    @BeforeClass
    public static void init()
    {
        JDBC_HELPER.executeSqlScript("src/test/resources/sql/createUserTable.sql");
    }
    
    @AfterClass
    public static void destroy()
    {
        JDBC_HELPER.executeSqlScript("src/test/resources/sql/dropUserTable.sql");
    }
    ...
```

2. For each test, a database transaction is started in the @Before method 
and rolled back in the @After method. This eliminates any changes made 
in the database during a test.

```java
    ...
    @Before
    public void setUp()
    {
        table = new UserTableImpl(em);          
        
        JPA_HELPER.txBegin();        
        table.createUser(1, "homer", "simpson", "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");        
        table.createUser(2, "marge","simpson", "marge", "tLgR+kBQUymuhx5S8DUnw3IMmvf7hgeBllhTXFSExB4=");
    }   

    @After
    public void tearDown()
    {
    	JPA_HELPER.txRollback();
    }
    ...
```

Note that this two-step approach works only if the test can control the 
transactions used in the SUT.

*Egon Teiniker, 2018, GPL v3.0*