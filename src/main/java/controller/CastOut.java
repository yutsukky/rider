package controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by yuta_tsukioka on 2017/04/25.
 */
public class CastOut {
    public String setCasts(String title) throws IOException
    {
        JsonNode root;
        HashMap<Integer, String> cast_hash = new HashMap<>();

        try
        {
            ObjectMapper mapper = new ObjectMapper();
            root = mapper.readTree(new File("json/obog.json"));

            for (JsonNode n : root.get("Casts")) {

                ArrayNode a = (ArrayNode) n.get("Title");
                a.iterator().forEachRemaining(
                        v -> {
                            if( v.asText().equals(title) ){
                                int id = n.get("Id").asInt();
                                String name = n.get("Name").asText();
                                System.out.println("ID:" + id + " " + name);
                                cast_hash.put( id, name);
                            }
                        }
                );
            }
        }
        catch(FileNotFoundException fe)
        {
            fe.printStackTrace();
            System.out.println("キャスト情報が読み込めませんでした.");
            System.exit(1);
        }

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        System.out.println("上記のキャスト番号を選択してください.");

        String str = br.readLine();

        String cast = cast_hash.get(Integer.parseInt(str));
        System.out.println( cast + "さんが選択されました.");

        return cast;
    }
}
