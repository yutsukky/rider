package controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import elements.Title;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by yuta_tsukioka on 2017/04/24.
 */
public class TitleOut
{
    public String setTitles() throws IOException {

        List<Title> titleList;

        titleList = JsonToEntity.toTitle("Titles");

        titleList.stream().forEach(Output::titleText);

        String str = Output.enterText("上記のタイトル番号のいずれかを指定してください.");

        String selectTitle = titleList.stream()
                .filter(v -> v.getId().equals(Integer.parseInt(str)))
                .map(v -> v.getTitle())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Error"));

        Output.normalText( selectTitle + "が選択されました.");

        return selectTitle;
    }
}