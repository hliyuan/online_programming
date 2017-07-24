package test.TestMap;

import java.util.HashMap;

/**
 * Created by liyuan on 2017/6/9.
 */
public class TestHashMap {

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        hashMap.put(1,2);

        hashMap.put(1,3);

        System.out.println(hashMap.get(1));
    }

}
