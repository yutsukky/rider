package controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import elements.Cast;
import elements.Title;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yuta_tsukioka on 2017/04/25.
 */
public class CastOut {
    public String setCasts(String title) throws IOException {
        List<Cast> castList;

        castList = JsonToEntity.toCast("Casts",title);

        castList.stream().forEach(Output::castText);

        String str = Output.enterText("上記のキャスト番号を選択してください.");

        String selectName = castList.stream()
                .filter(v -> v.getId().equals(Integer.parseInt(str)))
                .map(v -> v.getName())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Error"));

        Output.normalText( selectName + "さんが選択されました.");

        return selectName;
    }
}
