package com.mydemo.project1;

import java.io.*;

public class FileAdapter {
    /* created files for User and Admin separately FILEPATH1 for users and FILEPATH2 for admins */
    private static final String FILEPATH1 = "/home/local/ZOHOCORP/mujamil-con1091/Mujamil/Users.txt";
    private static final String FILEPATH2 = "/home/local/ZOHOCORP/mujamil-con1091/Mujamil/Admins.txt";
    File file = null;
    boolean accountCreated = false;
    private static String loginName;

    /*method to write user details to a file , if the account type is user, that will be stored in Users file
    and if it is admin , then it will be stored in Admins file*/
    public void writeUserDetails(Users details) {
        FileWriter fw = null;
        try {
            if (details.getAccountType().equals("user")) {
                fw = new FileWriter(FILEPATH1, true);
                fw.write(details.toString());
            } else if (details.getAccountType().equals("admin")) {
                fw = new FileWriter(FILEPATH2, true);
                fw.write(details.toString());
            } else {
                System.out.println("INVALID ACCOUNT TYPE!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
    /*method to read user Details from a file to check Login credentials and will let the user to login
    only after created account(if the username and password are in the file)*/
    public boolean readUserDetails(UserLogin login) {
        String[] registeredUsers;
        String s;
        String name = login.getName();
        String password = login.getPassword();
        String str = name + " " + password;
        boolean check = false;
        FileReader fr = null;
        try {
            fr = new FileReader(FILEPATH1);
            BufferedReader br = new BufferedReader(fr);
            while ((s = br.readLine()) != null) {
                registeredUsers = s.split(", ");
                for (String u : registeredUsers) {
                    if (str.equals(u)) {
                        check = true;
                        break;
                    }
                }
//                System.out.println(Arrays.toString(registeredUsers));
            }
                if (check) {
                    accountCreated = true;
                    loginName = login.getName();
                }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return accountCreated;
    }
    /* method to read the Users file to check whether the recipient is registered or not*/
    public boolean readRegisteredUsers(String name)
    {
        String[] registeredUsers;
        String s,n="", str;
        boolean checkRecipient = false;
        FileReader fr = null;
        try {
            fr = new FileReader(FILEPATH1);
            BufferedReader br = new BufferedReader(fr);
            while ((s = br.readLine()) != null) {
                registeredUsers = s.split(", ");
                for (String u : registeredUsers) {
                    if (u.contains(name)) {
                        str = u;
                        n = "";
                        for (char i = 0; i < str.length(); i++) {
                            if (str.charAt(i) == ' ') {
                                break;
                            }
                            n += str.charAt(i);
                            }
//                        System.out.println("Name " + n);
                        if (name.equals(n)) {
                            checkRecipient = true;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return checkRecipient;
    }

    //method to get the file path respective to the user
    public String getFilePath(Users details) {
        return "/home/local/ZOHOCORP/mujamil-con1091/Mujamil/" + details.getName() + ".txt";
    }

    //method to create a file for a registered users while creating account
    public void createUserFile(Users details) {
        String userFile = getFilePath(details);
        FileWriter fw = null;
        try {
            file = new File(userFile);
            fw = new FileWriter(file);
            System.out.println("File Created for you in this path --> " + userFile);
            System.out.println("File name --> " + details.getName() + ".txt");
            loginName = details.getName();
            fw.write("THIS IS " + details.getName()+"'s INBOX, YOUR SENT AND RECEIVED MESSAGES WILL APPEAR HERE\n\n");

        } catch (Exception ee) {
            ee.printStackTrace();
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

    public void writeSentMessages(Messages msgs)
    {
        String fromFilePath = "/home/local/ZOHOCORP/mujamil-con1091/Mujamil/"+loginName+".txt";
        FileWriter fw = null;
        try
        {
            fw = new FileWriter(fromFilePath, true);
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
//    method to write messages to a recipient file, if the recipient is already registered
    public void writeMessagesToFile(Messages msgs, boolean check) {
        String toFilePath = "/home/local/ZOHOCORP/mujamil-con1091/Mujamil/" + msgs.getRecipient() + ".txt";
        FileWriter fw = null;
        try {
            if(check) {
                fw = new FileWriter(toFilePath, true);
                fw.write(msgs.getMessage() + " From : " + loginName + "\n");
                System.out.println("Message sent Successfully!");
            }
            else {
                System.out.println("USER DOESN'T EXISTS");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    /* method to read message from login account and display */
    public void readMessageFromFile() {
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
