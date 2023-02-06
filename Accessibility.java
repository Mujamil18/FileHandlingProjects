package com.mydemo.project1;
import java.util.*;

public class Accessibility
{
    FileAdapter fa = new FileAdapter();
    UserDetails userObject = new UserDetails();
    /* UserDetails class is for getting user credentials (name , email id , account type, password) */

    public void mainMethod() {
        Scanner sc = new Scanner(System.in);
        int mainOption;
        do {
            System.out.println("1.Create Account\n2.Login\n0.Exit Program");
            mainOption = sc.nextInt();
            switch (mainOption) {
                case 1: //Create Account
                    /* invoking getUserDetails() method from Users class and
                    assigning returned value to the Users object */
                    Users details = userObject.getUserDetails();
                    fa.writeUserDetails(details);
                    fa.createUserFile(details);
                    userAccessibility();
                    break;
                case 2: //Login
                    System.out.println("Login");
                    UserLogin login = userObject.getLoginDetails();
                    boolean registered = fa.readUserDetails(login);
                    if(registered){
                        System.out.println("Hi "+login.getName()+"..!");
                        userAccessibility();}
                    else{
                        System.out.println("INVALID NAME OR PASSWORD. ENTER THE CORRECT NAME OR PASSWORD OR CREATE AN ACCOUNT!!!");
                    }
                    break;
                case 0:
                    System.out.println("Program Exited");
            }
        } while (mainOption != 0);
}
    public void userAccessibility()
    {
        Scanner sc = new Scanner(System.in);
        int accessOption;
        do {
            System.out.println("\n1.Send Message\n2.View Message\n3.Delete Message\n4.View User\n0.Back");
            accessOption = sc.nextInt();
            sc.nextLine();
            switch(accessOption)
            {
                case 1:
                    Messages msgs = new Messages(); //invoking Message Constructor to get message
                    boolean checkRecipient = fa.readRegisteredUsers(msgs.getRecipient());
                    fa.writeMessagesToFile(msgs, checkRecipient);
                    fa.writeSentMessages(msgs);
                    break;
                case 2:
                    System.out.println("View Message");
                    fa.readMessageFromFile();
                    break;
                case 3:
                    System.out.println("Delete Message");
                    break;
                case 4:
                    System.out.println("Search");
                    break;
                case 0:
                    System.out.println("Back");
            }
        }while(accessOption != 0);
    }
}
