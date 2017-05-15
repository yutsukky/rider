package elements;

/**
 * Created by yuta_tsukioka on 2017/05/12.
 */
public class News {
    private String day;
    private String title;
    private String detail;

    public News(String da, String t,String de){
        day = da;
        title = t;
        detail = de;
    }

    public String getDay(){
        return day;
    }

    public String getTitle(){
        return title;
    }

    public String getDetail(){
        return detail;
    }
}
