package Accounts;

import Order_and_payment.Discount;
import Order_and_payment.Refund_Requests;

import java.util.Scanner;

public class Admin extends Account {

    public Admin (String mail,String pass)
    {
        email=mail;
        password=pass;
    }

    public int show_options()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Select an option: ");
        System.out.println("-----------------------");
        System.out.println("1- Add discount specific to service.");
        System.out.println("2- Add first order discount percentage.");
        System.out.println("3- show refund requests.");
        System.out.println("0- Exit to main menu to switch roles");
        int option=sc.nextInt();
        System.out.println();

        if (option==1)
        {
            add_specific_discount();
            return 1;
        }
        else if (option==2)
        {
            add_first_time_discount();
            return 2;
        }
        else if (option==3)
        {
            show_refund_requests();
            return 3;
        }
        else if (option==0)
        {
            return 0;
        }
        else
        {
            System.out.println("Select valid option");
            show_options();
        }
        return 0;
    }

    public void add_specific_discount() {

        Scanner sc=new Scanner(System.in);
        Discount discount = Discount.getInstance();

        System.out.println("Choose Service to add Discount:");
        System.out.println("-----------------------");
        System.out.println("1- Donation");
        System.out.println("2- Internet");
        System.out.println("3- Mobile");
        System.out.println("4- Landline");

        int service = sc.nextInt();
        String service_type ="";
        if (service==1)
        {
            service_type ="Donation";
        }
        else if (service==2)
        {
            service_type ="Internet";
        }
        else if (service==3) {

            service_type ="Mobile";
        }
        else if (service==4)
        {
            service_type ="Landline";
        }

        System.out.println("Add Discount percentage:");
        double discount_value=sc.nextDouble();

        discount.add_specific_discount(service_type,discount_value);
    }

    public void add_first_time_discount() {

        Scanner sc=new Scanner(System.in);
        Discount discount = Discount.getInstance();
        System.out.println("Enter discount percentage: ");
        double overallDiscount = sc.nextDouble();
        discount.add_first_time_discount(overallDiscount);

    }

    public void show_refund_requests()
    {
        Refund_Requests requests=Refund_Requests.get_object();
        requests.select_refund_order_request();
    }


    public String get_mail() {
        return email;
    }

    public String get_password() {
        return password ;
    }
}
