package mt;

/**
 * Created by liyuan on 2017/6/18.
 */

import java.util.Scanner;

/**
 * 美团外卖的品牌代言人袋鼠先生最近正在进行音乐研究。他有两段音频，每段音频是一个表示音高的序列。
 * 现在袋鼠先生想要在第二段音频中找出与第一段音频最相近的部分。

 具体地说，就是在第二段音频中找到一个长度和第一段音频相等且是连续的子序列，使得它们的 difference 最小。
 两段等长音频的 difference 定义为：
 difference = SUM(a[i] - b[i])2 (1 ≤ i ≤ n),其中SUM()表示求和
 其中 n 表示序列长度，a[i], b[i]分别表示两段音频的音高。现在袋鼠先生想要知道，difference的最小值是多少？
 数据保证第一段音频的长度小于等于第二段音频的长度。

 输入描述:
 第一行一个整数n(1 ≤ n ≤ 1000)，表示第一段音频的长度。
 第二行n个整数表示第一段音频的音高（0 ≤ 音高 ≤ 1000）。
 第三行一个整数m(1 ≤ n ≤ m ≤ 1000)，表示第二段音频的长度。
 第四行m个整数表示第二段音频的音高（0 ≤ 音高 ≤ 1000）。


 输出描述:
 输出difference的最小值

 输入例子:
 2
 1 2
 4
 3 1 2 4

 输出例子:
 0
 * */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int al = in.nextInt();
            int[] arr = new int[al];
            for (int i = 0; i < al; i++) {
                arr[i] = in.nextInt();
            }

            int bl = in.nextInt();
            int[] brr = new int[bl];
            for (int i = 0; i < bl; i++) {
                brr[i] = in.nextInt();
            }

            System.out.println(getMinDifferfence(al, arr, bl, brr));
        }
    }

    private static int getMinDifferfence(int al, int[] arr, int bl, int[] brr) {
        int difference = Integer.MAX_VALUE;

        for (int i = 0; i < bl-al+1; i++) {
            int temp = 0;
            for (int j = i,k=0; j < bl&&k<al; j++,k++) {
                    temp += (arr[k]-brr[j])*(arr[k]-brr[j]);

            }
            if (difference>temp) difference = temp;
        }
        return difference;
    }
}
