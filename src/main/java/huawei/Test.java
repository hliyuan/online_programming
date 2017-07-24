package huawei;

import java.util.Scanner;
import java.util.Stack;


/**
 * Created by liyuan on 2017/6/28.
 */
public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){

            String s = in.nextLine();
            StringBuffer news = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                char character = s.charAt(i);
                if ((character>='a'&&character<='z')||(character>='A'&&character<='Z'))
                    news.append(character);
                else
                    news.append(" ");



            }


            String[] strings = news.toString().split(" ");

            Stack stack = new Stack();
            for (int i = 0; i < strings.length ; i++) {
                if (strings[i].equals("")) continue;

                stack.push(strings[i]);

            }
            StringBuffer stringBuffer = new StringBuffer();
            int m = stack.size();

            for (int i = 0; i < m; i++) {
                if(i!=m-1) {
                    stringBuffer.append(stack.pop());
                    stringBuffer.append(" ");
                }else {
                    stringBuffer.append(stack.pop());
                }
            }

            System.out.println(stringBuffer.toString());

        }
    }
}
