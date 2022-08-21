/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pentagonal_numbers;

/**
 *
 * @author khaya
 */
public class Pentagonal_Numbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     getPentagonalNumber();   
    }
    public static void getPentagonalNumber(){
    final int numberofpentagonsperline = 10;
        int pen = 0;
    for(int i = 1; i <= 40; i++){
        
        pen = i * ((3 * i) - 1) / 2 ;
        if(i % numberofpentagonsperline == 0){
        System.out.printf("%-4d \n\n" , pen);
        }else{
        System.out.printf("%-4d   " , pen );
        }
        
    }
    
    }
    
}
