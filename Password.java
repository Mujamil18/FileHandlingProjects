package com.mydemo.project1;

import java.util.Scanner;

class Password
{
    String password;
    boolean checkStrength()
    {
        Scanner input=new Scanner(System.in);
        System.out.print("Password --> ");
        password=input.nextLine();
        String confirmPassword;
        boolean isLowerCase,isUpperCase,isNumber,isSplChar,isConform;
        for(int i=0;i<password.length();i++)
        {
            if(password.charAt(i)==' ')
            {
                System.out.println("Your password should not contain space");
                return false;
            }
        }
        if(password.length()<8)
        {
            System.out.println("Password should have at-least 8 characters!");
            return false;
        }
        else
        {
            LowerCase low=new LowerCase();
            isLowerCase=low.checkLowercase(password);
            if(!isLowerCase)
            {
                System.out.println("Password must contain at-least one lower case character!");
                return false;
            }

            UpperCase upper=new UpperCase();
            isUpperCase=upper.checkUppercase(password);
            if(!isUpperCase)
            {
                System.out.println("Password must contain at-least one upper case character!");
                return false;
            }

            Number num=new Number();
            isNumber=num.checkNumber(password);
            if(!isNumber)
            {

                System.out.println("Password must contain at-least one number!");
                return false;
            }

            SpecialCharacter splChar=new SpecialCharacter();
            isSplChar=splChar.checkSpecialCharacter(password);
            if(!isSplChar)
            {
                System.out.println("Password should contain atleast one special character");
                return false;
            }
            if(isLowerCase && isUpperCase && isNumber && isSplChar)
            {
                ConfirmPassword confirm=new ConfirmPassword();
                System.out.print("Confirm Password --> ");

                do {
                    confirmPassword=input.next();
                    isConform=confirm.confirmPassword(password,confirmPassword);
                    if(!isConform) System.out.println("Your password mismatches..Enter Again");
                }while(!isConform);
            }
        }
        return true;
    }
}

class LowerCase
{
    boolean checkLowercase(String pwd)
    {
        boolean bool;
        char i,j;
        for(j=0;j<pwd.length();j++)
        {
            if(pwd.charAt(j)>='a' && pwd.charAt(j)<='z')
            {
                return true;
            }
        }

        return  false;
    }
}

class UpperCase
{
    boolean checkUppercase(String pwd)
    {
        boolean bool;
        char i,j;
        for(j=0;j<pwd.length();j++)
        {
            if(pwd.charAt(j)>='A' && pwd.charAt(j)<='Z')
            {
                return true;
            }
        }
        return  false;
    }
}

class Number
{
    boolean checkNumber(String pwd)
    {
        boolean bool;
        char i,j;
        for(j=0;j<pwd.length();j++)
        {
            if(pwd.charAt(j)>='0' && pwd.charAt(j)<='9')
            {
                return true;
            }
        }
        return false;
    }
}

class SpecialCharacter
{
    boolean checkSpecialCharacter(String pwd)
    {
        boolean bool;
        char i,j;
        for(j=0;j<pwd.length();j++)
        {
            if((pwd.charAt(j)>32 && pwd.charAt(j)<=47)|| (pwd.charAt(j)>57 && pwd.charAt(j)<=64) || (pwd.charAt(j)>90 && pwd.charAt(j)<=95) || (pwd.charAt(j)>122 && pwd.charAt(j)<=126))
            {
                return true;
            }
        }

        return  false;
    }
}
class ConfirmPassword
{
    boolean confirmPassword(String pwd,String pwd2)
    {
        if(pwd.equals(pwd2))
            return true;
        else
            return false;
    }
}
