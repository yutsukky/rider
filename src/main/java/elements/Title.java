package elements;

import java.util.HashMap;

/**
 * Created by yuta_tsukioka on 2017/05/09.
 */
public class Title {
    private Integer id;
    private String title;
    private HashMap<Integer, String> title_hash = new HashMap<>();

    public Title(Integer i, String t){
        id = i;
        title = t;
    }

    public Integer getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }
}
