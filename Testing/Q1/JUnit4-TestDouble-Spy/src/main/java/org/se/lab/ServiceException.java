package org.se.lab;

/**
 * This exception is used the encapsulate all integration layer exceptions
 * (e.g. DAOException, etc.)
 */
public class ServiceException
	extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public ServiceException()
	{
		super();
	}

	public ServiceException(String msg)
	{
		super(msg);
	}

	public ServiceException(String msg, Throwable cause)
    {
        super(msg, cause);
    }
}
