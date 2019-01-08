package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class UserDAO
{
    private List<User> table = new ArrayList<>();

    public void insert(User user)
    {
    	System.out.println("insert(" + user + ")");
        if(user == null)
            throw new IllegalStateException("User is null!");

        table.add(user);
    }

    public void update(User user)
    {
       throw new UnsupportedOperationException();
    }

    public void delete(int id)
    {
        throw new UnsupportedOperationException();
    }

    public User findById(int id)
    {
    	System.out.println("findById(" + id + ")");
        for(User u : table)
        {
            if(u.getId() == id)
                return u;
        }
        return null;
    }
}
