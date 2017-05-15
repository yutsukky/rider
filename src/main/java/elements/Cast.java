package elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuta_tsukioka on 2017/05/09.
 */
public class Cast {
    private Integer id;
    private String name;

    public Cast(Integer i, String n){
        id = i;
        name = n;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
