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
public class ElementsFactory {
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

    enum shapeElements {
        //bday("生年月日",);
    }
}
