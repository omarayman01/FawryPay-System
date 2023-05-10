package Order_and_payment;
import Accounts.*;
import java.util.*;
public class Discount {
    private double first_time_discount_percent;
    private HashMap<String,Double> specific_discounts;
    private static Discount current_discount = new Discount();

    //applying Singleton pattern.
    private Discount(){
        first_time_discount_percent=0;
        specific_discounts=new HashMap<String, Double>();
    }

    public static Discount getInstance()
    {
        if (current_discount==null)
            current_discount = new Discount();
        return current_discount;
    }



    //user specific
    public void check_use_discount(Order current_order)
    {
        boolean flag=false;
        //first
        if (current_order.id==1 && first_time_discount_percent!=0)
        {
            System.out.println(first_time_discount_percent+"% discount has been added on your first order.");
            current_order.total_fees-=(current_order.total_fees*(first_time_discount_percent/100.0));
            flag=true;
        }

        if (specific_discounts.containsKey(current_order.service_type))
        {
            double specific_discount=specific_discounts.get(current_order.service_type);
            System.out.println(specific_discount+"% discount has been added on your"+ current_order.service_name +" order.");
            current_order.total_fees-=(current_order.total_fees*(specific_discount/100.0));
            flag=true;
        }

        if (flag==true)
        {
            System.out.println("Total cost after applying discount: "+current_order.total_fees);
            System.out.println();
        }


    }

    //admin specific
    public void add_specific_discount(String service_name,double discount_value)
    {
        specific_discounts.put(service_name,discount_value);
        System.out.println("you added a discount of "+discount_value+"% to "+service_name+" Service");
    }
    
    //admin specific
    public void add_first_time_discount(double discount_precent)
    {
        first_time_discount_percent=discount_precent;
        System.out.println("you added a discount of "+discount_precent+"% to first time orders.");
    }

}
