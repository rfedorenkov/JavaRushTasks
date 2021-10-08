package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * Комментарий внутри xml
 * Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
 * В строке перед каждым тегом tagName должен быть вставлен комментарий comment.
 * Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.
 *
 * Пример вызова:
 * toXmlWithComment(firstSecondObject, "second", "it's a comment")
 *
 * Пример результата:
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
 * <first>
 * <!--it's a comment-->
 * <second>some string</second>
 * <!--it's a comment-->
 * <second>some string</second>
 * <!--it's a comment-->
 * <second><![CDATA[need CDATA because of < and >]]></second>
 * <!--it's a comment-->
 * <second/>
 * </first>
 *
 *
 * Requirements:
 * 1. Метод toXmlWithComment должен быть статическим.
 * 2. Метод toXmlWithComment должен быть публичным.
 * 3. Если во входящем xml отсутствует искомый тег, то добавлять комментарии не нужно.
 * 4. Количество комментариев вставленных в xml должно быть равно количеству тегов tagName.
 * 5. Метод toXmlWithComment должен возвращать xml в виде строки преобразованной в соответствии с условием задачи.
*/
public class Solution {

    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj,writer);
        String[] mass = writer.toString().split("<" + tagName);
        StringBuilder result = new StringBuilder(mass[0].trim());
        if (mass.length > 1) {
            for (int i = 1; i < mass.length; i++) {
                result.append("\n<!--").append(comment).
                        append("-->\n").append("<").append(tagName).
                        append(mass[i].trim());
            }
        }
        return result.toString();
    }

    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(first.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object obj = unmarshaller.unmarshal(new File("/data.xml"));
        String tagName = "second";
        String comment = "it's a comment";
        String result = toXmlWithComment(obj, tagName, comment);
        System.out.println(result);
    }

    @XmlRootElement
    public static class first {
        public String[] second;

        public first() {
        }

        @Override
        public String toString() {
            return "first{" +
                    "second=" + Arrays.toString(second) +
                    '}';
        }
    }
}