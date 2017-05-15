package controller;

import elements.Intro;
import org.jsoup.select.Elements;

import java.util.*;

public class InfoOut {
    public void getInfo(String name) throws Exception {
        Elements infobox = JsoupSet.setJsoup("https://ja.wikipedia.org/wiki/" + name).select("table[class=infobox]");
        Elements tr = infobox.select("tr");

        List<Intro> introList = new IntroFactory().getIntro(StreamSet.makeStream(tr));
        introList.stream().forEach(Output::introText);

        Output.normalText("[主な出演作]");
        List<String> otherTitleList = new IntroFactory().getOtherTitles(StreamSet.makeStream(tr));
        otherTitleList.stream().forEach(Output::normalText);
    }
}
