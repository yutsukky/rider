package forshape;

import org.jsoup.select.Elements;

/**
 * Created by yuta_tsukioka on 2017/05/15.
 */
public class Delete {
    public String deleteReference(Elements s){
        return s.text().replaceAll("\\[[0-9]+]","");
    }
}
