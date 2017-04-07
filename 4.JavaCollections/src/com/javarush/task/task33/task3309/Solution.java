package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.StringWriter;

/*
Комментарий внутри xml

Реализовать метод toXmlWithComment, который должен возвращать строку — xml представление объекта obj.
В строке перед каждым тегом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.

Пример вызова:
toXmlWithComment(firstSecondObject, «second», «it’s a comment»)

Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
<!--it's a comment-->
<second>some string</second>
<!--it's a comment-->
<second>some string</second>
<!--it's a comment-->
<second><![CDATA[need CDATA because of < and >]]></second>
<!--it's a comment-->
<second/>
</first>


Требования:
1. Количество комментариев вставленных в xml должно быть равно количеству тегов tagName.
2. Метод toXmlWithComment должен возвращать xml в виде строки преобразованной в соответствии с условием задачи.
3. Метод toXmlWithComment не должен изменять входящий xml в случае, если искомый тег отсутствует в нём.
4. Метод toXmlWithComment должен быть статическим.
5. Метод toXmlWithComment должен быть публичным.
*/

//Временное решение, которое не принимается. И.. здесь нужен обход всего DOM, и работа с узлами документа...
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        StringWriter writer = new StringWriter();
        String res = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, writer);

            String xml = writer.toString();

            if (xml.indexOf(tagName) > -1)
                res = xml.replace("<" + tagName + ">", "<!--" + comment + "-->\n" + "<" + tagName + ">");
            else
                res = xml;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
//        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><first><second>some string</second><second>some string</second><second><![CDATA[need CDATA because of < and >]]></second><second/></first>";
//
//        String comment = "it's a comment";
//        String tagName = "second";
//
//        String res = null;
//        if (s.indexOf(tagName) > -1)
//            res = s.replace("<" + tagName + ">", "<!--" + comment + "-->" + "<" + tagName + ">");
//
//        System.out.println(res);
    }
}
