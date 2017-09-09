package thoughtworks;

/**
 * @Author yuxiao
 * @Date 2017-09-09
 * @Time 12:51
 */
public class Area {

    private String area; // 场地A, B, C, D
    private Integer  begin;
    private Integer end;
    private Integer price; // 这里直接用的int，最好用bigDecimal
    private Boolean isWeekday; // 工作日和周末

    public Area() {
    }

    public Area(String area, Integer begin, Integer end, Integer price, Boolean isWeekday) {
        this.area = area;
        this.begin = begin;
        this.end = end;
        this.price = price;
        this.isWeekday = isWeekday;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getWeekday() {
        return isWeekday;
    }

    public void setWeekday(Boolean weekday) {
        isWeekday = weekday;
    }
}
