package com.javarush.task.task20.task2002;

import java.io.*;
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
            System.exit(0);

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
            Writer out = new OutputStreamWriter (outputStream, "UTF8");

            for (User usr : users) {
                out.write(usr.getFirstName()+"\r\n");
                out.write(usr.getLastName()+"\r\n");
                out.write(usr.getBirthDate().toString()+"\r\n");
                out.write(usr.getCountry().toString()+"\r\n");
                out.write((usr.isMale()==true ? "male" : "female")+"\r\n");
            }
            out.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
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
