package controller;

import elements.News;
import java.util.List;

/**
 * Created by yuta_tsukioka on 2017/04/28.
 */
public class NewsOut {
    public void getNews(String name) throws Exception {
        List<News> newsList = new NewsListFactory().getNewsList(name);
        newsList.stream().forEach(Output::newsText);
    }
}
