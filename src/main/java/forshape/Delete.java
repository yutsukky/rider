package forshape;

import org.jsoup.select.Elements;

public class Delete {
    public String deleteReference(Elements s){
        return s.text().replaceAll("\\[[0-9]+]","");
    }
}
