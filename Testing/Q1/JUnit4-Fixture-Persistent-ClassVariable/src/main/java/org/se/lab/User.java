package org.se.lab;

public class User
{
	/*
	 * Initialization constructor
	 */
	public User(String username, String password)
	{
		// auto generated id value
		id = LongSequence.getNextSequenceNumber();
		setUsername(username);
		setPassword(password);
	}
	
	/*
	 * Property: id:long
	 */
	private final long id;
	public long getId()
	{
		return id;
	}
	

	/*
	 * Property: username:String
	 */
	private String username;
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		if(username == null)
			throw new IllegalArgumentException();
		this.username = username;
	}
	
	
	/*
	 * Property: password:String
	 */
	private String password;
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		if(password == null)
			throw new IllegalArgumentException();
		this.password = password;
	}
	
	
	/*
	 * Object methods
	 */
	
	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + "]";
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		return id == user.id;
	}

	@Override
	public int hashCode()
	{
		return (int) (id ^ (id >>> 32));
	}
}
