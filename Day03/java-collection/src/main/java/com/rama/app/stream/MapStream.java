package com.rama.app.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStream {
  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("apple", 100);
    map.put("orange", 20);
    map.put("banana", 30);
    map.put("pineapple", 40);
    Map<String, Integer> filterFruit = map.
        entrySet().stream()
        .filter(entry->entry.getValue()>30)
        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

    Map<String, Integer> filterless40Fruit = map.
        entrySet().stream()
        .filter(entry->entry.getValue()<40)
        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    System.out.println("filterless40Fruit: "+filterless40Fruit);
  }

}
