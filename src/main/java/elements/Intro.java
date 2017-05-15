package elements;

/**
 * Created by yuta_tsukioka on 2017/05/09.
 */
public class Intro {
    private String subject;
    private String object;

    public Intro(String s,String o){
        subject = s;
        object = o;
    }

    public String getSubject(){ return subject; }

    public String getObject(){ return object; }
}
