package org.se.lab.presentation.commands;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.se.lab.business.UserService;


public class AddCommand
	extends WebCommand
{
	private final Logger LOG = Logger.getLogger(AddCommand.class);
	
	@Override
	public void process() throws ServletException, IOException
	{
		LOG.debug("process ADD command");
		
		Connection c = null;
		try
		{
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
 		
			// TODO: Validate request parameters!
			
			c = createConnection();
			UserService service = factory.createUserService(c);
			service.addUser(firstName, lastName, username, password);
			req.setAttribute("message", "User '" + username + "' successfully added.");
		}
		catch(Exception e)
		{
		    req.setAttribute("message", "Error: " + e.getMessage());
			LOG.error("Can't add user!", e);
		}
		finally
		{
			if(c != null)
			{
				try
				{
					c.close();
				}
				catch (SQLException e)
				{
					req.setAttribute("message", "Error: " + e.getMessage());
					LOG.error("Can't close database connection!", e);
				}
			}
		}
		forward("/index.jsp");			
	}
}
