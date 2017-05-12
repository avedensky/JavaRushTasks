package com.javarush.task.task23.task2304;

import java.util.HashMap;
import java.util.Map;

public class ViewMock {
    private static final Map FAKE_TASKS_CRITERIA = new HashMap();
    private static final Map FAKE_NAMES_CRITERIA = new HashMap();

    public static Map getFakeTasksCriteria() {
        return FAKE_TASKS_CRITERIA;
    }

    public static Map getFakeNamesCriteria() {
        return FAKE_NAMES_CRITERIA;
    }
}
