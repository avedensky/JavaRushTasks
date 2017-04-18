package com.javarush.task.task38.task3811;

/* 
Тикеты

Реализуй в отдельном файле аннотацию Ticket.

Требования к ней следующие:
1) Должна быть доступна во время выполнения программы.
2) Применяться может только к новым типам данных.
3) Должна содержать enum Priority c элементами LOW, MEDIUM, HIGH.
4) Приоритет будет задавать свойство priority — по умолчанию Priority.MEDIUM.
5) Свойство tags будет массивом строк и будет хранить теги связанные с тикетом.
6) Свойство createdBy будет строкой — по умолчанию Amigo.


Требования:
1. Аннотация Ticket должна быть доступна во время выполнения программы.
2. Аннотация Ticket должна применяться только к новым типам данных.
3. Аннотация Ticket должна содержать enum Priority c элементами LOW, MEDIUM, HIGH.
4. Аннотация Ticket должна содержать свойство priority - по умолчанию Priority.MEDIUM.
5. Аннотация Ticket должна содержать свойство tags - массив строк, пустой по умолчанию.
6. Аннотация Ticket должна содержать свойство createdBy - строку, равную "Amigo" по умолчанию.

*/

@Ticket (
        priority = Ticket.Priority.HIGH,
        createdBy = "Noodles",
        tags = {"bug","fix asap"}
)
public class Solution {
    public static void main(String[] args) {
        
    }
}
