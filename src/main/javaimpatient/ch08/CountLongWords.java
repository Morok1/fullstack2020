package ch08.sec01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static org.springframework.data.util.Pair.toMap;

public class CountLongWords {
    public static void main(String[] args) throws IOException {
        String contents = Files.readString(Paths.get("/Users/evgenijsmagin/IdeaProjects/fullstack2020/src/main/javaimpatient/ch08/sec01/alice.txt"));
        List<String> words = List.of(contents.split("\\PL+"));

        long count = 0;
        for (String w : words) {
            if (w.length() > 12)
                count++;
        }
        System.out.println(count);

        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        words.stream().collect(toList());
        words.stream().allMatch(w -> w.length() > 12);
        words.stream().distinct();
        Optional<String> any = words.stream().filter(s -> s.length() == 3).findAny();

        words.stream().forEach(s -> System.out.println(s));
        words.stream().forEach(System.out::println);

        words.stream().distinct();
    }

    public static void  collectors(List<String> words){
        words.stream().collect(Collectors.toUnmodifiableList());

        words.stream().collect(Collectors.toCollection(LinkedList::new));

        words.stream().collect(Collectors.toMap(Function.identity(), String::length));
        words.stream().collect(Collectors.toMap(Function.identity(), String::length, (item, identical) -> item));
        words.stream().collect(Collectors.collectingAndThen(toList(), LinkedList::new));


        String collect = words.stream().collect(Collectors.joining());
        DoubleSummaryStatistics result = words.stream()
                .collect(summarizingDouble(String::length));


    }
}
