package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human

Реализуй логику записи в файл и чтения из файла для класса Human.
Поле name в классе Human не может быть пустым.
Метод main реализован только для вас и не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = new File("d:\\5.txt");//File.createTempFile("d:\\5.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            if (ivanov==somePerson)
                System.out.println(true);

            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            Writer out = new OutputStreamWriter (outputStream, "UTF8");
            out.write(name+"\r\n");

            for (Asset item : assets)
                out.write(item.getName()+","+item.getPrice()+"\r\n");

            out.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

            if (in.ready())
                name = in.readLine();

            while (in.ready()) {
                String s = in.readLine();
                String[] strs = s.split(",");
                this.assets.add(new Asset(strs[0]));
            }
        }
    }
}
