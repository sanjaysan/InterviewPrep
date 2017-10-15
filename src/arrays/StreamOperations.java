package arrays;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by sanjay on 10/12/17.
 */
class Person
{
    String name;
    int age;

    Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return name;
    }
}

public class StreamOperations
{
    private static char findUniqueChar(String s)
    {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            map.merge(c, 1, (k, v) -> v + 1);
        }
        List<Character> list = map.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
        return list.get(0);
    }
    public static void main(String[] args)
    {
        List<Person> persons = Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David   ", 12));
        Map<Integer, List<Person>> personsByAge = persons.stream()
                                                         .collect(Collectors.groupingBy(p -> p.age));
        personsByAge.forEach((age, p) -> System.out.format("age: %s: %s\n", age, p));
        ArrayList<Integer> r = new ArrayList<>();

        Map<Integer, String> map = persons.stream().
                collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2) -> name1 + ";" + name2));
        map.forEach((age, name) -> System.out.println(name + " " + age));

        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of (
                        () -> new StringJoiner( "|" ),
                        (j, p) -> j.add(p.name.toUpperCase()),
                        StringJoiner::merge,
                        StringJoiner::toString);
        String names = persons.stream().collect(personNameCollector);
        System.out.println(names);
        String s = "ratrice";
        char result = findUniqueChar(s);
        System.out.println(result);
    }
}
