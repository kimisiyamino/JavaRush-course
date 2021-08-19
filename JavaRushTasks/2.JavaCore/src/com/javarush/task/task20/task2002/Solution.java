package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            //File yourFile = new File("D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2002\\info");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            User user1 = new User();
            user1.setFirstName("{Ann}");
            user1.setLastName("Break");
            user1.setBirthDate(new Date(2000, 10, 3));
            user1.setMale(false);
            user1.setCountry(User.Country.UKRAINE);

            User user2 = new User();
            user2.setFirstName("Andry");
            user2.setLastName("Lol");
            user2.setBirthDate(new Date(2010, 5, 30));
            user2.setMale(true);
            user2.setCountry(User.Country.RUSSIA);

            User user3 = new User();

            User user4 = new User();
            user4.setFirstName("Алекс");
            user4.setLastName("");
            user4.setMale(true);

            JavaRush javaRush = new JavaRush();
            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.users.add(user3);
            javaRush.users.add(user4);

            javaRush.save(outputStream);


            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println(javaRush.users.toString());
            System.out.println(loadedObject.users.toString());
            System.out.println(javaRush.equals(loadedObject));


            outputStream.flush();
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            if(!users.isEmpty()){
                for (User user : users) {
                    String nullS = "null";
                    String emptyS = "[]";

                    String firstName = user.getFirstName();
                    String lastName = user.getLastName();
                    Date date = user.getBirthDate();
                    String birthday;
                    boolean gender = user.isMale();
                    User.Country country = user.getCountry();
                    String countryS;

                    if (firstName == null) {
                        firstName = nullS;
                    } else if (firstName.equals("")) {
                        firstName = emptyS;
                    }

                    if (lastName == null) {
                        lastName = nullS;
                    } else if (lastName.equals("")) {
                        lastName = emptyS;
                    }

                    if (date == null) {
                        birthday = nullS;
                    } else {
                        long birth = date.getTime();
                        birthday = Long.toString(birth);
                    }

                    if (country == null) {
                        countryS = nullS;
                    } else {
                        countryS = country.getDisplayName();
                    }

                    bufferedWriter.write(firstName + ' ' + lastName + ' ' + birthday + ' ' + gender + ' ' + countryS + System.lineSeparator());
                }
            }

            bufferedWriter.flush();
            bufferedWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            users = new ArrayList<>();

            if(true) {
                while (bufferedReader.ready()) {
                    String[] userData = bufferedReader.readLine().split(" ");
                    User user = new User();

                    String firstName;
                    String lastName;
                    Date birthDate;
                    boolean isMale;
                    User.Country country;

                    if(userData[0].equals("null")){
                        firstName = null;
                    }else if(userData[0].equals("[]")){
                        firstName = "";
                    }else{
                        firstName = userData[0];
                    }

                    if(userData[1].equals("null")){
                        lastName = null;
                    }else if(userData[1].equals("[]")){
                        lastName = "";
                    }else{
                        lastName = userData[1];
                    }

                    if(userData[2].equals("null")){
                        birthDate = null;
                    }else{
                        birthDate = new Date(Long.parseLong(userData[2]));
                    }

                    isMale = userData[3].equals("true");

                    switch (userData[4]){
                        case "Russia": country = User.Country.RUSSIA; break;
                        case "Ukraine": country = User.Country.UKRAINE; break;
                        case "Other": country = User.Country.OTHER; break;
                        default: country = null; break;
                    }

                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setBirthDate(birthDate);
                    user.setMale(isMale);
                    user.setCountry(country);
                    users.add(user);
                }
            }

            bufferedReader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof JavaRush)) return false;
            JavaRush javaRush = (JavaRush) o;
            return Objects.equals(users, javaRush.users);
        }

        @Override
        public int hashCode() {
            return Objects.hash(users);
        }
    }
}