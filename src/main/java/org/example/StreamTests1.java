package org.example;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Описание класса
 *
 * @author Volha Dzehtsiarenka
 * @since 07.07.2023
 */
public class StreamTests1 {
    public static void main(String[] args) {
        List<List<String>> a1 = List.of(
                List.of("A", "1", "1a", "o"),
                List.of("A", "2", "1a", "1"),
                List.of("A", "1", "1a", "1"),
                List.of("B", "2", "2a", "2"));

        List<List<String>> a2 = List.of(
                List.of("A", "1", "1a", "o"),
                List.of("A", "3", "1a", "0"),
                List.of("A", "2", "1a", "2"),
                List.of("A", "2", "2a", "3"));

        Map<Stream<String>, List<List<String>>> collection = Stream.of(a1, a2)
                .flatMap(Collection::stream)
                .collect(
                        Collectors.
                );

        System.out.println(collection);
    }
}
