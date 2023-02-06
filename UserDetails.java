package com.mydemo.project1;

import java.util.Scanner;

public class UserDetails
{
    Scanner sc = new Scanner(System.in);
    public Users getUserDetails()
    {
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
    public UserLogin getLoginDetails()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name --> ");
        String name= sc.nextLine();
        System.out.print("Password --> ");
        String password = sc.nextLine();
        return new UserLogin(name, password);
    }
//    public String searchUser()
//    {
//        System.out.print("Enter an USER to search ");
//        String name = sc.nextLine();
//        return name;
//    }
}
