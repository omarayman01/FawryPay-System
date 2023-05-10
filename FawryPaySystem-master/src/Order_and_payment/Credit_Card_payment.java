package Order_and_payment;

import java.util.Scanner;

public class Credit_Card_payment implements Payment{

    @Override
    public boolean pay(Order user_order) {
        //we don't require card number and ccv
        //as we can't verify if they are true or not and we can't process these information.

        System.out.println("you have chosen paying to pay with Credit Card, Thank you.");
        user_order.status="Completed";
        return true;
    }

    public void add_to_wallet(double cost) {

        //we don't require card number and ccv
        //as we can't verify if they are true or not and we can't process these information.
        System.out.println("you have successfully added "+cost+" to your wallet balance.");
    }
}
