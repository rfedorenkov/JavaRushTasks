package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;
import com.javarush.task.task39.task3913.query.UserQuery;

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
public class LogParser implements IPQuery, UserQuery {

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
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .map(Entity::getIp)
                .collect(Collectors.toSet());
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
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate(), after, before))
                .filter(entity -> entity.getName().equals(user))
                .map(Entity::getIp)
                .collect(Collectors.toSet());
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
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate(), after, before))
                .filter(entity -> entity.getEvent() == event)
                .map(Entity::getIp)
                .collect(Collectors.toSet());
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
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getStatus() == status)
                .map(Entity::getIp)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает всех пользователей.
     *
     * @return Пользователь
     */
    @Override
    public Set<String> getAllUsers() {
        return entityList.stream()
                .map(Entity::getName)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает количество уникальных пользователей.
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @return Количество уникальных пользователей.
     */
    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .map(Entity::getName)
                .collect(Collectors.toSet())
                .size();
    }

    /**
     * Метод возвращает количество уникальных событий от определенного пользователя.
     *
     * @param user   Пользователь.
     * @param after  Дата до.
     * @param before Дата после.
     * @return Количество уникальных событий от определенного пользователя.
     */
    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate(), after, before))
                .filter(entity -> entity.getName().equals(user))
                .map(Entity::getEvent)
                .collect(Collectors.toSet())
                .size();
    }

    /**
     * Метод возвращает пользователей с определенным IP.
     * Несколько пользователей могут использовать один и тот же IP.
     *
     * @param ip     IP адрес.
     * @param after  Дата до.
     * @param before Дата после.
     * @return Множество пользователей с определенным IP.
     */
    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate(), after, before))
                .filter(entity -> entity.getIp().equals(ip))
                .map(Entity::getName)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает пользователей, которые сделали Login.
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @return Множество пользователей, которые сделали Login.
     */
    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getEvent() == Event.LOGIN)
                .map(Entity::getName)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает пользователей, которые скачали плагин.
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @return Множество пользователей, которые скачали плагин.
     */
    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getEvent() == Event.DOWNLOAD_PLUGIN)
                .map(Entity::getName)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает пользователей, которые отправили сообщение.
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @return Множество пользователей, которые отправили сообщение.
     */
    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getEvent() == Event.WRITE_MESSAGE)
                .map(Entity::getName)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает пользователей, которые решали любую задачу.
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @return Множество пользователей, которые решали любую задачу.
     */
    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getEvent() == Event.SOLVE_TASK)
                .map(Entity::getName)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает пользователей, которые решали задачу с номером task.
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @param task   Номер задачи.
     * @return Множество пользователей, которые решали задачу с номером task.
     */
    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getEvent() == Event.SOLVE_TASK)
                .filter(entity -> entity.getTaskNumber() == task)
                .map(Entity::getName)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает пользователей, которые решили любую задачу.
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @return Множество пользователей, которые решили любую задачу.
     */
    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getEvent() == Event.DONE_TASK)
                .map(Entity::getName)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает пользователей, которые решили задачу с номером task.
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @param task   Номер задачи.
     * @return Множество пользователей, которые решили задачу с номером task.
     */
    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getEvent() == Event.DONE_TASK)
                .filter(entity -> entity.getTaskNumber() == task)
                .map(Entity::getName)
                .collect(Collectors.toSet());
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
        int taskNumber = 0;
        if (event.contains("DONE_TASK") || event.contains("SOLVE_TASK")) {
            String[] eventData = event.split(" ");
            event = eventData[0];
            taskNumber = Integer.parseInt(eventData[1]);
        }
        return new Entity(ip, name, date, Event.valueOf(event), Status.valueOf(split[4]), taskNumber);
    }

    public static class Entity {
        private final String ip;
        private final String name;
        private final Date getDate;
        private final Event event;
        private final Status status;
        private final int taskNumber;

        public Entity(String ip, String name, Date date, Event event, Status status, int taskNumber) {
            this.ip = ip;
            this.name = name;
            this.getDate = date;
            this.event = event;
            this.status = status;
            this.taskNumber = taskNumber;
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

        public int getTaskNumber() {
            return taskNumber;
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