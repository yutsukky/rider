package controller;

import elements.Intro;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yuta_tsukioka on 2017/04/27.
 */
public class IntroFactory {

    public List<Intro> getIntro(Stream<Element> tr_info){
        List<Intro> introList = new ArrayList<>();

        tr_info
                .map(Element::children)
                .filter(v -> !v.select("th[scope=row]").isEmpty() )
                .forEach(
                        v -> {
                            Elements th = v.select("th");
                            Elements td = v.select("td");
                            String shaped_td = new ElementsFactory().getElements(th,td);
                            Intro intro = new Intro(th.text(),shaped_td);
                            introList.add(intro);
                        }
                );

        return introList;
    }

    public List<String> getOtherTitles(Stream<Element> titles){
        Output.normalText("[主な出演作]");
        List<String> list = new ArrayList<>();
        titles.forEach(
                v -> {
                    Pattern pat = Pattern.compile("『.+』");
                    Matcher m = pat.matcher(v.text());
                    while(m.find()){
                        String[] tmp_title = m.group().split("『");
                        for (String title: tmp_title) {
                            Pattern pat2 = Pattern.compile("(.+)』");
                            Matcher m2 = pat2.matcher(title);
                            while(m2.find()){
                                list.add("『" + m2.group());
                            }
                        }
                    }
                }
        );
        return list.stream().distinct().collect(Collectors.toList());
    }
}
