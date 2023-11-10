package com.tempo;

import java.util.List;

public class CommonUtils {

    public static int[] listToArray(List<Integer> list) {
        return list.stream().mapToInt(i -> i).toArray();
    }

}