package com.mydemo.project1;

import java.io.*;

public class FileAdapter
{

    private static final String FILEPATH1 = "/home/local/ZOHOCORP/mujamil-con1091/Mujamil/Users.txt";
    private static final String FILEPATH2 = "/home/local/ZOHOCORP/mujamil-con1091/Mujamil/Admins.txt";
    File file = null;

    UserDetails userObject = new UserDetails();
    Users details = userObject.getUserDetails();

    //method to write user details to a file
    public void writeUserDetails()
    {
        FileWriter fw = null;
        try
        {
            if(details.getAccountType().equals("user"))
            {
                fw = new FileWriter(FILEPATH1, true);
                fw.write(details.toString());
            }
            else if(details.getAccountType().equals("admin"))
            {
                fw = new FileWriter(FILEPATH2, true);
                fw.write(details.toString());
            }
            else {
                System.out.println("INVALID ACCOUNT TYPE!!!");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(fw != null)
            {
                try
                {
                    fw.close();
                }
                catch(IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
        }
    }
    //method to write the message to a file
    public void userPermissions(String recipient)
    {
        Messages messageObject = new Messages();
        writeToFile(messageObject, recipient);

    }
    //method to get the file path respective to the user
    public String getFilePath(String name)
    {
        return "/home/local/ZOHOCORP/mujamil-con1091/Mujamil/"+name+".txt";
    }
    //method to create a file for a registered users
    public void createUserFile()
    {
        String name = details.getName();
        String userFile = getFilePath(name);
        try
        {
            file = new File(userFile);
            System.out.println("File Created for you in this path --> "+ userFile);
            System.out.println("File name --> " + name+".txt" );
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
    }
//    method to write contents to a file
    public void writeToFile(Messages msgs, String receive)
    {
        FileWriter fw = null;
        try
        {
//            FileOutputStream fos = new FileOutputStream("/home/local/ZOHOCORP/mujamil-con1091/Mujamil/"+receive+".txt");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(msgs);
//            oos.close();
//            System.out.println("The Object  was successfully written to a file");
            fw = new FileWriter("/home/local/ZOHOCORP/mujamil-con1091/Mujamil/"+receive+".txt");
            fw.write(msgs.toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
}

