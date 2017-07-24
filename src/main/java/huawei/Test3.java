package huawei;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by liyuan on 2017/7/6.
 */

import java.util.Scanner;
public class Test3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String[][] method = new String[n][2];
            String[] s = new String[n];
            in.nextLine();
            for (int i = 0; i < n; i++) {
                s[i] = in.nextLine();

                method[i][0] = s[i].split(" ")[0];
                method[i][1] = s[i].split(" ")[1];

            }
            String key = in.next();
            String value = in.next();
            System.out.println("T");

        }
    }
}
