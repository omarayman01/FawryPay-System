package Services_Factory;

import Order_and_payment.Order;
import Services.Donation.Cancer_Donation_Service;
import Services.Donation.Donation_Service;
import Services.Internet.*;

import java.util.Scanner;

public class Internet_service_Factory implements Service_Factory{
    public Internet_service_Factory(Order current_order)
    {
        Internet_Service service;
        Scanner sc=new Scanner(System.in);
        System.out.println("Select your internet service provider: ");
        System.out.println("-----------------------");
        System.out.println("1- Vodafone.");
        System.out.println("2- We");
        System.out.println("3- Orange.");
        System.out.println("4- Etisalat.");

        int option=sc.nextInt();

        if (option==1)
        {
            service=new Vodafone_Internet(current_order);
        }
        else if (option==2)
        {
            service=new We_Internet(current_order);
        }
        else if (option==3)
        {
            service=new Orange_Internet(current_order);
        }
        else if (option==4)
        {
            service=new Etisalat_Internet(current_order);
        }
        else
        {
            System.out.println("Select valid option");
            new Internet_service_Factory(current_order);
        }
    }
}
