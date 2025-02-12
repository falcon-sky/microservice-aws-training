package com.rama.app.stream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListStream {
  public static void main(String[] args) {
    List<Integer> list=new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    Stream stream=list.stream();
    stream.forEach(System.out::println);
    List<Integer> evenNumbers = list.stream()
        .filter(n -> n % 2 == 0)  // Check if the number is even
        .collect(Collectors.toList());
    List<Integer> oddNumbers = list.stream()
        .filter(n -> n % 2 != 0)  // Check if the number is even
        .collect(Collectors.toList());
    System.out.println("Even numbers: " + evenNumbers);
    System.out.println("Odd numbers: " + oddNumbers);
  }

}
