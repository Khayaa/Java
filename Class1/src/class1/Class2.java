/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class1;

/**
 *
 * @author khaya
 */
public class Class2 {
    String str;
    public Class2(String str){
    this.str = str;
  }  
    public void count_words(String str){
     this.str = str;
    String s [] = str.split(" ");
    System.out.println(" There are  " + s.length  + " word/s in the Above Sentance ");
    }
    }
