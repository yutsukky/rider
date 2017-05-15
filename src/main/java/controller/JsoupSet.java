package controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by yuta_tsukioka on 2017/05/09.
 */
public class JsoupSet {
    public static Document setJsoup(String s){
        try {
            return Jsoup.connect(s).timeout(0).get();
        } catch (IOException e) {
            e.printStackTrace();
            Output.normalText("情報が読み込めませんでした.");
            throw new RuntimeException(e);
        }
    }
}
