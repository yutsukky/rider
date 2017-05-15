package elements;

public class Title {
    private final Integer id;
    private final String title;

    public Title(Integer id, String title){
        this.id = id;
        this.title = title;
    }

    public Integer getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }
}
