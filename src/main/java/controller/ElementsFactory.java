package controller;

import fornews.Nothing;
import forshape.BirthDay;
import forshape.ForShapeIF;
import forshape.NoShaping;
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
        return Stream.of(shapeElements.values())
                .filter( v -> v.type.equals(th.text()))
                .findFirst().map(v -> v.factory)
                .orElse(new NoShaping())
                .getElements(td);
    }

    enum shapeElements {
        bday("生年月日",new BirthDay());

        final String type;
        final ForShapeIF factory;

        shapeElements(String type, ForShapeIF factory){
            this.type = type;
            this.factory = factory;
        }
    }
}
