package org.se.lab;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest
{
    private User user;

	
	@Test
	public void testConstructor()
	{
        // exercise
        long id = user.getId();
        String username = user.getUsername();
        String password = user.getPassword();

        // verify
		assertEquals(1, id);
		assertEquals("homer", username);
		assertEquals("Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=", password);
	}
	

	@Test
	public void testToString()
	{
        // exercise
        String s = user.toString();

        // verify
		assertEquals("User [id=1, username=homer]", s);
	}
}
