package com.vincent.thread.wait_notifyDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * author:vincent
 * Date:2018/10/30
 */
public class MyList {

    private static List<String> list = new ArrayList<>();

    public static void add() {
        list.add("anyString");
    }

    public static int size() {
        return list.size();
    }

}
