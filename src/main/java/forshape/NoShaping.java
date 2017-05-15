package forshape;

import org.jsoup.select.Elements;

public class NoShaping implements ForShapeIF {
    @Override
    public String getElements(Elements td){
        return new Delete().deleteReference(td);
    }
}
