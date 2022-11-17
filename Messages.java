package com.mydemo.project1;

import java.io.Serializable;
import java.util.Scanner;

public class Messages implements Serializable
{
    String message;
    public Messages()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type a message");
        message = sc.nextLine();
    }
    public String toString()
    {
        return message;
    }

}
