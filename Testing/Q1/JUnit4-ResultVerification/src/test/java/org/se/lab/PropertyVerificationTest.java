package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class SmellyVerificationTest
{
    @Test
    public void testToString()
    {
        User u = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");

        // verify
        String expected = "7,homer";
        Assert.assertEquals(expected , u.toString());
    }


    /*
	 * Here we compare each attribute of an object with a separate assert statement.
	 */
	@Test
	public void testEachAttribute()
	{
		User u = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");

		// verify
        User expected = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");
        Assert.assertEquals(expected.getId(), u.getId());
		Assert.assertEquals(expected.getUsername(), u.getUsername());
		Assert.assertEquals(expected.getPassword(), u.getPassword());
	}
}
