/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author HP
 */

    
    
    
    
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
abstract class Payment{
    protected int amount;
   public void pay(){
  }
}
class Paytm extends Payment{
    public Paytm(int amount){
        this.amount=amount;
    }
    public void pay(int amount){
        System.out.println(amount+" rs paid");
    } 
    public void pay(){
        System.out.println("payment successful via paytm");
    } 
}
class BhimUpi extends Payment{
    public BhimUpi(int amount){
        this.amount=amount;
    }
    public void pay(int amount){
        System.out.println(amount+" rs paid");
    } 
    public void pay(){
        System.out.println("payment successful via bhim upi");
    } 
}
class GooglePay extends Payment{
    public GooglePay(int amount){
        this.amount=amount;
    }
    public void pay(int amount){
        System.out.println(amount+" rs paid");
    } 
    public void pay(){
        System.out.println("payment successful via Google Pay");
    } 
}
class DebitCard extends Payment{
    public DebitCard(int amount){
        this.amount=amount;
    }
    public void pay(int amount){
        System.out.println(amount+" rs paid");
    } 
    public void pay(){
        System.out.println("payment successful via Debit Card ");
    } 
}
class CreditCard extends Payment{
    public CreditCard(int amount){
        this.amount=amount;
    }
    public void pay(int amount){
        System.out.println(amount+" rs paid");
    } 
    public void pay(){
        System.out.println("payment successful via Credit Card");
    } 
}
class NetBanking extends Payment{
    public NetBanking(int amount){
        this.amount=amount;
    }
    public void pay(int amount){
        System.out.println(amount+" rs paid");
    } 
    public void pay(){
        System.out.println("payment successful via Net Banking");
    } 
}

    
    
    
    
    
    
    
    
    
    

