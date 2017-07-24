package huawei;




/**
 * Created by liyuan on 2017/7/6.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
public class Test1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            String[][] method = new String[n][2];
            String[]s = new String[n];
            HashMap<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
            in.nextLine();
             for (int i = 0; i < n; i++) {
                s[i] = in.nextLine();

                method[i][0] = s[i].split(" ")[0];
                method[i][1] = s[i].split(" ")[1];
                if (map.containsKey(method[i][0])){
                    ArrayList list = map.get(method[i][0]);
                    list.add(method[i][1]);
                    map.put(method[i][0],list);
                }else {
                    ArrayList<String> list = new ArrayList<String>();
                    list.add(method[i][1]);
                    map.put(method[i][0],list);
                }
            }
            String key = in.next();
            String value = in.next();
            boolean result = find(key, value, map);
            if (result)
                System.out.println("T");
            else
                System.out.println("F");

        }


    }
    public static boolean find(String key, String value, HashMap < String, ArrayList < String >> map){

        ArrayList valueList = map.get(value);
        if (valueList.contains(key))  return false;

            Iterator iterator = valueList.iterator();
            while (iterator.hasNext()){
                String next = String.valueOf(iterator.next());

                if (map.get(next).contains(key)) return false;
                else find(next,value,map);
            }

        return true;
    }
}
