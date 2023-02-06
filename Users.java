package com.mydemo.project1;
import java.io.Serializable;

public class Users implements Serializable
{
    private String name;
    private String email;
    private String accountType;
    private String password;


    public Users(String name, String email, String accountType, String password)
    {
        this.name = name;
        this.email = email;
        this.accountType = accountType;
        this.password = password;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getEmail()
    {
        return this.email;
    }
    public void setEmail()
    {
        this.email= email;
    }
    public String getAccountType()
    {
        return this.accountType;
    }
    public void setAccountType()
    {
        this.accountType= accountType;
    }
    public void setPassword()
    {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.name +" " + this.password+"\n";
    }

}

