package controller;

import forshape.BirthDay;
import forshape.ForShapeIF;
import forshape.NoShaping;
import org.jsoup.select.Elements;
import java.util.stream.Stream;

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
