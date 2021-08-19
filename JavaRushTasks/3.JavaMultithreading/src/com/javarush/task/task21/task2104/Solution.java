package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if(!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;

        boolean x, y;


        if(first == null){
            if(solution.first == null){
                x = true;
            }else{
                return false;
            }
        }else{
            if(first.equals(solution.first)){
                x = true;
            }else{
                return false;
            }
        }

        if(last == null){
            if(solution.last == null){
                y = true;
            }else{
                return false;
            }
        }else{
            if(last.equals(solution.last)){
                y = true;
            }else{
                return false;
            }
        }

        return true;
    }

    public int hashCode() {
        if(first != null && last != null)
            return 31 * first.hashCode() + last.hashCode();
        else
            return 31 * 31;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        s.add(new Solution("Donald", "Duck"));
        s.add(new Solution(null, "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
        System.out.println(s.contains(new Solution(null, "Duck")));
    }
}
