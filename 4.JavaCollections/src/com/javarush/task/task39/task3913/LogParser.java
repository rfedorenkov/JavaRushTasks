package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

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
public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {

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
     * Метод возвращает пользователей, которые сделали LOGIN.
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @return Множество пользователей, которые сделали LOGIN.
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

    /**
     * Метод возвращает даты, когда определенный пользователь произвел определенное событие.
     *
     * @param user   Пользователь.
     * @param event  Событие.
     * @param after  Дата до.
     * @param before Дата после.
     * @return Даты, когда пользователь произвел определенное событие.
     */
    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getName().equals(user))
                .filter(entity -> entity.getEvent() == event)
                .map(Entity::getDate)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает даты, когда любое событие не выполнилось (Status.FAILED).
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @return Даты, когда событие не выполнилось.
     */
    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getStatus() == Status.FAILED)
                .map(Entity::getDate)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает даты, когда любое событие закончилось ошибкой (Status.ERROR)
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @return Даты, когда событие завершилось ошибкой.
     */
    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getStatus() == Status.ERROR)
                .map(Entity::getDate)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает дату, когда пользователь выполнил LOGIN впервые за указанный период.
     * Если такой даты нет - null.
     *
     * @param user   Пользователь.
     * @param after  Дата до.
     * @param before Дата после.
     * @return Дата, когда пользователь выполнил LOGIN в указанный период.
     */
    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getName().equals(user))
                .filter(entity -> entity.getEvent() == Event.LOGIN)
                .map(Entity::getDate)
                .min(Date::compareTo).orElse(null);
    }

    /**
     * Метод возвращает дату, когда пользователь впервые попытался решить определенную задачу.
     * Если такой даты нет - null.
     *
     * @param user   Пользователь.
     * @param task   Номер задачи.
     * @param after  Дата до.
     * @param before Дата после.
     * @return Возвращает дату задачи или null.
     */
    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getName().equals(user))
                .filter(entity -> entity.getEvent() == Event.SOLVE_TASK)
                .filter(entity -> entity.getTaskNumber() == task)
                .map(Entity::getDate)
                .min(Date::compareTo).orElse(null);
    }

    /**
     * Метод возвращает дату, когда пользователь решил определенную задачу.
     * Если такой даты нет - null.
     *
     * @param user   Пользователь.
     * @param task   Номер решенной задачи.
     * @param after  Дата до.
     * @param before Дата после.
     * @return Возвращает дату решенной задачи или null.
     */
    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getName().equals(user))
                .filter(entity -> entity.getEvent() == Event.DONE_TASK)
                .filter(entity -> entity.getTaskNumber() == task)
                .map(Entity::getDate)
                .min(Date::compareTo).orElse(null);
    }

    /**
     * Метод возвращает даты, когда пользователь написал сообщение.
     *
     * @param user   Пользователь.
     * @param after  Дата до.
     * @param before Дата после.
     * @return Даты, когда пользователь написал сообщение.
     */
    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getName().equals(user))
                .filter(entity -> entity.getEvent() == Event.WRITE_MESSAGE)
                .map(Entity::getDate)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает даты, когда пользователь скачал плагин.
     *
     * @param user   Пользователь.
     * @param after  Дата до.
     * @param before Дата после.
     * @return Даты, когда пользователь скачал плагин.
     */
    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getName().equals(user))
                .filter(entity -> entity.getEvent() == Event.DOWNLOAD_PLUGIN)
                .map(Entity::getDate)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает количество событий за указанный период.
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @return Количество событий за указанный период.
     */
    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    /**
     * Метод возвращает все события за указанный период.
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @return События за указанный период.
     */
    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .map(Entity::getEvent)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает события, которые происходили с указанного IP.
     *
     * @param ip     IP адрес.
     * @param after  Дата до.
     * @param before Дата после.
     * @return События за указанный период с определенного IP.
     */
    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getIp().equals(ip))
                .map(Entity::getEvent)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает события, которые инициировал определенный пользователь.
     *
     * @param user   Пользователь.
     * @param after  Дата до.
     * @param before Дата после.
     * @return События за указанный период определенного пользователя.
     */
    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getName().equals(user))
                .map(Entity::getEvent)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает события, которые не выполнились.
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @return События, которые не выполнились.
     */
    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getStatus() == Status.FAILED)
                .map(Entity::getEvent)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает события, которые завершились ошибкой.
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @return События, которые завершились ошибкой.
     */
    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getStatus() == Status.ERROR)
                .map(Entity::getEvent)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает количество попыток решить определенную задачу.
     *
     * @param task   Номер задачи.
     * @param after  Дата до.
     * @param before Дата после.
     * @return Количество попыток решить определенную задачу.
     */
    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return (int) entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getEvent() == Event.SOLVE_TASK)
                .filter(entity -> entity.getTaskNumber() == task)
                .count();
    }

    /**
     * Метод возвращает количество успешных решений определенной задачи.
     *
     * @param task   Номер задачи.
     * @param after  Дата до.
     * @param before Дата после.
     * @return Количество успешных решений определенной задачи.
     */
    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return (int) entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getEvent() == Event.DONE_TASK)
                .filter(entity -> entity.getTaskNumber() == task)
                .count();
    }

    /**
     * Метод возвращает Map (номер_задачи : количество_попыток_решить_ее).
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @return Map (номер_задачи : количество_попыток_решить_ее)
     */
    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getEvent() == Event.SOLVE_TASK)
                .collect(Collectors.toMap(Entity::getTaskNumber, entity -> 1, Integer::sum));
    }

    /**
     * Метод возвращает Map (номер_задачи : сколько_раз_ее_решили).
     *
     * @param after  Дата до.
     * @param before Дата после.
     * @return Map (номер_задачи : сколько_раз_ее_решили)
     */
    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return entityList.stream()
                .filter(entity -> filterDate(entity.getDate, after, before))
                .filter(entity -> entity.getEvent() == Event.DONE_TASK)
                .collect(Collectors.toMap(Entity::getTaskNumber, entity -> 1, Integer::sum));
    }

    /**
     * Метод обрабатывает запросы:
     * Примеры:
     * get user
     * get date for event
     * get ip for user = "[any_user]" and date between "[after]" and "[before]"
     *
     * @param query Строка запросов.
     * @return Возвращает данные запроса.
     */
    @Override
    public Set<Object> execute(String query) {
        if (query.split(" ").length <= 2) {
            return getSetForDefaultAction(query.split(" ")[1]);
        }

        String[] split = query.split("=");
        String[] data = split[0].split(" ");
        String field1 = data[1];
        String field2 = data[3];
        String value = split[1].replaceAll("\"", "").trim();
        Date after = null;
        Date before = null;

        if (query.contains("and")) {
            data = query.split("and");
            value = data[0].split("=")[1].replaceAll("\"", "").trim();
            after = parseStringForDate(data[1].split("\"")[1]);
            before = parseStringForDate(data[2].replaceAll("\"", ""));
        }

        return getSetForExecute(field1, field2, value, after, before);
    }

    private Set<Object> getSetForDefaultAction(String action) {
        switch (action) {
            case "ip":
                return entityList.stream()
                        .map(Entity::getIp)
                        .collect(Collectors.toSet());
            case "user":
                return entityList.stream()
                        .map(Entity::getName)
                        .collect(Collectors.toSet());
            case "date":
                return entityList.stream()
                        .map(Entity::getDate)
                        .collect(Collectors.toSet());
            case "event":
                return entityList.stream()
                        .map(Entity::getEvent)
                        .collect(Collectors.toSet());
            case "status":
                return entityList.stream()
                        .map(Entity::getStatus)
                        .collect(Collectors.toSet());
            default:
                throw new IllegalArgumentException();
        }
    }

    private Set<Entity> getEntitySetForAction(String action, String value) {
        switch (action) {
            case "ip":
                return entityList.stream()
                        .filter(entity -> entity.getIp().equals(value))
                        .collect(Collectors.toSet());
            case "user":
                return entityList.stream()
                        .filter(entity -> entity.getName().equals(value))
                        .collect(Collectors.toSet());
            case "event":
                return entityList.stream()
                        .filter(entity -> entity.getEvent() == Event.valueOf(value))
                        .collect(Collectors.toSet());
            case "date":
                return entityList.stream()
                        .filter(entity -> entity.getDate.equals(parseStringForDate(value)))
                        .collect(Collectors.toSet());
            case "status":
                return entityList.stream()
                        .filter(entity -> entity.getStatus() == Status.valueOf(value))
                        .collect(Collectors.toSet());
            default:
                throw new IllegalArgumentException();
        }
    }

    private Set<Object> getSetForExecute(String field1, String field2, String value, Date after, Date before) {
        switch (field1) {
            case "ip":
                return getEntitySetForAction(field2, value).stream()
                        .filter(entity -> filterDate(entity.getDate(), after, before))
                        .map(Entity::getIp)
                        .collect(Collectors.toSet());
            case "user":
                return getEntitySetForAction(field2, value).stream()
                        .filter(entity -> filterDate(entity.getDate(), after, before))
                        .map(Entity::getName)
                        .collect(Collectors.toSet());
            case "date":
                return getEntitySetForAction(field2, value).stream()
                        .map(Entity::getDate)
                        .filter(date -> filterDate(date, after, before))
                        .collect(Collectors.toSet());
            case "event":
                return getEntitySetForAction(field2, value).stream()
                        .filter(entity -> filterDate(entity.getDate(), after, before))
                        .map(Entity::getEvent)
                        .collect(Collectors.toSet());
            case "status":
                return getEntitySetForAction(field2, value).stream()
                        .filter(entity -> filterDate(entity.getDate(), after, before))
                        .map(Entity::getStatus)
                        .collect(Collectors.toSet());
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Метод инициализации.
     *
     * @param logDir Директория, в которой находятся log-файлы.
     */
    private void init(Path logDir) {
        loadData(logDir).stream()
                .map(this::createEntity)
                .forEach(entityList::add);
    }

    /**
     * Метод загружает из директории log-файлы и сохраняет в список.
     *
     * @param logDir Директория, в которой находятся log-файлы.
     * @return Список строк, загруженных из log-файлов.
     */
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

    /**
     * Метод принимает строку, парсит и сохраняет в объект Date.
     *
     * @param date Строка с датой.
     * @return Возвращает дату.
     */
    private Date parseStringForDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод проверяет, что текущая дата находится во временном промежутке.
     *
     * @param currentDate Текущая дата.
     * @param after       Дата после.
     * @param before      Дата до.
     * @return true - если текущая дата находится в указанном временном промежутке, иначе - false.
     */
    private boolean filterDate(Date currentDate, Date after, Date before) {
        after = after != null ? after : new Date(0);
        before = before != null ? before : new Date(Long.MAX_VALUE);

        return currentDate.after(after) && currentDate.before(before);
    }

    /**
     * Метод создает из переданной строки log-файла сущность.
     *
     * @param data Строка из log-файла.
     * @return Возвращает сущность.
     */
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

    /**
     * Внутренний класс сущности log-файла.
     */
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