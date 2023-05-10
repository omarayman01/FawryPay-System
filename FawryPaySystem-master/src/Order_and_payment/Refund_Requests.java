package Order_and_payment;
import java.util.*;
public class Refund_Requests {
    private static Refund_Requests obj; 
    Vector<Order> refund_requests;

    // private constructor to force use of
    // getInstance() to create Singleton object
    private Refund_Requests() {
        refund_requests=new Vector<Order>();
    }

    public static Refund_Requests get_object()
    {
        if (obj==null)
            obj = new Refund_Requests();
        return obj;
    }

    public void print_requests() {
        for (int i = 0; i < refund_requests.size(); i++) {
            System.out.print(i+1+"-    ");
            refund_requests.elementAt(i).print_order_details();
        }
    }
    public void add_refund_request(Order requested_order)
    {
        requested_order.status="Refund Requested";
        refund_requests.add(new Order(requested_order));
        System.out.println("your order refund request now is waiting for admin's approval");
    }
    
    public void select_refund_order_request()
    {
        print_requests();
        if (refund_requests.size()==0)
        {
            System.out.println("No refund requests exist at this moment.");
            return;
        }
        Scanner sc=new Scanner(System.in);
        int index=sc.nextInt();
        index-=1;



        System.out.println("Select which action to perform:");
        System.out.println("----------------------------------");
        System.out.println("1- Accept refund \n2- Decline refund");
        int choice=sc.nextInt();
        Order current_order=refund_requests.elementAt(index);
        if (choice==1)
        {
            current_order.user.wallet.refund_to_balance(current_order.total_fees);
            current_order.status="Refunded";
            refund_requests.remove(current_order);
            System.out.println("Order refund request is accepted for user: "+current_order.user.get_mail()+", "+current_order.total_fees+" has been refunded to the user's wallet.");
        }
        else if (choice==2)
        {
            current_order.status="Completed";
            refund_requests.remove(current_order);
            System.out.println("Refund request has been declined.");
            System.out.println();
        }


    }
   

}
