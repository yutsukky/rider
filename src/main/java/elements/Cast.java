package elements;

public class Cast {
    private final Integer id;
    private final String name;

    public Cast(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
