package thoughtworks;


import java.util.Scanner;

/**
 * @Author yuxiao
 * @Date 2017-09-09
 * @Time 12:47
 */
public class Main {

    private static final String COUNT = "count";

    public static void main(String[] args)  {
        Place.init();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String command = in.nextLine();
            if (COUNT.equals(command)) {
                Order.calculate();
            } else {
                try {
                    Order.order(command);
                } catch (MyException e) {
                    System.out.println(e.getMessage());
                }

            }
        }
    }


}
