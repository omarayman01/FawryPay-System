package Services.Internet;

import Order_and_payment.Order;

import java.util.Scanner;

public class Orange_Internet extends Internet_Service{

    public Orange_Internet(Order current_order)
    {
        start_service_logic( current_order);
    }

    @Override
    public void start_service_logic(Order current_order) {
        Scanner sc=new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("Enter the landline number connected to the provider's internet: ");
        landline_number=sc.nextLong();
        System.out.println("Enter the the amount you want to recharge the internet with: ");
        total_fees=sc.nextLong();
        System.out.println("Thank you for using  Orange Service.");
        System.out.println();

        current_order.total_fees=this.total_fees;
        current_order.service_name="Orange Internet";
        current_order.service_type="Internet";

    }
}
