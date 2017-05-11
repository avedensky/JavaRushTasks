package com.javarush.task.task39.task3913;

/**
 * Created by Alexey on 11.05.2017.
 */

//
//1.2.1. Метод getNumberOfUniqueIPs(Date after, Date before) должен возвращать количество уникальных IP адресов за выбранный период. Здесь и далее, если в методе есть параметры Date after и Date before, то нужно возвратить данные касающиеся только данного периода (включая даты after и before).
//Если параметр after равен null, то нужно обработать все записи, у которых дата меньше или равна before.
//Если параметр before равен null, то нужно обработать все записи, у которых дата больше или равна after.
//Если и after, и before равны null, то нужно обработать абсолютно все записи (без фильтрации по дате).
//1.2.2. Метод getUniqueIPs() должен возвращать множество, содержащее все не повторяющиеся IP. Тип в котором будем хранить IP будет String.
//1.2.3. Метод getIPsForUser() должен возвращать IP, с которых работал переданный пользователь.
//1.2.4. Метод getIPsForEvent() должен возвращать IP, с которых было произведено переданное событие.
//1.2.5. Метод getIPsForStatus() должен возвращать IP, события с которых закончилось переданным статусом.
//
//Реализацию метода main() можешь менять по своему усмотрению.
//
//Требования:
//1. В классе LogParser должен быть создан конструктор с одним параметром Path logDir.
//2. Класс LogParser должен поддерживать интерфейс IPQuery.
//3. Метод getNumberOfUniqueIPs(Date, Date) должен возвращать количество уникальных IP адресов за выбранный период.
//4. Метод getUniqueIPs(Date, Date) класса LogParser должен возвращать множество, содержащее все не повторяющиеся IP адреса за выбранный период.
//5. Метод getIPsForUser(String, Date, Date) класса LogParser должен возвращать IP адреса, с которых работал переданный пользователь за выбранный период.
//6. Метод getIPsForEvent(Event, Date, Date) класса LogParser должен возвращать IP адреса, с которых было произведено переданное событие за выбранный период.
//7. Метод getIPsForStatus(Status, Date, Date) класса LogParser должен возвращать IP адреса, события с которых закончилось переданным статусом за выбранный период.
//

import com.javarush.task.task39.task3913.query.IPQuery;

import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery {
    private List<String> linesList;


    public LogParser(Path logDir) {
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> uniqueIPs = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");

            addStringEntity(after, before, uniqueIPs, parts, 0);
        }
        return uniqueIPs;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> IPsForUser = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");

            if (user.equals(parts[1])) {
                addStringEntity(after, before, IPsForUser, parts, 0);
            }
        }
        return IPsForUser;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> IPsForEvent = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");

            if (event.toString().equals(parts[3].split(" ")[0])) {
                addStringEntity(after, before, IPsForEvent, parts, 0);
            }
        }
        return IPsForEvent;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> IPsForEvent = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");

            if (status.toString().equals(parts[4])) {
                addStringEntity(after, before, IPsForEvent, parts, 0);
            }
        }
        return IPsForEvent;
    }

    private void addStringEntity(Date after, Date before, Set<String> enteties, String[] parts, int part) {
        long lineDateTime = getDate(parts[2]).getTime();

        if (isCompatibleDate(lineDateTime, after, before)) {
            enteties.add(parts[part]);
        }
    }

    private Date getDate(String part) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date date = null;
        try {
            date = dateFormat.parse(part);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private boolean isCompatibleDate(long lineDateTime, Date after, Date before) {
        if (after == null && before == null) {
            return true;
        } else if (after == null) {
            if (lineDateTime <= before.getTime()) {
                return true;
            }
        } else if (before == null) {
            if (lineDateTime >= after.getTime()) {
                return true;
            }
        } else {
            if (lineDateTime >= after.getTime() && lineDateTime <= before.getTime()) {
                return true;
            }
        }
        return false;
    }

}