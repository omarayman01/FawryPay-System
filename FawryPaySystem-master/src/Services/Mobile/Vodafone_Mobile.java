package Services.Mobile;

import Order_and_payment.Order;

import java.util.Scanner;

public class Vodafone_Mobile extends Mobile_service {

    public Vodafone_Mobile(Order current_order)
    {
        start_service_logic( current_order);
    }

    @Override
    public void start_service_logic(Order current_order) {
        Scanner sc=new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("Enter the Mobile number connected to the provider's Mobile recharge: ");
        phone_number=sc.nextLong();
        System.out.println("Enter the the amount you want to recharge the Mobile with: ");
        total_fees=sc.nextLong();
        System.out.println("Thank you for using Vodafone.");
        System.out.println();

        current_order.total_fees=this.total_fees;
        current_order.service_name="Vodafone Mobile";
        current_order.service_type="Mobile";
    }
}
