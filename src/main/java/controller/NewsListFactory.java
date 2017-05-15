package controller;

import elements.News;
import fornews.MasakiSuda;
import fornews.ForNewsIF;
import fornews.Nothing;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by yuta_tsukioka on 2017/05/12.
 */
public class NewsListFactory {
    public List<News> getNewsList( String name ){
        Output.normalText("[News]");

        return Stream.of(whois.values())
                .filter( v -> v.name.equals(name))
                .findFirst().map(v -> v.factory)
                .orElse(new Nothing())
                .getNewsList();
    }

    enum whois {
        新八("菅田将暉", new MasakiSuda());
        final String name;
        final ForNewsIF factory;

        whois(String name, ForNewsIF factory) {
            this.name = name;
            this.factory = factory;
        }
    }
}
