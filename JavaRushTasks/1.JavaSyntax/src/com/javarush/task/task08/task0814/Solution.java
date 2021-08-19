package com.javarush.task.task08.task0814;                                                                                                                                                                                                                                                                                                            
                                                                                                                                                                                                                                                                                                            
import java.util.*;                                                                                                                                                                                                                                                                                                            
                                                                                                                                                                                                                                                                                                            
/*                                                                                                                                                                                                                                                                                                             
Больше 10? Вы нам не подходите                                                                                                                                                                                                                                                                                                            
*/                                                                                                                                                                                                                                                                                                            
                                                                                                                                                                                                                                                                                                            
public class Solution {                                                                                                                                                                                                                                                                                                            
    public static Set<Integer> createSet() {                                                                                                                                                                                                                                                                                                            
         Set<Integer> set = new HashSet<Integer>();                                                                                                                                                                                                                                                                                                         
         for(int i = 0; i < 20; i++){                                                                                                                                                                                                                                                          
             set.add(i);                                                                                                                                                                                                                                                          
         }   
         return set;                                                                                                                                                                                                                                                                                              
    }                                                                                                                                                                                                                                                                                                            
                                                                                                                                                                                                                                                                                                            
    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {                                                                                                                                                                                                                                                                                                            
          //ArrayList<Integer> list = new ArrayList<Integer>(set);
         // for(int i = 0; i < list.size(); i++){
          //    if(list.get(i) > 10) list.remove(i--);
        //  }

          Iterator<Integer> iterator = set.iterator();
          while (iterator.hasNext()){
              int x = iterator.next();
              if(x > 10) iterator.remove();
          }

         // Set<Integer> newSet = new HashSet<Integer>(list);
          return set;
    }                                                                                                                                                                                                                                                                                                            
                                                                                                                                                                                                                                                                                                            
    public static void main(String[] args) {
        //Set<Integer> set = createSet();
       // removeAllNumbersGreaterThan10(set);
        //System.out.println(set);
    }                                                                                                                                                                                                                                                                                                            
}