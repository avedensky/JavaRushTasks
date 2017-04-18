package com.javarush.task.task38.task3804;

class ExceptionFactory {
    public static Throwable getException(Enum type) {
        if (type == null)
            return new IllegalArgumentException();

        String message = type.name().charAt(0) + type.name().substring(1).toLowerCase().replace("_", " ");

        if (type instanceof ExceptionApplicationMessage)
            return new Exception(message);

        if (type instanceof ExceptionDBMessage)
            return new RuntimeException(message);

        if (type instanceof ExceptionUserMessage)
            return new Error(message);

        return new IllegalArgumentException();
    }
}
