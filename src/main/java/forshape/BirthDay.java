package forshape;

import org.jsoup.select.Elements;
import java.time.LocalDate;
import java.time.Period;

public class BirthDay implements ForShapeIF {
    @Override
    public String getElements(Elements td){
        LocalDate birth_day;
        birth_day = LocalDate.parse(td.select("span[class=bday]").text());
        String year = String.valueOf(birth_day.getYear());
        String month = String.valueOf(birth_day.getMonthValue());
        String day = String.valueOf(birth_day.getDayOfMonth());
        Integer age = Period.between(birth_day,LocalDate.now()).getYears();
        return year + "年" + month + "月" + day + "日" + "(" + age + "歳)";
    }
}
