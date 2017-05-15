package controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class JsoupSet {
    public static Document setJsoup(String s){
        try {
            return Jsoup.connect(s).timeout(0).get();
        } catch (IOException e) {
            throw new RuntimeException("情報が読み込めませんでした.",e);
        }
    }
}
