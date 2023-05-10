import java.util.*;
import Accounts.*;
import Services.*;
import Services_Factory.*;


public class Main {
    public static Account_Factory select_account_factory(int option)
    {
        if (option==1)
        {
            return User_Factory.getobj();
        }
        else
        {
            return  Admin_Factory.getobj();
        }

    }




    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int option=0;

        do {
            System.out.println();
            System.out.println("Select account type:");
            System.out.println("1- User \n2- Admin\n0- Exit Program");
            option=sc.nextInt();
            Account_Factory accountFactory = null;
            Account current_account=null;
            if (option==1)
            {
                accountFactory=select_account_factory(1);
            }
            else if (option==2)
            {
                accountFactory=select_account_factory(2);
            }
            else if (option==0) {
                System.exit(0);

            }
            else {
                option=5;
                continue;
            }



            System.out.println("Select one action:");
            System.out.println("1- Login \n2- Sign up");
            option=sc.nextInt();

            if (option==1)
            {
                current_account=accountFactory.login();

            }
            else if (option==2) {
                current_account=accountFactory.signUp();
            }
            else {
                option=5;
                continue;
            }

            while (current_account.show_options()!=0)
            {}
        }
        while (option!=0);






    }
}