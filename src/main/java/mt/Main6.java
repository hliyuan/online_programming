package mt;

/**
 * Created by liyuan on 2017/6/18.
 */



/**
 * 美团点评上有很多餐馆优惠券，用户可以在美团点评App上购买。每张优惠券有一个唯一的正整数编号。当用户在相应餐馆就餐时，可以在餐馆使用优惠券进行消费。优惠券的购买和使用按照时间顺序逐行记录在日志文件中，运营人员会定期抽查日志文件看业务是否正确。业务正确的定义为：一个优惠券必须先被购买，然后才能被使用。

 某次抽查时，发现有硬盘故障，历史日志中有部分行损坏，这些行的存在是已知的，但是行的内容读不出来。假设损坏的行可以是任意的优惠券的购买或者使用。

 现在问这次抽查中业务是否正确。若有错，输出最早出现错误的那一行，即求出最大s，使得记录1到s-1满足要求；若没有错误，输出-1。

 输入描述:
 m 分别表示 m (1 ≤ m ≤ 5 * 10^5) 条记录。

 下面有m行，格式为：

 I x （I为Input的缩写，表示购买优惠券x）；

 O x（O为Output的缩写，表示使用优惠券x）；

 ? （表示这条记录不知道）。

 这里x为正整数，且x ≤ 10^5 。


 输出描述:
 -1 或 x(1 ≤ x ≤ m) 其中x为使得1到x-1这些记录合法的最大行号。

 输入例子:
 0
 1
 O 1
 2
 ？
 O 1
 3
 I 1
 ？
 O 1
 2
 I 2
 O 1

 输出例子:
 -1
 1
 -1
 -1
 2
 *
 * */

import java.util.HashMap;
import java.util.Scanner;
public class Main6 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int m = in.nextInt();

            String[] string = new String[m];
            in.nextLine();
            for (int i = 0; i < m; i++) {
                string[i] = in.nextLine();

            }
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            System.out.println(identify(m, string,map));


        }
    }

    public static int identify(int m, String[] string,HashMap<String, Integer> map) {

        int unknown = 0;
        for (int i = 0; i < m; i++) {
            if (string[i].equals("?")) {
                unknown += 1;
                continue;
            }
            String[] split = string[i].split(" ");
 //           System.out.println(string[i]+"......"+split.length);
            String flag = split[0];
            String number = split[1];
            if (flag.equals("I")){
                if (map.containsKey(number)) {
                    map.clear();
                    return i + 1;
                }
                else
                    map.put(number,1);
            }else if (flag.equals("O")){
                if (map.containsKey(number)&&map.get(number)==1)
                    continue;
                else if (unknown>0){
                    unknown--;
                    continue;
                }
                else {
                    map.clear();
                    return i + 1;
                }
            }

        }
        map.clear();
        return -1;
    }


    public static int identify2(int m, String[] string) {
        HashMap<String, String> map = new HashMap<String, String>();
        int unknown = 0;
        for (int i = 0; i < m; i++) {
            if (string[i].equals("?")) {
                unknown += 1;
                continue;
            }
            String[] split = string[i].split(" ");
            System.out.println(string[i]+"......"+split.length);
            String flag = split[0];
            String number = split[1];
            if (map.containsKey(number)){
                if(map.get(number).equals("I"))
                    continue;
                else return i+1;
            }else if (!map.containsKey(number)&&flag.equals("O")){
                if (unknown>0) {
                    unknown--;
                    continue;
                }else
                    return i+1;
            }else
                map.put(number,flag);
        }
        return -1;
    }
}
