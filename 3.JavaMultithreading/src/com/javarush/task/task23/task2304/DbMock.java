package com.javarush.task.task23.task2304;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DbMock {
    private static final List<Solution.Task> FAKE_TASKS = new ArrayList<>();
    private static final List<String> FAKE_NAMES = new ArrayList<>();

    public static List<Solution.Task> getFakeTasks(Map criteria) {
        return ViewMock.getFakeTasksCriteria().equals(criteria) ? FAKE_TASKS : null;
    }

    public static List<String> getFakeNames(Map criteria) {
        return ViewMock.getFakeNamesCriteria().equals(criteria) ? FAKE_NAMES : null;
    }
}
