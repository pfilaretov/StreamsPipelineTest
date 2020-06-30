package ru.pfilaretov.test.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamPipelineTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "1_A");
        map.put("b", "2_b");
        map.put("c", "3_C");
        map.put("d", "4_d");
//        map.put("e", "5_E");
//        map.put("f", "6_f");

        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");

        Set<String> result = list.stream()
                .map(map::get)
                .map(String::toLowerCase)
//                .collect(Collectors.toSet())  // throws NPE
                .collect(HashSet::new, (set, value) -> set.add(Optional.ofNullable(value).orElse("")), HashSet::addAll); // throws NPE as well!

        System.out.println("result=" + result);
    }
}
