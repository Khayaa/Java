/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class1;
import java.util.*;
/**
 *
 * @author khaya
 */
public class Class1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        
        System.out.println(" Enter a sentance :");
        String str = in.nextLine();
        
        Class2 class2 = new Class2(str);
        class2.count_words(str);
        
    }
    
}
