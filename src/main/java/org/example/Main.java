package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Домашнее задание к уроку \"Обзор коллекций в Java\"");

        /* 1: Реализуй метод, который поменяет ключи и значения в HashMap местами. На вход в метод поступает
          HashMap<Integer, String>, надо вернуть HashMap<String, Integer>. Выведи результат.
         */
        Map<Integer, String> map = new HashMap<>();
        map.put(15, "Ivanov");
        map.put(25, "Norovirus");
        map.put(35, "Petrov");
        map.put(65, "Norovirus");
        map.put(45, "Smith");
        map.put(5, "Smith");
        map.put(10, "Joy");
        map.put(100, "Joy");
        System.out.println(changeKeysAndValues(map));

        /*
          2: Реализуй метод, в котором создаются ArrayList, LinkedList и заполняются 1 000 000 случайными элементами
          одного и того же типа. После из ArrayList и LinkedList 1000 раз выбираем элемент по случайному индексу.
          Замерь время для ArrayList и LinkedList. Сравни результаты и предположи, почему они могут отличаться.
         */
        List<Double> arrayList = populateList(new ArrayList<>());
        List<Double> linkedList = populateList(new LinkedList<>());

        long startTime = System.nanoTime();
        fetchesThousandsItems(arrayList);
        long endTime = System.nanoTime();
        System.out.println("Время выборки 1000 элементов из ArrayList " + (endTime - startTime) + " нс." );

        startTime = System.nanoTime();
        fetchesThousandsItems(linkedList);
        endTime = System.nanoTime();
        System.out.println("Время выборки 1000 элементов из LinkedList " + (endTime - startTime) + " нс." );

        /*
         * 3: Реализуй метод, который на вход примет ArrayList строк и удаляет из него все дубликаты, не используя
         * метод contains(). Можно использовать другие коллекции, которые были изучены на уроке.
         */
        System.out.println("Список значений (map.values()) из 1-го задания без дубликатов");
        System.out.println(removeDuplicates(map.values().stream().toList()));
    }

    /**
     * Меняет местами ключи и значения.
     *
     * @param map исходная карта
     * @return результат
     */
    private static Map<String, Integer> changeKeysAndValues(Map<Integer, String> map) {
        Map<String, Integer> ret = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            ret.put(entry.getValue(), entry.getKey());
        }
        return ret;
    }

    /**
     * Заполняет список миллионом случайных значений.
     *
     * @param list пустой список
     * @return заполненный список
     */
    private static List<Double> populateList(List<Double> list) {
        final int N = 1000000;
        for (int i = 0; i < N; i++) {
            list.add((Math.random() * N));
        }
        return list;
    }

    /**
     * Производит выборку 1000 элементов случайным образом.
     *
     * @param list входной список
     */
    private static void fetchesThousandsItems(List<Double> list) {
        final int N = Math.min(list.size(), 1000);
        for (int i = 0; i < N; i++) list.get((int) (Math.random() * N));
    }

    /**
     * Удаляет из списка все дубликаты.
     *
     * @param list исздный список
     * @return список без дубликатов
     */
    private static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> set = new HashSet<>(list);
        return set.stream().toList();
    }
}