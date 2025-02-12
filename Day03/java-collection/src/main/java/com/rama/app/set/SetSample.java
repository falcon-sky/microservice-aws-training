package com.rama.app.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetSample {
    public static void main(String[] args) {
        Set<String> setString = new HashSet();
        setString.add("Test8");
        setString.add("Test6");
        setString.add("c");
        setString.add("d");

        for(String data:setString){
            System.out.println(data);
        }
        Set<Integer> setInteger = new HashSet();
        setInteger.add(10);
        setInteger.add(2);
        setInteger.add(50);
        for(Integer data:setInteger){
            System.out.println(data);
        }
        Set<Integer> setData = new LinkedHashSet<>();
        setData.add(10);
        setData.add(2);
        setData.add(50);
        System.out.println("LinkedHashSet: ");
        for(Integer data:setData){
            System.out.println(data);
        }
         Set<Integer> setTreeData = new TreeSet<>();
        setTreeData.add(10);
        setTreeData.add(2);
        setTreeData.add(50);
        for(Integer data:setTreeData){
            System.out.println(data);
        }
        System.out.println("Iterator: ");
        Iterator<Integer> iterator = setInteger.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
