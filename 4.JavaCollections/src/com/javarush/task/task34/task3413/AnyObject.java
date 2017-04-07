package com.javarush.task.task34.task3413;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AnyObject {

    private Long id;
    private String name;
    private Calendar creationTime = new GregorianCalendar();
    private String additionalDescription;

    public AnyObject(Long id, String name, String additionalDescription) {
        this.id = id;
        if (name != null) {
            this.name = name;
        } else {
            this.name = "AnyObject#" + id;
        }
        if (additionalDescription != null) {
            this.additionalDescription = additionalDescription;
        } else {
            this.additionalDescription = "This is object #" + id;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnyObject that = (AnyObject) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        return creationTime.equals(that.creationTime);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + creationTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AnyObject{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", creationTime = " + creationTime.getTime() +
                ", additionalDescription = '" + additionalDescription + '\'' +
                '}';
    }
}