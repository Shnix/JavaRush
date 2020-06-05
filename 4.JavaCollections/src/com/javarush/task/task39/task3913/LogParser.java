package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    public ArrayList<Node> nodes = new ArrayList<>();

    public LogParser(Path logDir){
        try {
            parseDir(logDir);
        }
        catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }

    private void parseDir(Path logDir) throws IOException, ParseException {
        List<Path> files = Files.list(logDir)
                .filter(o -> o.toString().endsWith(".log")).collect(Collectors.toList());
        for (Path path : files){
            try(BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))){
                while (reader.ready()){
                    nodes.add(new Node(reader.readLine()));
                }
            }
        }
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {

        return getUniqueIPs(after,before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ips = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Node::getIp)
                .collect(Collectors.toSet());
        return ips;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> ips = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                &&node.getName().equals(user))
                .map(Node::getIp)
                .collect(Collectors.toSet());
        return ips;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> ips = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        &&node.getEvent().equals(event))
                .map(Node::getIp)
                .collect(Collectors.toSet());
        return ips;

    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> ips = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        &&node.getStatus().equals(status))
                .map(Node::getIp)
                .collect(Collectors.toSet());
        return ips;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> names = nodes.stream()
                .filter(node -> node.getName()!=null)
                .map(Node::getName)
                .collect(Collectors.toSet());
        return names;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> names = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getName()!=null)
                .map(Node::getName)
                .collect(Collectors.toSet());
        return names.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> names = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getName().equals(user))
                .map(Node::getEvent)
                .collect(Collectors.toSet());
        return names.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> names = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getIp().equals(ip))
                .map(Node::getName)
                .collect(Collectors.toSet());
        return names;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> names = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getEvent().equals(Event.LOGIN))
                .map(Node::getName)
                .collect(Collectors.toSet());
        return names;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> names = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getEvent().equals(Event.DOWNLOAD_PLUGIN))
                .map(Node::getName)
                .collect(Collectors.toSet());
        return names;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> names = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getEvent().equals(Event.WRITE_MESSAGE))
                .map(Node::getName)
                .collect(Collectors.toSet());
        return names;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> names = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getEvent().equals(Event.SOLVE_TASK))
                .map(Node::getName)
                .collect(Collectors.toSet());
        return names;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> names = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getEvent().equals(Event.SOLVE_TASK)
                && node.getTask()==task)
                .map(Node::getName)
                .collect(Collectors.toSet());
        return names;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> names = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getEvent().equals(Event.DONE_TASK))
                .map(Node::getName)
                .collect(Collectors.toSet());
        return names;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> names = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getEvent().equals(Event.DONE_TASK)
                        && node.getTask()==task)
                .map(Node::getName)
                .collect(Collectors.toSet());
        return names;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date>  dates = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                && node.getName().equals(user)
                && node.getEvent().equals(event))
                .map(node -> new Date(node.getDate()))
                .collect(Collectors.toSet());
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date>  dates = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getStatus().equals(Status.FAILED))
                .map(node -> new Date(node.getDate()))
                .collect(Collectors.toSet());
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date>  dates = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getStatus().equals(Status.ERROR))
                .map(node -> new Date(node.getDate()))
                .collect(Collectors.toSet());
        return dates;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        return getDatesForUserAndEvent(user,Event.LOGIN,after,before).stream()
                .min(Comparator.naturalOrder())
                .orElse(null);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Set<Date>  dates = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getName().equals(user)
                        && node.getEvent().equals(Event.SOLVE_TASK)
                        && node.getTask()==task)
                .map(node -> new Date(node.getDate()))
                .collect(Collectors.toSet());
        return dates.stream()
                .sorted()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Set<Date>  dates = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getName().equals(user)
                        && node.getEvent().equals(Event.DONE_TASK)
                        && node.getTask()==task)
                .map(node -> new Date(node.getDate()))
                .collect(Collectors.toSet());
        return dates.stream()
                .sorted()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date>  dates = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getName().equals(user)
                        && node.getEvent().equals(Event.WRITE_MESSAGE))
                .map(node -> new Date(node.getDate()))
                .collect(Collectors.toSet());
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date>  dates = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getName().equals(user)
                        && node.getEvent().equals(Event.DOWNLOAD_PLUGIN))
                .map(node -> new Date(node.getDate()))
                .collect(Collectors.toSet());
        return dates;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after,before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> events = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Node::getEvent)
                .collect(Collectors.toSet());
        return events;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> events = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                && node.getIp().equals(ip))
                .map(Node::getEvent)
                .collect(Collectors.toSet());
        return events;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> events = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getName().equals(user))
                .map(Node::getEvent)
                .collect(Collectors.toSet());
        return events;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> events = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getStatus().equals(Status.FAILED))
                .map(Node::getEvent)
                .collect(Collectors.toSet());
        return events;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> events = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getStatus().equals(Status.ERROR))
                .map(Node::getEvent)
                .collect(Collectors.toSet());
        return events;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return (int) nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getEvent().equals(Event.SOLVE_TASK)
                        && node.getTask()==task)
                .count();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return (int) nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        &&node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getEvent().equals(Event.DONE_TASK)
                        && node.getTask()==task)
                .count();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer,Integer> tasks = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        && node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getEvent().equals(Event.SOLVE_TASK))
                .collect(Collectors.toMap(Node::getTask,node -> 1,Integer::sum));
        return tasks;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer,Integer> tasks = nodes.stream()
                .filter(node -> node.getDate() >= (after == null ? 0 : after.getTime())
                        && node.getDate() <= (before == null ? Long.MAX_VALUE : before.getTime())
                        && node.getEvent().equals(Event.DONE_TASK))
                .collect(Collectors.toMap(Node::getTask,node -> 1,Integer::sum));
        return tasks;
    }

    public Set<Object> simpleExecute(String query) {
        switch (query.trim()) {
            case "get ip":
                return nodes.stream()
                        .map(Node::getIp)
                        .collect(Collectors.toSet());
            case "get user":
                return nodes.stream()
                        .map(Node::getName)
                        .collect(Collectors.toSet());
            case "get event":
                return nodes.stream()
                        .map(Node::getEvent)
                        .collect(Collectors.toSet());
            case "get status":
                return nodes.stream()
                        .map(Node::getStatus)
                        .collect(Collectors.toSet());
            case "get date":
                return nodes.stream()
                        .map(o->new Date(o.getDate()))
                        .collect(Collectors.toSet());
            default:
                return null;
        }
    }

    @Override
    public Set<Object> execute(String query) {
        if (query.split(" ").length == 2)
            return simpleExecute(query);
        String pattern = "get (?<tag>\\w+)(\\sfor\\s(?<field>\\w+)\\s=\\s\"(?<value>.+?)\")?(\\sand date between" +
                "\\s\"(?<after>[\\d]+.[\\d]+.[\\d]+ [\\d]+:[\\d]+:[\\d]+)\"\\sand\\s\"" +
                "(?<before>[\\d]+.[\\d]+.[\\d]+ [\\d]+:[\\d]+:[\\d]+)\")?";
        Matcher matcher = Pattern.compile(pattern).matcher(query);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        if (matcher.find()) {
            String field1 = matcher.group("tag");
            String field2 = matcher.group("field");
            String value2 = matcher.group("value");
            Date after = null;
            Date before = null;
            try {
                if (matcher.group("after") != null && matcher.group("before") != null) {
                    after = format.parse(matcher.group("after"));
                    before = format.parse(matcher.group("before"));
                }
                if (field2.equals("date"))
                    value2 = format.parse(value2).toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String value1 = value2;
            Date constAfter = after;
            Date constBefore = before;
            return nodes.stream()
                    .filter(log -> log.get(field2).toString().equalsIgnoreCase(value1)
                            && log.getDate() > (constAfter == null ? 0 : constAfter.getTime())
                            && log.getDate() < (constBefore == null ? Long.MAX_VALUE : constBefore.getTime()))
                    .map(log -> log.get(field1))
                    .collect(Collectors.toSet());
        }
        return null;
    }

    public static class Node{
        private String ip;
        private String name;
        private Long date;
        private Event event;
        private Integer task;
        private Status status;

        private Node(String log) throws ParseException {
            String[] logLine = log.split("\t");
            this.ip = logLine[0];
            this.name = logLine[1];
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            this.date = format.parse(logLine[2]).getTime();
            String[] eventAndTask = logLine[3].split(" ");
            this.event = Event.valueOf(eventAndTask[0]);
            if(eventAndTask.length == 2){
                this.task = Integer.parseInt(eventAndTask[1]);
            }
            else {this.task = 0;}
            this.status = Status.valueOf(logLine[4]);
        }

        public Object get(String fieldName) {
            switch (fieldName.toLowerCase()) {
                case "ip":
                    return ip;
                case "user":
                    return name;
                case "date":
                    return new Date(date);
                case "status":
                    return status;
                case "event":
                    return event;
                case "task":
                    return task;
                default:
                    return null;
            }
        }

        public String getIp() {
            return ip;
        }

        public String getName() {
            return name;
        }

        public Long getDate() {
            return date;
        }

        public Event getEvent() {
            return event;
        }

        public Integer getTask() {
            return task;
        }

        public Status getStatus() {
            return status;
        }
    }
}