package org.se.lab;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTableTest 
{		
	private Connection c = null;
	private Service service = null;
	private final static JdbcTestHelper JDBC_HELPER = new JdbcTestHelper();
	
	@BeforeClass
	public static void init()
	{
		JDBC_HELPER.executeSqlScript("src/test/resources/sql/createUserTable.sql");
		JDBC_HELPER.executeSqlScript("src/test/resources/sql/insertUserTable.sql");
	}
	
	@AfterClass
	public static void destroy()
	{
		JDBC_HELPER.executeSqlScript("src/test/resources/sql/dropUserTable.sql");		
	}
	
	@Before
	public void setup() throws ClassNotFoundException, SQLException  
	{
		System.out.println("setup()");

		c = JDBC_HELPER.getConnection();
		JDBC_HELPER.txBegin(c);
		
		service = new Service();
	}
	
	@After
	public void teardown() throws SQLException
	{		      
		System.out.println("teardown()");
		
		JDBC_HELPER.txRollback(c);
		c.close();
	}

	
	@Test
	public void testSetupAndTearDown()
	{
	    // do nothing but execute setup() and teardown()
		System.out.println("testSetupAndTearDown()");
	}

	@Test
	public void testInsert() throws SQLException
	{
		System.out.println("testInsert()");
		
		service.insert(c, new User("maggie", "*******"));
		
		List<User> users = service.findAll(c);
		
		System.out.println(users);
		Assert.assertEquals(4, users.size());
	}

	
	@Test
    public void testLogin() throws SQLException, 
        ClassNotFoundException
    {
		System.out.println("testLogin()");
		
        final String username = "homer";
        final String password = "*******";
        
        
        boolean result = service.login(c, username, password);
        Assert.assertTrue(result);
    }
	
	@Test
	public void testFindAll() throws SQLException
	{
		System.out.println("testFindAll()");
		
		List<User> users = service.findAll(c);
		
		System.out.println(users);
		Assert.assertEquals(3, users.size());
	}
}
