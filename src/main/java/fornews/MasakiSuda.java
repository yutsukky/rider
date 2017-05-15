package fornews;

import controller.JsoupSet;
import controller.StreamSet;
import elements.News;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuta_tsukioka on 2017/05/12.
 */
public class MasakiSuda implements ForNewsIF {
    @Override
    public List<News> getNewsList(){
        List<News> newsList = new ArrayList<>();
        Elements news_tab = JsoupSet.setJsoup("http://www.topcoat.co.jp/artist/suda-masaki/news/").select("ul[class=tabCont]");
        StreamSet.makeStream(news_tab)
                .map(Element::children)
                .forEach(
                        v -> {
                            News news = new News(v.select("li[class=days]").text(),
                                    v.select("h2").text(),
                                    v.select("li[class=tabBody]").text());
                            newsList.add(news);
                        }
                );
        return newsList;
    }
}
