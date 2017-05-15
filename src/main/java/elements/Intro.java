package elements;

public class Intro {
    private String subject;
    private String object;

    public Intro(String subject,String object){
        this.subject = subject;
        this.object = object;
    }

    public String getSubject(){ return subject; }

    public String getObject(){ return object; }
}
