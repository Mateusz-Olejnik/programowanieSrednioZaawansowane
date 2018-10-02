package com.sda;

import java.util.*;

public class Application {

//    public static void main(String[] args) {
//        List<String> texts = Arrays.asList("Ala", "ma", null, "kota", null, "abc");
//        for (String text : texts) {
//            Optional<String> optional = Optional.ofNullable(text);
//            // wyswietlic elemnt gdy ma wiecej niz 2 litery
//            // w przeciwnym wypadku wyswietlic "STOP"
//
//            System.out.println(optional.filter(e -> e.length() > 2)
//                    .orElse("STOP"));
//        }
//
//
//    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>() {{
            put(2, "dwa");
            put(3, "trzy");
            put(4, "cztery");
            put(5, null);
            put(6, "");
        }};
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Optional<String> value = Optional.ofNullable(entry.getValue());
        // 2: 3
            // 3: 4
            // 4: 6
            // 5: 0
            // 6: 0
        }
    }

}
