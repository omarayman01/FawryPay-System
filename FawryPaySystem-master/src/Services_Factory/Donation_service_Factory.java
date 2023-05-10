package Services_Factory;

import Order_and_payment.Order;
import Services.Donation.Cancer_Donation_Service;
import Services.Donation.Donation_Service;
import Services.Donation.NGO_Donation_Service;
import Services.Donation.Schools_Donation_Service;
import Services.Service;

import java.util.*;

public class Donation_service_Factory implements Service_Factory{
    public Donation_service_Factory(Order current_order)
    {
        Donation_Service service;
        Scanner sc=new Scanner(System.in);
        System.out.println("Select which donation center: ");
        System.out.println("-----------------------");
        System.out.println("1- Cancer Donations.");
        System.out.println("2- NGO Donations.");
        System.out.println("3- Schools Donations.");
        int option=sc.nextInt();
        if (option==1)
        {
            service=new Cancer_Donation_Service( current_order);
        }
        else if (option==2)
        {
            service=new NGO_Donation_Service( current_order);
        }
        else if (option==3)
        {
            service=new Schools_Donation_Service( current_order);
        }

        else
        {
            System.out.println("Select valid option");
            new Donation_service_Factory(current_order);
        }

    }
}
