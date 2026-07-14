package com.example.searchservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SearchController {

    private static final List<Item> RECORDS = List.of(
            new Item(1, "Wireless Mouse"),
            new Item(2, "Mechanical Keyboard"),
            new Item(3, "USB-C Hub"),
            new Item(4, "Laptop Stand"),
            new Item(5, "Noise Cancelling Headphones")
    );

    @GetMapping("/search")
    public Map<String, List<Item>> search(@RequestParam String q) {
        List<Item> matches = RECORDS.stream()
                .filter(i -> i.name().toLowerCase().contains(q.toLowerCase()))
                .toList();
        return Map.of("results", matches);
    }

    public record Item(int id, String name) {}
}
