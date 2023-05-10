package Order_and_payment;

import java.util.Scanner;

public class Wallet {
    private double balance;
    public Wallet()
    {
        balance=0;
    }

    public void showBalance()
    {
        System.out.println("Your wallet balance currently is: "+balance);
    }

    public double getBalance()
    {
        return balance;
    }

    public void deduce_from_balance(double cost)
    {
        balance-=cost;
    }

    public void add_to_balance()
    {
        Credit_Card_payment payment=new Credit_Card_payment();
        System.out.println("Enter how much you want to add to your wallet using credit card:");
        Scanner sc=new Scanner(System.in);
        double cost=sc.nextDouble();
        payment.add_to_wallet(cost);
        balance+=cost;

    }

    public void refund_to_balance(double refunded)
    {
        balance+=refunded;

    }
}
