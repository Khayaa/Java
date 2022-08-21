/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classa;
import java.util.*;
/**
 *
 * @author khaya
 */
public class ClassA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        Classb classb = new Classb();
        double Investmentamount  = 0 , interestrate = 0;
        int years = 0;
        
        System.out.print(" Input the Investment Amount : ");
        Investmentamount = in.nextDouble();
        System.out.print(" Input the rate of Interest : ");
        interestrate = in.nextDouble();
        System.out.print(" Input the Number of Years : ");
        years = in.nextInt();
        classb.FutureInvestmentValue(Investmentamount, interestrate, years);
    }
    
}
