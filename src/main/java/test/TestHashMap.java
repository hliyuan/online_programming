package test;

import java.util.HashMap;

/**
 * Created by liyuan on 2017/6/5.
 */



public class TestHashMap {
    public HashMap<Integer,String> buildMap(String[] string){
        HashMap<Integer,String> map = new HashMap<Integer, String>();

        for (String s: string) {
            map.put(1,s);
        }
        return map;

    }
}
