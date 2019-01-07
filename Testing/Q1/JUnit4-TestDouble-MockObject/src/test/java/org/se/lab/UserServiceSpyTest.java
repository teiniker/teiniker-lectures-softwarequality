package org.se.lab;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

public class UserServiceSpyTest
{
    @Spy
    private UserDAOImpl dao;

    private UserService service;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        service = new UserService(dao);
        service.addUser(new User(3,"marge", "tLgR+kBQUymuhx5S8DUnw3IMmvf7hgeBllhTXFSExB4="));
        service.addUser(new User(7,"homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8="));

    }


    @Test
    public void testUserToXml()
    {
        // exercise
        String xml = service.toXml(7);

        // verify
        String expected =
                "<user>" +
                        "<id>7</id>" +
                        "<name>homer</name>" +
                        "<password>Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=</password>" +
                        "</user>";
        Assert.assertEquals(expected, xml);

        verify(dao, times(2)).insert(any(User.class));
        verify(dao).findById(7);
    }

}
