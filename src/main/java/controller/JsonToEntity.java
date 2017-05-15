package controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import elements.Cast;
import elements.Title;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuta_tsukioka on 2017/05/09.
 */
public class JsonToEntity {
    public static List<Title> toTitle(String s) {
        List<Title> titleList = new ArrayList<>();
        JsonNode root = JsonSet.setJson();
        for (JsonNode n : root.get(s)) {
            Title title = new Title(n.get("Id").asInt(),n.get("Title").asText());
            titleList.add(title);
        }
        return titleList;
    }

    public static List<Cast> toCast(String s,String t){
        List<Cast> castList = new ArrayList<>();
        JsonNode root = JsonSet.setJson();
        for (JsonNode n : root.get(s)) {
            ArrayNode a = (ArrayNode) n.get("Title");
            a.iterator().forEachRemaining(
                    v -> {
                        if( v.asText().equals(t) ){
                            Cast cast = new Cast(n.get("Id").asInt(),n.get("Name").asText());
                            castList.add(cast);
                        }
                    }
            );
        }
        return castList;
    }
}
