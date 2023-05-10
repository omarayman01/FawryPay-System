package Services_Factory;
import Order_and_payment.Order;
import Services.Mobile.*;
import java.util.Scanner;

public class Mobile_service_Factory implements Service_Factory {

    public Mobile_service_Factory(Order current_order)
    {
        Mobile_service service;
        Scanner sc=new Scanner(System.in);
        System.out.println("Select your phone service provider : ");
        System.out.println("-----------------------");
        System.out.println("1- Vodafone.");
        System.out.println("2- WE.");
        System.out.println("3- Orange.");
        System.out.println("4- Etisalat.");
        int option=sc.nextInt();
        if(option==1)
        {
            service=new Vodafone_Mobile(current_order);
        }
        else if (option==2) {
            service=new We_Mobile(current_order);
        }
        else if (option==3) {
            service=new Orange_Mobile(current_order);
        }
        else if (option==4) {
            service=new Etisalat_Mobile(current_order);
        }
        else
        {
            System.out.println("Select valid option");
            new Mobile_service_Factory(current_order);
        }
    }
}
