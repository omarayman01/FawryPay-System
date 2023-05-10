package Order_and_payment;

public class Cash_Payment implements Payment{
    @Override
    public boolean pay(Order user_order) {
        System.out.println("you have chosen paying to pay with cash, Thank you.");
        user_order.status="Completed";
        return true;
    }
}
