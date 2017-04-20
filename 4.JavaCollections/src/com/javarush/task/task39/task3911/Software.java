package com.javarush.task.task39.task3911;

import java.util.*;
/*

Необходимо реализовать метод rollback в классе Software, который будет позволять
откатить текущую версию ПО на желаемую. Все версии следующие после той, на которую откатываемся,
должны быть удалены, также не забудь изменить поле currentVersion.
Метод rollback должен вернуть true, если все прошло успешно и false, если желаемая версия не была найдена.


Требования:
1. Метод rollback должен возвращать false, если желаемая версия не была найдена в versionHistoryMap.
2. Метод rollback должен удалять из versionHistoryMap только версии ПО, следующие за той, которую
передали в качестве параметра.
3. Метод rollback должен устанавливать currentVersion в соответствие с новым значением и возвращать
true в случае успешного отката.
4. Метод rollback не должен изменять currentVersion и versionHistoryMap, если откат невозможен.

*/
public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        if (!versionHistoryMap.containsKey(rollbackVersion))
            return false;

        Iterator<Integer> iterator = versionHistoryMap.keySet().iterator();
        while (iterator.hasNext())
            if (iterator.next()>rollbackVersion)
                iterator.remove();

        currentVersion = rollbackVersion;

        return true;
    }
}
