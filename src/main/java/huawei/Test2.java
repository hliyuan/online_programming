package huawei;



/**
 * Created by liyuan on 2017/7/6.
 */

import java.util.Scanner;
public class Test2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        for (int i = 3; i < 1000; i++) {
            if (f(i) == i) {
                count++;
                System.out.println(i);
            }
        }
        System.out.println(count);
    }

    public static int f(int n){
        int rs = 0;
        while(n/10!=0){
            int l = n%10;
            rs += l*l*l;
            n = n/10;
        }
        rs += n*n*n;
        return rs;

    }
}
