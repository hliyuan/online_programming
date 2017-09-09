package thoughtworks;

import java.util.*;

/**
 * @Author yuxiao
 * @Date 2017-09-09
 * @Time 15:19
 */
public class Place {

    private static Map<String, Map<String, List<Area>>> areaInfo = new HashMap<String, Map<String, List<Area>>>();

    public static void init() {
        HashMap<String, List<Area>> map = new HashMap<String, List<Area>>();
        String[] places = new String[]{"A", "B", "C", "D"};
        for (String place : places) {
            List<Area> list = new ArrayList<Area>();
            list.add(new Area(place, 9, 12, 30, true));
            list.add(new Area(place, 12, 18, 50, true));
            list.add(new Area(place, 18, 20, 80, true));
            list.add(new Area(place, 20, 22, 60, true));
            list.add(new Area(place, 9, 12, 40, false));
            list.add(new Area(place, 12, 18, 50, false));
            list.add(new Area(place, 18, 22, 60, false));
            map.put(place, list);
        }
        areaInfo.put("default", map); // 默认场馆
    }

    public static Map<String, Map<String, List<Area>>> getMap() {
        return Collections.unmodifiableMap(areaInfo);
    }


}
