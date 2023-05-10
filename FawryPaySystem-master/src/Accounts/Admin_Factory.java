package Accounts;

import java.util.*;

public class Admin_Factory implements Account_Factory {

    private Vector<Admin> admin_accounts;

    private static Admin_Factory obj=null;

    // private constructor to force use of
    // getInstance() to create Singleton object
    private Admin_Factory ()
    {
        admin_accounts=new Vector<Admin>(0);
    }

    public static Admin_Factory getobj()
    {
        if (obj==null)
            obj = new Admin_Factory();

        return obj;


    }



    @Override
    public Account login(String mail, String pass) {

        for (int i = 0; i < admin_accounts.size(); i++) {
            if (admin_accounts.elementAt(i).email.equals(mail))
            {
                if (admin_accounts.elementAt(i).password.equals(pass))
                {
                    System.out.println("login successful");
                    return admin_accounts.elementAt(i);
                }

                else {
                    System.out.println("Email found but, password is incorrect");
                    return null;
                }
            }
        }
        System.out.println("Email not found, Consider_signing up");
        return null;
    }

    @Override
    public Account login() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter admin's email: ");
        String mail=sc.next();
        System.out.println();

        System.out.print("Enter admin's pass: ");
        String pass=sc.next();
        System.out.println();

        for (int i = 0; i < admin_accounts.size(); i++) {
            if (admin_accounts.elementAt(i).email.equals(mail))
            {
                if (admin_accounts.elementAt(i).password.equals(pass))
                {
                    System.out.println("login successful");
                    return admin_accounts.elementAt(i);
                }

                else {
                    System.out.println("Email found but, password is incorrect");
                    return null;
                }
            }
        }
        System.out.println("Email not found, Consider_signing up");
        return null;
    }

    @Override
    public Account signUp(String mail, String pass) {

        for (int i = 0; i < admin_accounts.size(); i++) {
            if (admin_accounts.elementAt(i).email.equals(mail))
            {
                System.out.println("Email is already used.");
                return null;
            }
        }

        admin_accounts.add(new Admin(mail,pass));
        System.out.println("Admin account created successfully");
        return admin_accounts.lastElement();
    }

    @Override
    public Account signUp() {

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter admin's email: ");
        String mail=sc.nextLine();
        System.out.println();

        System.out.print("Enter admin's pass: ");
        String pass=sc.nextLine();
        System.out.println();


        for (int i = 0; i < admin_accounts.size(); i++) {
            if (admin_accounts.elementAt(i).email.equals(mail))
            {
                System.out.println("Email is already used.");
                return null;
            }
        }

        admin_accounts.add(new Admin(mail,pass));
        System.out.println("Admin account created successfully");
        return admin_accounts.lastElement();
    }
}

