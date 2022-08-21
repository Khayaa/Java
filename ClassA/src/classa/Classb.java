/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classa;

/**
 *
 * @author khaya
 */
public class Classb{
 //private double investmentamount;
 //private double monthlyinterestrate;
 //private int years;
 double investmentamount;
 double monthlyinterestrate;
 int years;

// fiv Method
public void FutureInvestmentValue(double investmentamount , double monthlyinterestrate , int years){
this.investmentamount = investmentamount;
this.monthlyinterestrate = monthlyinterestrate;
this.years = years;
double fiv;
    System.out.printf(" %2s %2s" ," Years " , "Future Value \n");
    for(int i = 0; i < years; i++){
     fiv = investmentamount *  (Math.pow((1 +  (monthlyinterestrate / 100)) , ((i+ 1)))); 
     System.out.printf("  %2d        %5d \n", i + 1 , Math.round(fiv));
    }

    
} 
    public void count_Words(String str){

    }

/***
//Setters
public void Setinvestmentamount(double investmentamount){
this.investmentamount = investmentamount;
}

public void Setmonthlyinterestrate(double monthlyinterestrate){
this.monthlyinterestrate = monthlyinterestrate;
}

public void Setyears(int years){
this.years = years;
}

//Getters
public double getinvestmentamount(){
return this.investmentamount;
}
 
public double getmonthlyinterestrate(){
return this.monthlyinterestrate;
}

public  int getyears(){
return this.years;
}
**/
}
