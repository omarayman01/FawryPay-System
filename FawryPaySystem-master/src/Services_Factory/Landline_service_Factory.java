package Services_Factory;
import Order_and_payment.Order;
import Services.Landline.Landline_Service;
import Services.Landline.Monthly_LandLine_Service;
import Services.Landline.Quarterly_LandLine_Service;

import java.util.*;

public class Landline_service_Factory implements Service_Factory{
    public Landline_service_Factory(Order current_order)
    {
        Landline_Service service;
        Scanner sc=new Scanner(System.in);
        System.out.println("Select your Landline receipt : ");
        System.out.println("-----------------------");
        System.out.println("1- Monthly.");
        System.out.println("2- Quarterly");
        int option=sc.nextInt();
        if(option==1)
        {
               service=new Monthly_LandLine_Service(current_order);
        } else if (option==2) {
            service=new Quarterly_LandLine_Service(current_order);
        }
        else
        {
            System.out.println("Select valid option");
            new Landline_service_Factory(current_order);
        }
    }
}
