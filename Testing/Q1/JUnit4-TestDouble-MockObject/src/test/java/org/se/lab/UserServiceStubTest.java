package org.se.lab;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class UserServiceStubTest
{
    @Mock
    private UserDAO dao;

    private UserService service;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        service = new UserService(dao);
    }

    @Test
    public void testAddUser()
    {
        // exercise
        service.addUser(new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8="));

        // verify
        verify(dao).insert(isA(User.class));
    }

    @Test(expected = ServiceException.class)
    public void testAddUserWithException()
    {
        // setup
        doThrow(DAOException.class).when(dao).insert(isA(User.class));

        // exercise
        User user = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");
        service.addUser(user);
    }

    @Test
    public void testUserToXml()
    {
        // setup
        User u = new User(7,"homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");
        when(dao.findById(7)).thenReturn(u);

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
    }

    @Test
    public void testUserToXmlWithException()
    {
        // setup
        when(dao.findById(7)).thenThrow(new DAOException("Can't find user!"));

        // exercise
        try
        {
            service.toXml(7);
            Assert.fail();
        }
        catch(ServiceException e)
        {
            // verify
            Assert.assertEquals("Can't generate XML string!", e.getMessage());
            Assert.assertTrue(e.getCause() instanceof DAOException);
        }
    }

}
