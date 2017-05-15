package controller;

import elements.News;
import java.util.List;

public class NewsOut {
    public void getNews(String name) throws Exception {
        List<News> newsList = new NewsListFactory().getNewsList(name);
        Output.normalText("[News]");
        newsList.stream().forEach(Output::newsText);
    }
}
