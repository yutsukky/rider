package controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by yuta_tsukioka on 2017/05/09.
 */
public class JsonSet {
    public static JsonNode setJson(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readTree(new File("json/obog.json"));
        } catch (IOException e) {
            e.printStackTrace();
            Output.normalText("情報が読み込めませんでした.");
            throw new RuntimeException(e);
        }
    }
}
