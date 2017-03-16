package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* 
CRUD 2

CrUD Batch — multiple Creation, Updates, Deletion

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

Значения параметров:
name — имя, String
sex — пол, «м» или «ж», одна буква
bd — дата рождения в следующем формате 15/04/1990
-с — добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u — обновляет соответствующие данные людей с заданными id
-d — производит логическое удаление человека с id, заменяет все его данные на null
-i — выводит на экран информацию о всех людях с заданными id: name sex bd
id соответствует индексу в списке

Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример вывода для параметра -і с двумя id:
Миронов м 15-Apr-1990
Миронова ж 25-Apr-1997
*/

//For Test
//-c Миронов м 15/04/1990 Чайковская ж 25/01/1991 Бормолеев м 10/03/2001
//-u 0 Бормолеев м 10/03/2001 1 Чайковская ж 25/01/1991
//-d 0 1
//-i 0 1
public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        DateFormat dateFormatPrt = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        switch (args[0]) {

            //create person
            case "-c":
                for (int step = 1; step < args.length; step += 3) {
                    Date date = null;
                    try {
                        date = dateFormat.parse(args[step + 2]);
                    } catch (ParseException e) {
                        e.getMessage();
                    }

                    //VALIDATOR: При запуске программы с параметром -с программа должна добавлять человека с заданными
                    // параметрами в конец списка allPeople, и выводить id (index) на экран.
                    Person person;
                    if (args[step + 1].startsWith("м"))
                        person = Person.createMale(args[step], date);
                    else
                        person = Person.createFemale(args[step], date);

                    synchronized (allPeople) {
                        allPeople.add(person);
                    }

                    System.out.println(allPeople.indexOf(person));
                }
                break;

            //update person
            case "-u": {
                synchronized (allPeople) {
                    for (int step = 1; step < args.length; step += 4) {
                        int index = Integer.parseInt(args[step]);
                        Person person = allPeople.get(index);

                        //update name
                        person.setName(args[step + 1]);

                        //udate date
                        Date date = null;
                        try {
                            date = dateFormat.parse(args[step + 3]);
                        } catch (ParseException e) {
                            e.getMessage();
                        }
                        person.setBirthDay(date);

                        //update sex
                        if (args[step + 2].startsWith("м"))
                            person.setSex(Sex.MALE);
                        else
                            person.setSex(Sex.FEMALE);
                    }
                } //synchronized
                break;
            }

            //remove person
            case "-d": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int index = Integer.parseInt(args[i]);
                        Person person = allPeople.get(index);

                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDay(null);
                    }
                }
                break;
            }

            //print person
            case "-i": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int index = Integer.parseInt(args[i]);
                        Person person = allPeople.get(index);
                        StringBuffer s = new StringBuffer();
                        s.append(person.getName());
                        s.append(" ");
                        s.append(person.getSex() == Sex.MALE ? "м" : "ж");
                        s.append(" ");
                        s.append(dateFormatPrt.format(person.getBirthDay()));
                        System.out.println(s);
                    }
                }
            }
            break;
        }

        //For DEBUG
        /*for (Person person : allPeople) {
            StringBuffer s = new StringBuffer();
            s.append(person.getName());
            s.append(" ");
            s.append(person.getSex() == Sex.MALE ? "м" : "ж");
            s.append(" ");
            if (person.getBirthDay()!=null)
                s.append(dateFormatPrt.format(person.getBirthDay()));
            System.out.println(s);
        }*/

    }
}
