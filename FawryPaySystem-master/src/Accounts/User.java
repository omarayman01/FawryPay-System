package Accounts;
import Services_Factory.*;
import Order_and_payment.*;
import java.util.*;

public class User extends Account {
    Vector<Order> orders;
    protected Order current_order;
    protected Payment payment;
    protected Payment_factory payment_factory;
    public Wallet wallet;

    public  User (String mail,String pass)
    {
        email=mail;
        password=pass;
        orders=new Vector<Order>();
        current_order=new Order(this);
        payment_factory=new Payment_factory();
        wallet=new Wallet();
    }


    public String get_mail() {
        return email;
    }

    public String get_password() {
        return password ;}

    public int show_options()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Select an option: ");
        System.out.println("-----------------------");
        System.out.println("1- Show available services");
        System.out.println("2- Search for service");
        System.out.println("3- request refund");
        System.out.println("4- add funds to wallet");
        System.out.println("5- show wallet balance");
        System.out.println("0- Exit to main menu to switch roles");
        int option=sc.nextInt();
        System.out.println();

        if (option==1)
        {
            select_services(current_order);
            return 1;
        }
        else if (option==2)
        {
            search();
            return 2;
        }
        else if (option==3)
        {
            request_refund();
            return 3;
        }

        else if (option==4)
        {
            wallet.add_to_balance();
            return 4;
        }
        else if (option==5)
        {
            wallet.showBalance();
            return 5;
        }
        else if (option==0) {
            return 0;
        }
        else
        {
            System.out.println("Select valid option");
            show_options();
        }
        return 0;
    }

    public void select_services(Order current_order)
    {
        Service_Factory service_factory;

        Scanner sc=new Scanner(System.in);
        System.out.println("Select a service: ");
        System.out.println("-----------------------");
        System.out.println("1- Mobile recharge service.");
        System.out.println("2- Internet recharge service");
        System.out.println("3- Donations.");
        System.out.println("4- Landline recharge service");

        int option=sc.nextInt();
        if (option==1)
        {
            Service_Factory service = new Mobile_service_Factory(current_order);
        }
        else if (option==2)
        {
            Service_Factory service = new Internet_service_Factory(current_order);
        }
        else if (option==3)
        {
            Service_Factory service = new Donation_service_Factory(current_order);
        }
        else if (option==4)
        {
            Service_Factory service = new Landline_service_Factory(current_order);
        }
        else
        {
            System.out.println("Select valid service");
            select_services(current_order);
        }

        //finishing order details before adding it to list of orders made by user.
        current_order.id=orders.size()+1;
        current_order.status="not_completed";


        //check_discount for order
        check_discount(current_order);

        //creating payment method
        payment=payment_factory.create_payment(current_order);

        if (payment.pay(current_order))
        {
            //adding the order to the orders list
            orders.add(new Order(current_order));
        }

    }
    public void search()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter service name: ");
        String input=sc.nextLine();
        input=input.toLowerCase();
        if (input.equals("donation"))
        {
            Service_Factory service = new Donation_service_Factory(current_order);
            
        } else if (input.equals("internet")) {
            Service_Factory service = new Internet_service_Factory(current_order);
        }
        else if (input.equals("mobile")) {
            Service_Factory service = new Mobile_service_Factory(current_order);
        } else if (input.equals("landline")) {
        Service_Factory service = new Landline_service_Factory(current_order);
        }
        else {
            System.out.println("Service not found.");
        }
    }

    public void request_refund()
    {
        if (orders.size()==0)
        {
            System.out.println("No Orders have been made to be refunded.");
            return;
        }
        System.out.println("Select order by id: ");
        System.out.println("--------------------------------");
        for (int i = 0; i < orders.size(); i++) {
            System.out.print(i+1+"-    ");
            orders.elementAt(i).print_order_details();
        }
        Scanner sc=new Scanner(System.in);
        int option=sc.nextInt();
        option-=1;
        Refund_Requests refund_requests=Refund_Requests.get_object();
        refund_requests.add_refund_request(orders.elementAt(option));
    }

    public void check_discount(Order order )
    {
        Discount discount=Discount.getInstance();
        discount.check_use_discount(order);
    }

    public double get_wallet_Balance()
    {
        return wallet.getBalance();
    }
}

