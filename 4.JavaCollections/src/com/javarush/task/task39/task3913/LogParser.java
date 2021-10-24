package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс читает лог-файл и отображает нужную информацию.
 */
public class LogParser implements IPQuery {

    private final List<Entity> entityList = new ArrayList<>();

    /**
     * Конструктор LogParser.
     *
     * @param logDir директория с логами (логов может быть несколько, все они должны иметь расширение log).
     */
    public LogParser(Path logDir) {
        init(logDir);
    }

    /**
     * Метод возвращает количество уникальных IP адресов за выбранный период.
     * Если after == null, то обрабатывается все записи у которых дата <= before.
     * Если before == null, то обрабатывается все записи у которых дата >= after.
     * Если after && before == null, то обрабатывается все записи.
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @return Количество уникальных IP адресов.
     */
    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    /**
     * Метод возвращает Set<String>, содержащее все не повторяющиеся IP.
     * Если after == null, то обрабатывается все записи у которых дата <= before.
     * Если before == null, то обрабатывается все записи у которых дата >= after.
     * Если after && before == null, то обрабатывается все записи.
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @return Множество IP адресов.
     */
    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (Entity entity : entityList) {
            if (filterDate(entity.getDate, after, before)) {
                set.add(entity.getIp());
            }
        }
        return set;
    }

    /**
     * Метод возвращает IP, с которых работал пользователь.
     * Если after == null, то обрабатывается все записи у которых дата <= before.
     * Если before == null, то обрабатывается все записи у которых дата >= after.
     * Если after && before == null, то обрабатывается все записи.
     *
     * @param user   Пользователь.
     * @param after  Дата до.
     * @param before Дата после.
     * @return Множество IP адресов с которых работал пользователь.
     */
    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (Entity entity : entityList) {
            if (entity.getName().equals(user)) {
                if (filterDate(entity.getDate(), after, before)) {
                    set.add(entity.getIp());
                }
            }
        }
        return set;
    }

    /**
     * Метод возвращает IP, с которых было произведено переданное событие.
     * Если after == null, то обрабатывается все записи у которых дата <= before.
     * Если before == null, то обрабатывается все записи у которых дата >= after.
     * Если after && before == null, то обрабатывается все записи.
     *
     * @param event  Событие.
     * @param after  Дата до.
     * @param before Дата после.
     * @return Множество IP адресов, с которых было произведено переданное событие.
     */
    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (Entity entity : entityList) {
            if (entity.getEvent() == event) {
                if (filterDate(entity.getDate(), after, before)) {
                    set.add(entity.getIp());
                }
            }
        }
        return set;
    }

    /**
     * Метод возвращает IP, события с которых закончилось переданным статусом.
     * Если after == null, то обрабатывается все записи у которых дата <= before.
     * Если before == null, то обрабатывается все записи у которых дата >= after.
     * Если after && before == null, то обрабатывается все записи.
     *
     * @param status Статус.
     * @param after  Дата до.
     * @param before Дата после.
     * @return Возвращает IP, события которых закончилось переданным статусом.
     */
    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (Entity entity : entityList) {
            if (entity.getStatus() == status) {
                if (filterDate(entity.getDate, after, before)) {
                    set.add(entity.getIp());
                }
            }
        }
        return set;
    }

    private void init(Path logDir) {
        List<String> logs = loadData(logDir);

        for (String log : logs) {
            entityList.add(createEntity(log));
        }

    }

    private List<String> loadData(Path logDir) {
        try {
            List<Path> collect = Files.list(logDir)
                    .filter(path -> path.toString().endsWith(".log"))
                    .collect(Collectors.toList());
            List<String> data = new ArrayList<>();
            for (Path path : collect) {
                data.addAll(Files.readAllLines(path));
            }
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Date parseStringForDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean filterDate(Date currentDate, Date after, Date before) {
        boolean isAfter = true;
        if (after != null) {
            isAfter = (currentDate.after(after) || currentDate.equals(after));
        }

        boolean isBefore = true;
        if (before != null) {
            isBefore = (currentDate.before(before) || currentDate.equals(before));
        }

        return isAfter && isBefore;
    }

    private Entity createEntity(String data) {
        String[] split = data.split("\t");
        String ip = split[0];
        String name = split[1];
        Date date = parseStringForDate(split[2]);
        String event = split[3];
        if (event.contains("DONE_TASK") || event.contains("SOLVE_TASK")) {
            event = event.split(" ")[0];
        }
        return new Entity(ip, name, date, Event.valueOf(event), Status.valueOf(split[4]));
    }

    public static class Entity {
        private final String ip;
        private final String name;
        private final Date getDate;
        private final Event event;
        private final Status status;

        public Entity(String ip, String name, Date date, Event event, Status status) {
            this.ip = ip;
            this.name = name;
            this.getDate = date;
            this.event = event;
            this.status = status;
        }

        public String getIp() {
            return ip;
        }

        public String getName() {
            return name;
        }

        public Date getDate() {
            return getDate;
        }

        public Event getEvent() {
            return event;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "Entity{" +
                    "ip='" + ip + '\'' +
                    ", name='" + name + '\'' +
                    ", date=" + getDate +
                    ", event=" + event +
                    ", status=" + status +
                    '}';
        }
    }
}