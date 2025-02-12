package com.rama.app.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapSample {
  public static void main(String[] args) {
    Map<String,Integer> map = new HashMap();
    map.put("Z", 50);
    map.put("Alpha", 1);
    map.put("C", 3);
    for (Map.Entry<String,Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey()+" "+entry.getValue());
    }
    map.remove("A");
    System.out.println("After remove A");
    for (Map.Entry<String,Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey()+" "+entry.getValue());
    }

    Map<String,Integer> map2 = new LinkedHashMap();
    map2.put("Z", 50);
    map2.put("Alpha", 1);
    map2.put("C", 3);
    System.out.println("Linked HashMap");
    for (Map.Entry<String,Integer> entry : map2.entrySet()) {
      System.out.println(entry.getKey()+" "+entry.getValue());
    }

    Map<String,Integer> map3 = new TreeMap<>();
    map3.put("Z", 50);
    map3.put("Alpha", 1);
    map3.put("C", 3);
    System.out.println("Tree Map");
    for (Map.Entry<String,Integer> entry : map3.entrySet()) {
      System.out.println(entry.getKey()+" "+entry.getValue());
    }
  }
}
