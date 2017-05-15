package fornews;

import elements.News;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuta_tsukioka on 2017/05/12.
 */
public class Nothing implements ForNewsIF {
    @Override
    public List<News> getNewsList(){
        List<News> newsList = new ArrayList<>();
        News news = new News("Empty", "This cast don't have News", " ");
        newsList.add(news);
        return newsList;
    }
}
