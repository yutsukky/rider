package controller;

import elements.Cast;
import elements.Intro;
import elements.News;
import elements.Title;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yuta_tsukioka on 2017/05/09.
 */
public class Output {
    public static void normalText(String t){
        System.out.println(t);
    }

    public static void titleText(Title t){
        System.out.println("ID:" + t.getId() + " " + t.getTitle());
    }

    public static void castText(Cast c){
        System.out.println("ID:" + c.getId() + " " + c.getName());
    }

    public static void introText(Intro i){
        System.out.println("[" + i.getSubject() + "] " + i.getObject());
    }

    public static void newsText(News n) {
        System.out.println( "(" + n.getDay() + ") " + n.getTitle());
        System.out.println(n.getDetail());
    }

    public static String enterText(String t) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        System.out.println(t);
        String str = br.readLine();
        return str;
    }
}