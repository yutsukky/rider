package elements;

public class News {
    private String day;
    private String title;
    private String detail;

    public News(String day, String title,String detail){
        this.day = day;
        this.title = title;
        this.detail = detail;
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
