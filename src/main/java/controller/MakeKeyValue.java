package controller;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Created by yuta_tsukioka on 2017/04/27.
 */
public class MakeKeyValue {

    public HashMap<String ,String > setKeyValue(Stream<Element> tr_info){
        HashMap<String, String> info_hash = new HashMap<>();

        tr_info
                .map(Element::children)
                .filter(v -> !v.select("th[scope=row]").isEmpty() )
                .forEach(
                        v -> {
                            Elements th = v.select("th");
                            Elements td = v.select("td");
                            String shaped_td = new ShapeElements().getElements(th,td);
                            System.out.println("[" + th.text() + "] " + shaped_td);
                        }
                );

        return info_hash;
    }
}
