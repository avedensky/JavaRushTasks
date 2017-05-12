package com.javarush.task.task23.task2308;

/* 
Рефакторинг, вложенные классы

Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.


Требования:
1. В классе Solution должен быть создан класс Constants содержащий строковые константы.
2. Класс Constants должен быть публичным.
3. Класс Constants должен быть объявлен с модификатором, запрещающим наследование от этого класса.
4. В классе Constants должна существовать константа SERVER_IS_NOT_ACCESSIBLE_FOR_NOW со значением "Server is not accessible for now.".
5. В классе Constants должна существовать константа USER_IS_NOT_AUTHORIZED со значением "User is not authorized.".
6. В классе Constants должна существовать константа USER_IS_BANNED со значением "User is banned.".
7. В классе Constants должна существовать константа ACCESS_IS_DENIED со значением "Access is denied.".
*/
public class Solution {
    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super("Server is not accessible for now.");
        }

        public ServerNotAccessibleException(Throwable cause) {
            super("Server is not accessible for now.", cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super("User is not authorized.");
        }

        public UnauthorizedUserException(Throwable cause) {
            super("User is not authorized.", cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super("User is banned.");
        }

        public BannedUserException(Throwable cause) {
            super("User is banned.", cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super("Access is denied.");
        }

        public RestrictionException(Throwable cause) {
            super("Access is denied.", cause);
        }
    }

    public static final class Constants {
        public static final String SERVER_IS_NOT_ACCESSIBLE_FOR_NOW = "Server is not accessible for now.";
        public static final String USER_IS_NOT_AUTHORIZED = "User is not authorized.";
        public static final String USER_IS_BANNED = "User is banned.";
        public static final String ACCESS_IS_DENIED = "Access is denied.";
    }

    public static void main(String[] args) {

    }
}
