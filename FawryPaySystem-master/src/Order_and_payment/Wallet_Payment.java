package Order_and_payment;
import Accounts.*;
public class Wallet_Payment implements Payment{

    @Override
    public boolean pay(Order user_order) {

        if (user_order.total_fees>user_order.user.get_wallet_Balance())
        {
            System.out.println("Wallet balance is not sufficent, please try another payment method");
            Payment_factory payment_factory=new Payment_factory();
            payment_factory.create_payment(user_order);
        }
        else {
            System.out.println("You have successfully paid with your wallet balance. ");
            user_order.user.wallet.deduce_from_balance(user_order.total_fees);
            System.out.println("your current wallet balance is: "+user_order.user.get_wallet_Balance());
        }

        user_order.status="Completed";
        return true;
    }
}
