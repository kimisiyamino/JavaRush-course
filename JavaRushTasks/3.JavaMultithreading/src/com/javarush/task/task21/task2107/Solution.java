package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable {

    public static void main(String[] args) throws CloneNotSupportedException {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        clone = solution.clone();
        System.out.println(solution);
        System.out.println(clone);

        System.out.println(solution.users);
        System.out.println(clone.users);

    }

    @Override
    public String toString() {
        return "Solution{" +
                "users=" + users +
                '}';
    }

    public Solution clone(){
        Solution cloneSolution = new Solution();
        Map<String, User> cloneUsers = new LinkedHashMap<>();
        
        for(Map.Entry<String, User> map : this.users.entrySet()){
            User cloneUser = new User(map.getValue().age, map.getValue().name);
            cloneUsers.put(map.getKey(), cloneUser);

        }

        cloneSolution.users = cloneUsers;
        
        return cloneSolution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;

        return users.equals(solution.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    protected Map<String, User> users = new LinkedHashMap<>();


    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public User clone() {
            return new User(this.age, this.name);
        }

        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return age == user.age &&
                    name.equals(user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }
    }
}
