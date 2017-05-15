package forshape;

import org.jsoup.select.Elements;

/**
 * Created by yuta_tsukioka on 2017/05/15.
 */
public class NoShaping implements ForShapeIF {
    @Override
    public String getElements(Elements td){
        return new Delete().deleteReference(td);
    }
}
