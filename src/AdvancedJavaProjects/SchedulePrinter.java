package AdvancedJavaProjects;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SchedulePrinter {
    static LinkedList<String> exceptions = new LinkedList<>(List.of(
            "09 05 2022", "09 26 2022", "10 05 2022",
            "10 10 2022", "11 11 2022", "11 24 2022", "11 25 2022", "12 25 2022", "12 26 2022", "12 27 2022",
            "12 28 2022", "12 29 2022", "12 30 2022", "01 02 2023", "01 13 2023", "01 16 2023", "02 20 2023",
            "02 21 2023", "02 22 2023", "02 22 2023", "02 23 2023", "02 24 2023", "03 10 2023", "04 07 2023",
            "04 17 2023", "04 18 2023", "04 19 2023", "04 20 2023", "04 21 2023", "05 29 2023"
    ));
    static String startDate = "09 01 2022";
    static String endDate = "06 16 2023";
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM dd yyyy");
    static Scanner myScanner = new Scanner(System.in);
    static TreeMap<Integer, ArrayList<String>> eightday = print8Day();

    public static TreeMap<String, String> schedulePrinter() {
        TreeMap<String, String> schedule = new TreeMap<>();
        ArrayList<String> blocks = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H"));

        for (String block : blocks) {
            System.out.println("What is your " + block + " block class?");
            schedule.put(block, myScanner.nextLine());
        }
        System.out.println("What day would you like to know your classes for? ");
        schedule.put("current_day", myScanner.nextLine());
        System.out.println(schedule);
        return schedule;

    }

    public static TreeMap<Integer, ArrayList<String>> print8Day() { // TODO: probably add param for unformatted hashmap

        TreeMap<Integer, String> eightday = new TreeMap<>() {{
            put(1, "ACDHF");
            put(2, "BAHGE");
            put(3, "CBFDG");
            put(4, "ACEFH");
            put(5, "BAGED");
            put(6, "CBDHF");
            put(7, "ACHEG");
            put(8, "BEFGD");
        }};


        TreeMap<String, String> blocks = schedulePrinter();
        TreeMap<Integer, ArrayList<String>> res = new TreeMap<>();

        for (Map.Entry<Integer, String> day : eightday.entrySet()) {
            String[] tempStr = day.getValue().split("");

            for (int i = 0; i < tempStr.length; i++) {
                tempStr[i] = blocks.get(tempStr[i]);
            }

            res.put(day.getKey(), new ArrayList<>(Arrays.asList(tempStr)));
        }


        return res;
    }

    private static boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    private static ArrayList<LocalDate> filterdays() {
        LocalDate start = LocalDate.from(LocalDate.parse(startDate, dtf).atStartOfDay());
        LocalDate end = LocalDate.from(LocalDate.parse(endDate, dtf).atStartOfDay());

        ArrayList<LocalDate> valid_dates = new ArrayList<>();

        for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1))
        {
            if(!isWeekend(date)) {
                if(!exceptions.contains(date.format(dtf))) {
                    valid_dates.add(date);
                }
            }
        }
        return valid_dates;
    }

    public static TreeMap<LocalDate, ArrayList<String>> returnDays() {
        ArrayList<LocalDate> valid_dates = filterdays();
        TreeMap<LocalDate, ArrayList<String>> days = new TreeMap<>();
        ArrayList<String> templist = new ArrayList<>();
        int current_day = 1;
        for (LocalDate date : valid_dates) {
            if (current_day > 8) {
                current_day = 1;
            }

            days.put(date, eightday.get(current_day));
            current_day++;
        }
        return days;

    }
    public static TreeMap<LocalDate, ArrayList<LocalDate>> findMondays() {
        TreeMap<LocalDate, ArrayList<String>> days = returnDays();

        TreeMap<LocalDate, ArrayList<LocalDate>> mondays = new TreeMap<>();
        for (LocalDate date : days.keySet()) {
            if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
                mondays.put(date, new ArrayList<>(List.of(date, date.plusDays(1), date.plusDays(2), date.plusDays(3), date.plusDays(4))));
            }
        }
        return mondays;

    }


    public static void main(String[] args) {
        TreeMap<LocalDate, ArrayList<LocalDate>> mondays = findMondays();
        TreeMap<LocalDate, ArrayList<String>> days = returnDays();
        System.out.println("What would you like to know about your schedule?");
        System.out.println("1. What is my schedule for a specific day?");
        System.out.println("2. What is my schedule for a specific week (date)?");
        System.out.println("3. What is my schedule for a just the 8 day rotation?");
        System.out.println("4. What is my schedule for a specific week (number)?");
        int option = myScanner.nextInt();
        myScanner.nextLine();
        switch (option) {

            case 1 -> {
                System.out.println("What day would you like to know your schedule for? (MM DD YYYY)");
                String day1 = myScanner.nextLine();
                System.out.println(day1);
                LocalDate date = LocalDate.from(LocalDate.parse(day1, dtf).atStartOfDay());
                System.out.println("Your schedule for " + date.format(dtf) + " is: ");
                System.out.println(days.get(date).stream().map(Object::toString).collect(Collectors.joining(", ")));
            }
            case 2 -> {
                System.out.println("Please enter a date, (MM dd yyyy):");
                String day2 = myScanner.nextLine();
                System.out.println(day2);
                LocalDate date = LocalDate.parse(day2, dtf);
                if (mondays.containsKey(date)) {
                    mondays.get(date).forEach(day -> System.out.println(day + " " + days.get(day).stream().map(Object::toString).collect(Collectors.joining(", "))));
                } else {
                    System.out.println("That is not a monday, but here is the week that contains that date.");
                    mondays.get(date.with(TemporalAdjusters.previous(DayOfWeek.MONDAY))).forEach(day -> System.out.println(day + " " + days.get(day).stream().map(Object::toString).collect(Collectors.joining(", "))));
                }
            }
            case 3 -> {
                final AtomicInteger index = new AtomicInteger(1);
                eightday.values().forEach(da8 -> {
                    final int i1 = index.getAndIncrement();
                    System.out.println(i1 + " " + da8.stream().map(Object::toString).collect(Collectors.joining(", ")));
                });
            }
            case 4 -> {
                System.out.println("Please enter a week number: ");
                int week = myScanner.nextInt();
                Object key = mondays.keySet().toArray()[week - 1];
                mondays.get(key).forEach(day -> System.out.println(day + " " + days.get(day).stream().map(Object::toString).collect(Collectors.joining(", "))));
            }
            default -> System.out.println("Invalid option");
        }




    }
}