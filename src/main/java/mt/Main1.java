package mt;

/**
 * Created by liyuan on 2017/6/18.
 */


import java.util.Scanner;

/**
 * 给定两个整数 l 和 r ，对于所有满足1 ≤ l ≤ x ≤ r ≤ 10^9 的 x ，把 x 的所有约数全部写下来。
 * 对于每个写下来的数，只保留最高位的那个数码。求1～9每个数码出现的次数。

 输入描述:
 一行，两个整数 l 和 r (1 ≤ l ≤ r ≤ 10^9)。

 输出描述:
 输出9行。
 第 i 行，输出数码 i 出现的次数。

 输入例子:
 1 4

 输出例子:
 4
 2
 1
 1
 0
 0
 0
 0
 0
 *
 * */
public class Main1 {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int l = in.nextInt();
            int r = in.nextInt();
            int[] result = new int[9];

            for (int i = l; i<=r ; i++){

                for (int j = 1; j <= i/2; j++) {
                    if (i%j==0){
                        int t = j;
                        while (t/10!=0){
                            t = t/10;
                        }
                        result[t-1]++;
                    }
                }
                int t2 = i;
                while (t2/10!=0){
                    t2 = t2/10;
                }
                result[t2-1]++;



            }

            for (int i = 0; i < 9; i++) {
                System.out.println(result[i]);
            }

        }
    }
}
