package controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by yuta_tsukioka on 2017/04/26.
 */
public class InfoOut {
    public void getInfo(String name) throws Exception {
        Document doc = Jsoup.connect("https://ja.wikipedia.org/wiki/" + name).timeout(0).get();

        Elements infobox = doc.select("table[class=infobox]");
        Elements tr = infobox.select("tr");

        Iterator<Element> infoIte = tr.iterator();
        Stream<Element> targetStream = StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(infoIte, Spliterator.ORDERED), false);

        Iterator<Element> secondIte = tr.iterator();
        Stream<Element> secondStream = StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(secondIte, Spliterator.ORDERED), false);

        new MakeKeyValue().setKeyValue(targetStream);
        new ShapeElements().getOtherTitles(secondStream);

        //System.out.println("InfoOutスクレイピング" + tr.text());
    }
}
