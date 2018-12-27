package org.se.lab;

public class UserBuilder
{
    private int id;
    private String username;
    private String password;

    // Builder operations

    public UserBuilder id(int id)
    {
        this.id = id;
        return this;
    }

    public UserBuilder username(String username)
    {
        this.username = username;
        return this;
    }

    public UserBuilder password(String password)
    {
        this.password = password;
        return this;
    }

    public User build()
    {
        return new User(id, username, password);
    }

}
