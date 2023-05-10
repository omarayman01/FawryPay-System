package Order_and_payment;

import java.util.*;

public class Payment_factory {

    public Payment create_payment(Order user_order)
    {
        if(Objects.equals(user_order.service_type, "Donation"))
        {
            System.out.println("Select one of the following payment methods");
            System.out.println("-------------------------------------------");
            System.out.println("1- Credit card payment");
            System.out.println("2- Wallet payment");

            Scanner sc=new Scanner(System.in);
            int option= sc.nextInt();

            if (option>2)
                create_payment(user_order);

            return select_option(option);
        }
        else
        {
            System.out.println("Select one of the following payment methods");
            System.out.println("-------------------------------------------");
            System.out.println("1- Credit card payment");
            System.out.println("2- Wallet payment");
            System.out.println("3- Cash");

            Scanner sc=new Scanner(System.in);
            int option= sc.nextInt();

            if (option>3)
                create_payment(user_order);

            return select_option(option);
        }

    }

    private Payment select_option(int choice)
    {
        if (choice==1)
        {
            return new Credit_Card_payment();
        }
        else if (choice==2)
        {
            return new Wallet_Payment();
        }
        else
        {
            return new Cash_Payment();
        }

    }
}
