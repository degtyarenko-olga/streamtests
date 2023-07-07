package org.example;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Описание класса
 *
 * @author Volha Dzehtsiarenka
 * @since 07.07.2023
 */
public class StreamTests {
    public static void main(String[] args) {
        Map<String, String> map0 = Map.of(
                "1", "A",
                "2", "B",
                "3", "C");
        Map<String, String> map1 = Map.of(
                "0", "D",
                "1", "E",
                "2", "B");

        Map<String, Set<String>> mapStream =
                Stream.of(map0, map1)
                        .flatMap(map -> map.entrySet()
                                .stream())
                        .collect(Collectors.groupingBy(
                                Map.Entry::getKey, Collectors.mapping(
                                        Map.Entry::getValue, Collectors.toSet())));

        final LinkedHashMap<String, Set<String>> collect = Stream.of(map0, map1)
                .map(Map::entrySet)
                .flatMap(Collection::stream)
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                e -> Set.of(e.getValue()),
                                (e0, e1) -> {
                                    Set<String> s = new HashSet<>();
                                    s.addAll(e0);
                                    s.addAll(e1);
                                    return s;
                                },
                                LinkedHashMap::new
                        )
                );

        System.out.println("collect = " + collect);


//        System.out.println(mapStream);
    }
}
