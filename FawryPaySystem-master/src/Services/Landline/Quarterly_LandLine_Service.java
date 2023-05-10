package Services.Landline;

import Order_and_payment.Order;

import java.util.Scanner;

public class Quarterly_LandLine_Service extends Landline_Service{
    public Quarterly_LandLine_Service(Order current_order)
    {
        start_service_logic( current_order);
    }

    @Override
    public void start_service_logic(Order current_order) {
        Scanner sc=new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("Enter the landline number connected to the provider's LandLine: ");
        landline_number=sc.nextLong();
        System.out.println("Enter the the amount you want to recharge the Landline with: ");
        total_fees=sc.nextLong();
        System.out.println();

        current_order.total_fees=this.total_fees;
        current_order.service_name="Quarterly Landline Service";
        current_order.service_type="Landline";
    }
}
