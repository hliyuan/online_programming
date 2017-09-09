package thoughtworks;

import com.sun.org.apache.regexp.internal.RE;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author yuxiao
 * @Date 2017-09-09
 * @Time 14:05
 */
public class Order {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static Map<String, Map<String, List<Request>>> orders = new HashMap<String, Map<String, List<Request>>>();

    public static void order(String command) throws MyException {
        Request request = null;

            request = constructRequest(command);
            System.out.println("Success: the booking is accepted!");


    }

    private static Request constructRequest(String command) throws MyException {
        String[] arrays = command.split(" ");
        int length = arrays.length;
        if (length < 4 || length > 5) {
            throw new MyException("Error: the booking is invalid!");
        }
        Request request = new Request();
        request.setUserId(arrays[0]);
        request.setTime(arrays[1]);

        // 这里不能预订之前的
        DateTime dateTime = new DateTime(arrays[1]);
        if (!dateTime.isAfter(DateTime.now())) {
            throw new MyException("Error: the booking is invalid!");
        }

        // 这里应该有对时间格式的判断，没写
        String[] split = arrays[2].split("~");
        // 如果起始和结束时间一致
        if (split[0].equals(split[1])) {
            throw new MyException("Error: the booking is invalid!");
        }
        String[] begins = split[0].split(":");
        String[] ends = split[1].split(":");
        // 不以整点开始
        if (!"00".equals(begins[1]) || !"00".equals(ends[1])) {
            throw new MyException("Error: the booking is invalid!");
        }
        request.setBegin(Integer.parseInt(begins[0]));
        request.setEnd(Integer.parseInt(ends[0]));
        request.setArea(arrays[3]);
        String flag = length == 5 ? arrays[4] : null;
        if (flag != null && !"C".equals(flag)) {
            throw new MyException("Error: the booking is invalid!");
        }

        request.setCancel("C".equals(flag));


        //是否已被预订
        Map<String, List<Request>> requestMap = orders.get(request.getAreaName());
        if (requestMap == null) {
            if (request.isCancel()) {
                throw new MyException("Error: the booking being cancelled does not exit!");

            }
            requestMap = new HashMap<String, List<Request>>();
            ArrayList<Request> list = new ArrayList<Request>();
            list.add(request);
            requestMap.put(request.getArea(), list);
        } else {
            List<Request> list = requestMap.get(request.getArea());
            if (list == null) {
                if (request.isCancel()) {
                    throw new MyException("Error: the booking being cancelled does not exit");

                }
                list = new ArrayList<Request>();
                list.add(request);
                requestMap.put(request.getArea(), list);
            } else {
                for (Request tmp : list) {
                    if (tmp.getTime().equals(request.getTime())) {
                        // 判断是否重复预订
                        /**待修复
                         * 时间区间判断
                         * */
                        if ((tmp.getBegin() <= request.getBegin() && request.getBegin() <= tmp.getEnd()) ||
                                (tmp.getEnd() >= request.getEnd()&&request.getEnd() >= tmp.getBegin())) {

                            throw new MyException("Error: the booking conflicts with existing bookings");
                        }
                    }
                }
                list.add(request);
            }
        }



        // 不为取消信息，需要计算价格
        if (flag == null) {
            Map<String, Map<String, List<Area>>> map = Place.getMap();
            boolean isWeekDay = isWeekday(request.getTime());
            int price = 0;
            for (Area area : map.get(request.getAreaName()).get(request.getArea())) {
                if (isWeekDay) {
                    // 工作日价格
                    if (area.getWeekday()) {
                        price += getPrice(area, request);
                    }
                } else {

                    if (!area.getWeekday()) {
                        price += getPrice(area, request);
                    }
                }
            }
            request.setTotalPrice(price);
            double penalty = isWeekDay ? price * 0.5 : price * 0.25;
            request.setPenalty(penalty);
        }

        orders.put(request.getAreaName(),requestMap);
        return request;
    }

    private static int getPrice(Area area, Request request) {
        int price = 0;
        Integer areaBegin = area.getBegin();
        Integer areaEnd = area.getEnd();
        Integer requestBegin = request.getBegin();
        Integer requestEnd = request.getEnd();
        // 1. requestBegin <= areaBegin, 从当前areaBegin开始计算


        /**
         * 价格计算逻辑有问题
         *
         * */
        if (requestBegin <= areaBegin) {

            // 1. requestEnd <= areaEnd
            if (requestEnd <= areaEnd) {
                price += area.getPrice() * (requestEnd - areaBegin);
            } else { // 2. end > areaEnd
                price += area.getPrice() * (areaEnd - areaBegin);
            }
        }
        // 2. requestBegin > areaBegin && requestBegin < areaEnd
        if (areaBegin < requestBegin && areaEnd > requestBegin) {
            // 1. requestEnd <= areaEnd
            if (requestEnd <= areaEnd) {
                price += area.getPrice() * (requestEnd - requestBegin);
            } else { // 2. end > areaEnd
                price += area.getPrice() * (areaEnd - requestBegin);
            }
        }
        return price;
    }

    private static boolean isWeekday(String date)   {
        try {
            Date parse = null;
            parse = sdf.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(parse);
            int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (week == 6 || week == 0) {
                return false;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;


    }

    // 统计打印信息，这里需要合并时间..
    public static void calculate() {
        System.out.println("收入汇总");
        System.out.println("---");
        System.out.println("场地:A");
        List<Request> requests = orders.get("default").get("A");
        int totaltotalprice = 0;
        for (Request request: requests
             ) {
            System.out.println(request.getTime()+" "+request.getBegin()+":00~"+request.getEnd()+":00 "+request.getArea()+" "+request.getTotalPrice()+"元");

            totaltotalprice += request.getTotalPrice();
        }
        System.out.println("小计:"+totaltotalprice+"元");


    }


}
