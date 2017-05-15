package controller;

import elements.Cast;
import elements.Intro;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by yuta_tsukioka on 2017/04/26.
 */
public class InfoOut {
    public void getInfo(String name) throws Exception {
        Elements infobox = JsoupSet.setJsoup("https://ja.wikipedia.org/wiki/" + name).select("table[class=infobox]");
        Elements tr = infobox.select("tr");

        List<Intro> introList = new IntroFactory().getIntro(StreamSet.makeStream(tr));
        introList.stream().forEach(Output::introText);

        List<String> otherTitleList = new IntroFactory().getOtherTitles(StreamSet.makeStream(tr));
        otherTitleList.stream().forEach(Output::normalText);
    }
}
