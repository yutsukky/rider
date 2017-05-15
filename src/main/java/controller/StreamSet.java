package controller;

import org.jsoup.nodes.Element;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.jsoup.select.Elements;

public class StreamSet {
    public static Stream<Element> makeStream(Elements e){
        Iterator<Element> ite = e.iterator();
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(ite, Spliterator.ORDERED), false);
    }
}
