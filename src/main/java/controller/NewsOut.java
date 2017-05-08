package controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by yuta_tsukioka on 2017/04/28.
 */
public class NewsOut {
    public void getNews(String name) throws Exception {
        if (name.equals("菅田将暉")) {
            Document doc = Jsoup.connect("http://www.topcoat.co.jp/artist/suda-masaki/news/").timeout(0).get();

            Elements news_tab = doc.select("ul[class=tabCont]");

            Iterator<Element> newsIte = news_tab.iterator();
            Stream<Element> targetStream = StreamSupport.stream(
                    Spliterators.spliteratorUnknownSize(newsIte, Spliterator.ORDERED), false);

            new ShapeElements().getNews(targetStream);
        }
    }
}
