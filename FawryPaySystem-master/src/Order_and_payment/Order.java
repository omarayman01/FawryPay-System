package Order_and_payment;
import Accounts.User;
import java.util.*;


public class Order {
    public User user;
    public double total_fees;
    public int id;
    public String service_name;
    public String service_type;

    public String status;


    public Order()
    {
        total_fees=0;
        this.service_name="";
        id=0;
        status="";
        service_type="";
    }

    public Order(Order copy)
    {
        total_fees=copy.total_fees;
        this.service_name=copy.service_name;
        id=copy.id;
        status=copy.status;
        service_type=copy.service_type;
        user=copy.user;
    }

    public Order(User user1)
    {
        total_fees=0;
        this.service_name="";
        id=0;
        status="";
        service_type="";
        user=user1;
    }

    public Order(long fees,String service_name)
    {
        total_fees=fees;
        this.service_name=service_name;
        id=0;
        status="";
        service_type="";
    }

    public void print_order_details()
    {
        System.out.println("Order ID: "+id+", service: "+service_name+", total_cost: "+total_fees+", status: "+status);
        System.out.println();
    }
}
