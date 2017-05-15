package controller;

import elements.Title;
import java.io.*;
import java.util.List;

public class TitleIO
{
    public String setTitles() throws IOException {

        List<Title> titleList;

        titleList = JsonToEntity.toTitle("Titles");

        titleList.stream().forEach(Output::titleText);

        String str = Input.enterText("上記のタイトル番号のいずれかを指定してください.");

        String selectTitle = titleList.stream()
                .filter(v -> v.getId().equals(Integer.parseInt(str)))
                .map(v -> v.getTitle())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Error"));

        Output.normalText( selectTitle + "が選択されました.");

        return selectTitle;
    }
}