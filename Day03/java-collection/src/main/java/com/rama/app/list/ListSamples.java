package com.rama.app.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListSamples {
    public static List<String> stringList= new ArrayList<String>();

    public void add(String data){
        stringList.add(data);
    }
    public void printList(){
        for(String data : stringList){
            System.out.println(data);
        }
    }

    public void remove(String data){
        stringList.remove(data);
    }

    public void sizeOfList(){
        System.out.println(stringList.size());
    }

    public static void main(String[] args) {
        ListSamples listSamples = new ListSamples();
        listSamples.add("test1"); // index 0
        listSamples.add("test2"); // index 1
        listSamples.add("test3");
        listSamples.add("test3");
        listSamples.printList();// index 2
        System.out.println("Value at index 1:"+stringList.get(1));
        stringList.set(1,"Rama");
        System.out.println("Value at index 1:"+stringList.get(1));
        stringList.remove(1);
        listSamples.printList();

        listSamples.sizeOfList();
        listSamples.printList();
        listSamples.sizeOfList();
        listSamples.add("test4");
        System.out.println("After remove");
        listSamples.remove("test2");

        List<Integer> listInt  = new ArrayList<>();
        listInt.add(1);
        listInt.add(2);
        listInt.add(3);
        listInt.add(4);
        listInt.add(5);
        Iterator<Integer> iterator = listInt.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
