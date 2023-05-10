package Services;
import Accounts.*;
import Order_and_payment.*;
public abstract class Service {
    protected long total_fees;
    public abstract void start_service_logic(Order current_order);

}
