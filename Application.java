package com.mydemo.project1;

import java.util.*;

public class Application
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int mainOption, accessOption;
        do
        {
            System.out.println("1.Create Account\n2.Login\n0.Exit Program");
            mainOption = sc.nextInt();
            switch(mainOption)
            {
                case 1:
                    FileAdapter fa = new FileAdapter();
                    fa.writeUserDetails();
                    fa.createUserFile();
                    do {
                        System.out.println("\n1.Send Message\n2.View Message\nDelete Message\n0.Close");
                        accessOption = sc.nextInt();
                        sc.nextLine();
                        switch(accessOption)
                        {
                            case 1:
                                System.out.println("Select a recipient to send a message");
                                String recipient = sc.nextLine();
                                fa.userPermissions(recipient);
                                break;
                        }
                    }while(accessOption != 0);
                    break;

                case 2:
                    System.out.println("Login");
                    break;
                case 0:
                    System.out.println("Program Exited");
            }
        }while(mainOption != 0);
    }

}
