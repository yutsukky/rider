package controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yuta_tsukioka on 2017/04/27.
 */
public class ShapeElements {
    public String getElements(Elements th, Elements td){
        String shaped_td = td.text().replaceAll("\\[[0-9]+]","");
        if ( th.text().equals("生年月日") ){
            LocalDate birth_day;
            birth_day = LocalDate.parse(td.select("span[class=bday]").text());
            String year = String.valueOf(birth_day.getYear());
            String month = String.valueOf(birth_day.getMonthValue());
            String day = String.valueOf(birth_day.getDayOfMonth());
            Integer age = Period.between(birth_day,LocalDate.now()).getYears();
            shaped_td = year + "年" + month + "月" + day + "日" + "(" + age + "歳)";
        }
        return shaped_td;
    }

    public void getOtherTitles(Stream<Element> titles){
        System.out.println("[主な出演作]");
        List<String> list = new ArrayList<>();
        titles.forEach(
                v -> {
                    Pattern pat = Pattern.compile("『.+』");
                    Matcher m = pat.matcher(v.text());
                    while(m.find()){
                        String[] tmp_title = m.group().split("『");
                        for (String title: tmp_title) {
                            //System.out.println(title);
                            Pattern pat2 = Pattern.compile("(.+)』");
                            Matcher m2 = pat2.matcher(title);
                            while(m2.find()){
                                list.add("『" + m2.group());
                            }
                        }
                    }
                }
        );
        List<String> title_list = list.stream().distinct().collect(Collectors.toList());

        title_list.forEach(System.out::println);

    }

    public void getNews(Stream<Element> news_info){
        System.out.println("[News]");
        //Integer count = 0;
        news_info
                .map(Element::children)
                .forEach(
                        v -> {
                            Elements day = v.select("li[class=days]");
                            Elements title = v.select("h2");
                            Elements detail = v.select("li[class=tabBody]");
                            System.out.println( "(" + day.text() + ") " + title.text());
                            System.out.println(detail.text());
                        }
                );
    }
}
