package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush

Реализуйте логику записи в файл и чтения из файла для класса JavaRush.
В файле your_file_name.tmp может быть несколько объектов JavaRush.
Метод main реализован только для вас и не участвует в тестировании.

*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);
            File your_file_name = new File("d:\\5.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User usr = new User();
            usr.setFirstName("Ivan");
            usr.setLastName("Ivanov");
            usr.setBirthDate(new GregorianCalendar(1980, 11, 25).getTime());
            usr.setCountry(User.Country.RUSSIA);
            usr.setMale(true);

            javaRush.users.add(usr);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            DataOutputStream outToFile = new DataOutputStream(outputStream);

            outToFile.writeInt(users.size());
            for (User user : users) {
                /*String firstName = usr.getFirstName() != null ? usr.getFirstName() : "null";
                String lastName = usr.getLastName() != null ? usr.getLastName() : "null";
                String birthDate = usr.getBirthDate() != null ? dateFormat.format(usr.getBirthDate()) : "null";
                String country = usr.getCountry() != null ? usr.getCountry().toString() : "null";
                String sex = usr.isMale() == true ? "male" : "female";

                outToFile.write(firstName + "\r\n");
                outToFile.write(lastName + "\r\n");
                outToFile.write(birthDate + "\r\n");
                outToFile.write(country + "\r\n");
                outToFile.write(usr.getCountry().toString() + "\r\n");
                outToFile.write(sex + "\r\n");*/                
                
                String firstName = (user.getFirstName() == null) ? "null" : user.getFirstName();
                outToFile.writeUTF(firstName);
                String lastName = (user.getLastName() == null) ? "null" : user.getLastName();
                outToFile.writeUTF(lastName);
                outToFile.writeLong(user.getBirthDate().getTime());
                outToFile.writeBoolean(user.isMale());
                outToFile.writeUTF(user.getCountry().name());
            }
            outToFile.flush();
        }


    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
//        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        DataInputStream fromFile = new DataInputStream(inputStream);
//        users.clear();

        int usersCount = fromFile.readInt();
        for (int i = 0; i < usersCount; i++) {
            /*
            String firstName = fromFile.readLine();
            String lastName = fromFile.readLine();
            String birthDate = fromFile.readLine();
            String country = fromFile.readLine();
            String sex = fromFile.readLine();

            User usr = new User();
            usr.setFirstName(firstName);
            usr.setLastName(lastName);
            usr.setBirthDate(birthDate.equals("null") ? null :  dateFormat.parse(birthDate));
            usr.setCountry(country.equals("null") ? null: User.Country.valueOf(country));
            usr.setMale(sex.equals("male") ? true : false);*/
            
            User user = new User();

            String firstName = fromFile.readUTF();
            if (firstName.equals("null")) firstName = null;
            user.setFirstName(firstName);
            String lastName = fromFile.readUTF();
            if (lastName.equals("null")) lastName = null;
            user.setLastName(lastName);
            user.setBirthDate(new Date(fromFile.readLong()));
            user.setMale(fromFile.readBoolean());
            user.setCountry(User.Country.valueOf(fromFile.readUTF()));

            users.add(user);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JavaRush javaRush = (JavaRush) o;

        return users != null ? users.equals(javaRush.users) : javaRush.users == null;

    }

    @Override
    public int hashCode() {
        return users != null ? users.hashCode() : 0;
    }
}
}
