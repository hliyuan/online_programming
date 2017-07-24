import java.util.*;

/**
 * Created by liyuan on 2017/6/20.
 */

/**
 * 设计一种排序方式，按照元素的频率对正整数列表排序，频率较高的元素排在前面，频率相同的元素和给定的顺应一致。
 * */
public class Test {
    public static int[] orderByNumbers(int[] a){

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])){
                map.put(a[i],map.get(a[i])+1);
            }else {
                map.put(a[i],1);
            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        Collection<Integer> keys = map.keySet();
        for (Integer key: keys
             ) {
            list.add(map.get(key));
        }

        ArrayList<Integer> resultList = new ArrayList<Integer>();
        Collections.sort(list);
        for (Integer v:list
             ) {
            System.out.print(v+"...");
        }

        for (int i = list.size()-1; i >=0; i--) {
            for (Integer key: keys) {
                if (list.get(i)==map.get(key)) {
                    for (int j = 0; j < list.get(i); j++) {
                        resultList.add(key);
                    }
                    map.put(key,0);
                }

            }
        }
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = resultList.get(i);

        }
    return result;
    }

    public static void main(String[] args) {
        int a[] = {1,2,2,3,3,3,4,4,5,5,5,5,6,6,6,7,8,9,10};

        int result[] = orderByNumbers(a);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+",");
        }
    }
}
