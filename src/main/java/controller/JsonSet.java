package controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonSet {
    public static JsonNode setJson(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readTree(new File("json/obog.json"));
        } catch (IOException e) {
            throw new RuntimeException("情報が読み込めませんでした.",e);
        }
    }
}
