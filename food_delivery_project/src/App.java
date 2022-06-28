/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author HP
 */

    /**
     * @param args the command line arguments
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



public class App{
    public static void main(String[] args) throws Exception {
        try{
        SqlUtil.connectDatabase();
        }
        catch(Exception e){
            System.out.println(e);
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("welcome to the portal");
        while(true){
        System.out.println("choose the given option");
        System.out.println("1. signup\n 2.login\n 3.exit");
        int check1=sc.nextInt();sc.nextLine();
        if(check1==1){
            System.out.println("enter your username :");
            String username=sc.nextLine();
            System.out.println("enter your phone number :");
            String phone_no=sc.nextLine();
            System.out.println("enter your Address :");
            String address=sc.nextLine();
            System.out.println("enter your password:");
            String password=sc.nextLine();
            String query="insert into login values("+"\""+username+"\""+","+"\""+phone_no+"\""+","+"\""+address+"\""+","+"\""+password+"\""+")";
            
            try{
            SqlUtil.insert(query);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        if(check1==2){
            System.out.println("enter your username :");
            String username=sc.nextLine();
            System.out.println("enter your password :");
            String password=sc.nextLine();
            String query="select * from login where username="+"\""+username+"\""+"and password="+"\""+password+"\"";
            ResultSet rs=SqlUtil.read(query);
            if(rs.next()){
                
                if(password.equals(rs.getString("password"))){
                System.out.println("welcome "+rs.getString("username"));

                int s_c=0;
                String address=rs.getString("address");
                String addQuery="select * from address where Address="+"\""+address+"\"";
                
                ResultSet rsadd=SqlUtil.read(addQuery);
                if(rsadd.next())
                s_c=rsadd.getInt("cordinate");
               


                System.out.println("select your city and procced");
                String query1="select * from city";
                ResultSet rs1=SqlUtil.read(query1);
                if(rs1.next()){
                    int i=1;
                    do{
                        System.out.println(i+". "+rs1.getString("city_name"));
                        i++;
                    }while(rs1.next());
                }
                int city_id=sc.nextInt();sc.nextLine();
               
                String query2="select * from restaurent where restaurent_id in (select restaurent_id from city_restaurent where city_id="+"\""+city_id+"\""+")";
                
                ResultSet rs2=SqlUtil.read(query2);
                System.out.println("select the restaurent and procced");
                if(rs2.next()){
                    int i=1;
                    do{
                        float res_cor=rs2.getInt("restaurent_cordinate");
                        double dist=Math.sqrt(s_c*s_c+res_cor*res_cor);
                        System.out.println(i+". "+rs2.getString("restaurent_name")+"       "+(int)dist*2+" minutes away");
                        i++;
                    }while(rs2.next());
                }
                int d_c=0;
                int restaurent_id=sc.nextInt();sc.nextLine();
                String resQuery="select * from restaurent where restaurent_id="+"\""+restaurent_id+"\"";
                ResultSet rsRes=SqlUtil.read(resQuery);
                if(rsRes.next())
                d_c=rsRes.getInt("restaurent_cordinate");
                String restaurent_name=rsRes.getString("restaurent_name");
                
                String query3="select * from item where item_id in (select item_id from restaurent_item where restaurent_id="+"\""+restaurent_id+"\""+")";
                ResultSet rs3=SqlUtil.read(query3);
                Map<Integer,String> items=new LinkedHashMap<Integer,String>();
                Map<Integer,Integer> prices=new LinkedHashMap<Integer,Integer>();
                System.out.println("Menu of "+restaurent_name+" restaurent");
                if(rs3.next()){
                    int i=1;
                    do{
                        System.out.println(i+". "+rs3.getString("item_name")+" "+rs3.getString("price")+" Rs");
                        items.put(i,rs3.getString("item_name"));
                        prices.put(i,rs3.getInt("price"));
                        i++;
                    }while(rs3.next());
                }
                Map<String,Integer> bill=new LinkedHashMap<String,Integer>();
                System.out.println("select the items that you want to purchase or add to your cart");
                int x=1;
                while(x!=2){
                    System.out.println("enter item number");
                int v=sc.nextInt();sc.nextLine();
                System.out.println("enter the quantity");
                int quant=sc.nextInt();sc.nextLine();
                bill.put(items.get(v),prices.get(v)*quant);
                System.out.println("do you want to add more \n 1.Yes\n 2.No");
                    x=sc.nextInt();sc.nextLine();
                    }
                System.out.println("your selected item are this");

                for (Map.Entry<String,Integer> entry : bill.entrySet())
                System.out.println(entry.getKey()+" "+entry.getValue()+" Rs");
                while(x!=3){
                    System.out.println("do you want to 1.add an item\n 2.delete an item\n 3.discard the order\n 4.process the order\n 5.add selected items to the wishlist\n 6.view wishlist\n");
                    int choice=sc.nextInt();sc.nextLine();
                    if(choice==1){
                        System.out.println("enter item number");
                    int v=sc.nextInt();sc.nextLine();
                    System.out.println("enter the quantity");
                    int quant=sc.nextInt();sc.nextLine();
                    bill.put(items.get(v),prices.get(v)*quant);
                    System.out.println(items.get(v)+" added to your cart successfully");
                    }
                    if(choice==2){
                        System.out.println("enter item name that you want to delete"); 
                        String item_name=sc.nextLine();
                        bill.remove(item_name);
                        System.out.println(item_name+" removed from your cart successfully");
                    }
                    if(choice==3){
                        System.out.println("your order discarded successfully");
                        System.exit(0);
                    }
                    if(choice==4){
                        
                        double dist=Math.sqrt(s_c*s_c+d_c*d_c);
                        System.out.println("your bill is like that:");
                       System.out.println("item name"+"   "+"item price");
                      for (Map.Entry<String,Integer> entry : bill.entrySet())
                      System.out.println(entry.getKey()+" "+entry.getValue());
                      System.out.println("the distance of the route is: "+dist+" KM");
                        int total_sum=0;
                        for (String key: bill.keySet())
                        total_sum+= bill.get(key);
                        if(total_sum<=100){
                            System.out.println("base bill is less than 100 --> cant proceed the order");
                            break;
                        }
                        if(dist>0 && dist<=5){
                            System.out.println("delivery charges 10");
                            total_sum+=10;
                        }
                        else if(dist>5 && dist<=10){
                            System.out.println("delivery charges 20");
                            total_sum+=20;
                        }
                        else{
                            System.out.println("delivery charges 50");
                            total_sum+=50;  
                        }
                        
                        System.out.println("The total amount inclusing delivery charge is: "+total_sum);
                        System.out.println("we have 2 promocodes SAVE50 and SAVE20 for your 1st order");
                        System.out.println("choose the promocode 1.SAVE50\n 2.SAVE20");
                        int p=sc.nextInt();sc.nextLine();
                        if(p==1)
                        total_sum+=-50;
                        else
                        total_sum+=-20;
                        System.out.println("The final amount after applying the promocode is: "+total_sum);
                        System.out.println("select the payment mode:\n 1.Paytm\n 2.googlePay\n 3.Bhim upi\n 4.Debit card\n 5.credit card\n 6.netbanking\n");
                        int paymode=sc.nextInt();sc.nextLine();

                        switch(paymode){
                            case 1: Paytm paytm=new Paytm(total_sum);
                            paytm.pay();
                            break;
                            case 2:  BhimUpi bhim=new BhimUpi(total_sum);
                            bhim.pay();
                            break;
                            case 3: GooglePay gpay=new GooglePay(total_sum);
                            gpay.pay();
                            break;
                            case 4:  DebitCard db=new DebitCard(total_sum);
                            db.pay();
                            break;
                            case 5: CreditCard cc=new CreditCard(total_sum);
                            cc.pay();
                            break;
                            case 6: NetBanking nb=new NetBanking(total_sum);
                            nb.pay();
                            break;
                           
                        }

                        System.out.println("want to track you order");
                        System.out.println("1.Yes\n 2.No");
                        int n=sc.nextInt();sc.nextLine();
                        if(n==1){
                            Date date1=new Date(); 
                            while(true){
                                Date date2=new Date();
                                long min=(date2.getTime()-date1.getTime())/(60*1000)%60;
                                System.out.println((int)(dist*2)-min+" min left");
                                System.out.println("want to track again");
                                System.out.println("1.yes\n 2.No\n");
                                int k=sc.nextInt();sc.nextLine();
                                if(k==1)
                                continue;
                                else
                                break;
                            }
                        }
                        else{

                        }
                        break;
                    }
                    if(choice==5){
                       for (Map.Entry<String,Integer> entry : bill.entrySet()){
                            String query4="insert into wishlist values("+"\""+entry.getKey()+"\""+")";
                            SqlUtil.insert(query4);
                       }
                       System.out.println("items added to wishlist successfully");
                    }
                    if(choice==6){
                            String query5="select * from wishlist";
                            System.out.println("your wishlist is shown below:");
                            ResultSet rs4=SqlUtil.read(query5);
                            if(rs4.next()){
                                int i=1;
                                do{
                                    System.out.println(i+" "+rs4.getString("items"));
                                    i++;
                                }while(rs4.next());
                            }
                    }
                    System.out.println("Current cart status is:");
                       System.out.println("item name"+" "+"item price");
                      for (Map.Entry<String,Integer> entry : bill.entrySet())
                      System.out.println(entry.getKey()+" "+entry.getValue()+" Rs");
                    
                     }    

                }
                else{
                    System.out.println("password do not match");  
                }
            }
        }
            
        if(check1==3){
            System.exit(0);
        }
    
      
        
      }
    } 
        
}
        


        
        
        
        
        
        
    
    

