import controller.CastOut;
import controller.InfoOut;
import controller.NewsOut;
import controller.TitleOut;
import java.io.IOException;

/**
 * Created by yuta_tsukioka on 2017/04/24.
 */
public class SearchApplication {
    public static void main(String[] arg) {
        //練習パート
        /*
        //テストテスト
        Iterator<String> sourceIterator = Arrays.asList("A", "B", "C").iterator();
        System.out.println(sourceIterator.getClass().getSimpleName());
        Stream<String> targetStream = StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(sourceIterator, Spliterator.ORDERED),
                false);
        targetStream.filter(v -> v.contains("B")).map(v -> "p"+v).forEach(v -> System.out.println(v));
        */
        //練習パートここまで
        String title,cast;
        try {
            title = new TitleOut().setTitles();
            try {
                cast = new CastOut().setCasts(title);
                try {
                    new InfoOut().getInfo(cast);
                    new NewsOut().getNews(cast);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
