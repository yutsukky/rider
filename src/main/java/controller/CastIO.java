package controller;

import elements.Cast;
import java.io.*;
import java.util.List;

public class CastIO {
    public String setCasts(String title) throws IOException {
        List<Cast> castList;

        castList = JsonToEntity.toCast("Casts",title);

        castList.stream().forEach(Output::castText);

        String str = Input.enterText("上記のキャスト番号を選択してください.");

        String selectName = castList.stream()
                .filter(v -> v.getId().equals(Integer.parseInt(str)))
                .map(v -> v.getName())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Error"));

        Output.normalText( selectName + "さんが選択されました.");

        return selectName;
    }
}
