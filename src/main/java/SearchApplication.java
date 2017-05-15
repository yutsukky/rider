import controller.CastOut;
import controller.InfoOut;
import controller.NewsOut;
import controller.TitleOut;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by yuta_tsukioka on 2017/04/24.
 */
public class SearchApplication {
    public static void main(String[] arg) {
        //練習パート
        //System.out.println(hoge(Optional.of("aiueo")));
        //System.out.println(hoge(Optional.empty()));
        //練習パートここまで
        String selectTitle,selectCast;
        try {
            selectTitle = new TitleOut().setTitles();
            try {
                selectCast = new CastOut().setCasts(selectTitle);
                try {
                    new InfoOut().getInfo(selectCast);
                    new NewsOut().getNews(selectCast);
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

    public static String hoge(Optional<String> text) {
        return text.orElse("ヌルヌル");
    }
}
