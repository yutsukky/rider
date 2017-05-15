package controller;

import elements.News;
import fornews.MasakiSuda;
import fornews.ForNewsIF;
import fornews.Nothing;
import java.util.List;
import java.util.stream.Stream;

public class NewsListFactory {
    public List<News> getNewsList( String name ){
        return Stream.of(Cast.values())
                .filter( v -> v.name.equals(name))
                .findFirst().map(v -> v.factory)
                .orElse(new Nothing())
                .getNewsList();
    }

    enum Cast {
        新八("菅田将暉", new MasakiSuda());
        final String name;
        final ForNewsIF factory;

        Cast(String name, ForNewsIF factory) {
            this.name = name;
            this.factory = factory;
        }
    }
}
