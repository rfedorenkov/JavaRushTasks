package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("./4.JavaCollections/src/com/javarush/task/task39/task3913/logs"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        System.out.println(logParser.execute( "get ip for user = \"Vasya\""));

        System.out.println("===============DEFAULT==============");
        System.out.println(logParser.execute( "get ip"));
        System.out.println("===============USER==============");
        System.out.println(logParser.execute( "get ip for user = \"Amigo\""));
        System.out.println(logParser.execute( "get ip for date = \"03.01.2014 03:45:23\""));
        System.out.println(logParser.execute( "get ip for event = \"DONE_TASK\""));
        System.out.println(logParser.execute( "get ip for status = \"OK\""));
        System.out.println("===============DATE==============");
        System.out.println(logParser.execute( "get date for ip = \"127.0.0.1\""));
        System.out.println(logParser.execute( "get date for user = \"Amigo\""));
        System.out.println(logParser.execute( "get date for event = \"DONE_TASK\""));
        System.out.println(logParser.execute( "get date for status = \"OK\""));
        System.out.println("===============EVENT==============");
        System.out.println(logParser.execute( "get event for ip = \"127.0.0.1\""));
        System.out.println(logParser.execute( "get event for user = \"Amigo\""));
        System.out.println(logParser.execute( "get event for date = \"03.01.2014 03:45:23\""));
        System.out.println(logParser.execute( "get event for status = \"OK\""));
        System.out.println("===============STATUS==============");
        System.out.println(logParser.execute( "get status for ip = \"127.0.0.1\""));
        System.out.println(logParser.execute( "get status for user = \"Amigo\""));
        System.out.println(logParser.execute( "get status for date = \"03.01.2014 03:45:23\""));
        System.out.println(logParser.execute( "get status for event = \"DONE_TASK\""));
        System.out.println("===============FINAL==============");
        System.out.println(logParser.execute( "get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute( "get ip for user = \"Amigo\" and date between \"11.12.2010 0:00:00\" and \"03.01.2039 23:59:59\""));
    }
}