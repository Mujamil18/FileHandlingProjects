package com.mydemo.project1;

import java.util.Scanner;

public class UserDetails
{
    public Users getUserDetails()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create Account");
        System.out.print("Name --> ");
        String name = sc.nextLine();
        System.out.print("Email Id --> ");
        String email = sc.nextLine();
        System.out.print("Account Type --> ");
        String accountType = sc.nextLine();
        Password obj=new Password();
        while(!obj.checkStrength());
        System.out.println("Hi " + name + "..Account created Successfully..");
        String password = obj.password;
        return new Users(name, email, accountType, password);
    }

}
