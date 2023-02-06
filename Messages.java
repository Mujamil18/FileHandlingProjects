package com.mydemo.project1;

import java.io.Serializable;
import java.util.Scanner;

public class Messages implements Serializable
{
    String message;
    String recipient;
    public Messages()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select a recipient to send a message");
        recipient = sc.nextLine();
        System.out.println("Type a message");
        message = sc.nextLine();

    }

    public String getRecipient()
    {
        return this.recipient;
    }
    public String getMessage()
    {
        return this.message;
    }
    public String toString()
    {
        return  "MESSAGE --> " +  message+" SENT TO --> " + recipient+"\n";
    }

}
