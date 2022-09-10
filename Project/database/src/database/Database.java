/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityTransaction;
import org.eclipse.persistence.exceptions.TransactionException;

/**
 *
 * @author Fayrouz
 */
public class Database {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       EntityManagerFactory emp= Persistence.createEntityManagerFactory("databasePU");
       List<Car> allCars =emp.createEntityManager().createNamedQuery("Car.findAll").getResultList();
        //Query 1
            System.out.println("1.The serial number and the price of the Toyota corolla.");
            for(Car car: allCars){
                 if(car.getManufacture().equals("Toyota") && car.getModel().equals("Corolla"))
                     System.out.println("Serial No: "+car.getSerialNO()+"\t Price: "+car.getPrice());
             }
            System.out.println(" ---------------------------------- ");
            System.out.println();
        
        //Query 2
            System.out.println("2.The model and price of each car whose has price between 150000 and 250000.");
            for(Car car: allCars){
                if(car.getPrice()>150000 && car.getPrice()<250000)
                    System.out.println("Model : "+car.getModel()+"\t Price: "+car.getPrice());
            }
            System.out.println(" ---------------------------------- ");
            System.out.println();
            
        //Query 3
            System.out.println("3.The model, price, and price after adding 7% interest of all cars ordered from the most expensive car to the cheapest car.");
            double [] prices=new double[6];
            int []serials=new int[6];
            int i=0;
            for(Car car: allCars){
                prices[i]=car.getPrice()+car.getPrice()*0.07;
                serials[i]=car.getSerialNO();
                i++;
            }
            i--;
            for(;i>=0;i--){
                for(int j=i;j>=0;j--){
                    if(prices[i]>prices[j]){
                        double t=prices[i];
                        prices[i]=prices[j];
                        prices[j]=t;
                        int s=serials[i];
                        serials[i]=serials[j];
                        serials[j]=s;
                    }
                }
            }
            i=0;
            for(;i<prices.length;i++){
                for(Car car:allCars){
                    if(car.getSerialNO()==serials[i])
                        System.out.print(car.getModel()+"\t Before Interest "+car.getPrice());
                }

                System.out.println("\t After Interest "+prices[i]);
            }
            System.out.println(" ---------------------------------- ");
            System.out.println();
            
            
        //Query 4   Done as a view in DB
            
        //Query 5
            System.out.println("5.For each car model, display the total prices of its options.");
            List<Optioncar> opcar =emp.createEntityManager().createNamedQuery("Optioncar.findAll").getResultList();
             for(Car car:allCars)
              {
                  float sum=0;
                  for( Optioncar ocar:opcar)
                  {
                       if(car.getSerialNO()==ocar.getOptioncarPK().getCARserialNO())
                       {
                           sum+=ocar.getPrice();   
                       }
                   }
                  if(sum!=0)
                       System.out.println("Car Model : "+car.getModel()+"\tTotal Price\t"+sum);

            }
             System.out.println(" ---------------------------------- ");
             System.out.println();
        
        
        //Query 6
            System.out.println("6.the name and phone of salesperson whose name start with “s”.");
            List<Saleperson> allsaleperson =emp.createEntityManager().createNamedQuery("Saleperson.findAll").getResultList();
            for(Saleperson sp:allsaleperson){
                if(sp.getName().charAt(0)=='S')
                    System.out.println("Name : "+sp.getName()+"\t Phone : "+sp.getPhone());
            }
        
            System.out.println(" ---------------------------------- ");
            System.out.println();
            
            
        //Query 7
            System.out.println("7.the name of salesperson who has no phone.");
            List<Saleperson> saleperson =emp.createEntityManager().createNamedQuery("Saleperson.findByPhone").setParameter("phone", null).getResultList();
            for(Saleperson sp:allsaleperson){
                if(sp.getPhone()==null)
                    System.out.println("Name : "+sp.getName());

            }
            
            System.out.println(" ---------------------------------- ");
            System.out.println();
            
        //Query 8   Done as a view in the DB
        
        //Query 9
            System.out.println("9.The number of cars that he sold and summation of their prices for each person.");
            List<Saleperson> all1 =emp.createEntityManager().createNamedQuery("Saleperson.findAll").getResultList();
            List<Sale> all2 =emp.createEntityManager().createNamedQuery("Sale.findAll").getResultList();
            for(Saleperson t:all1){
                 int sumP =0, sum=0;
                 for(Sale s:all2){
                     if(s.getSalePK().getSalepersonId().equals(t.getId()))
                     {
                         sumP+=s.getSalePrice();
                         sum++;
                     }
                 }
                 System.out.println("Person id: "+t.getId()+"\t No. of cars: "+sum+"\t T.Price: "+sumP);
            }
            System.out.println(" ---------------------------------- ");
            System.out.println();
            
            
        //Query 10
            System.out.println("10.The details of the cheapest car:");
            for(Car car:allCars){
                if(car.getSerialNO()==serials[serials.length-1])
                    System.out.println("Model: "+car.getModel()+"\t SerialNo: "+car.getSerialNO()+"\t Manufacture: "+car.getManufacture()+"\t price: "+car.getPrice());
            }
            System.out.println(" ---------------------------------- ");
            System.out.println();
       
       }
      
}
    

