package controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.HashMap;

/**
 * Created by yuta_tsukioka on 2017/04/24.
 */
public class TitleOut
{
    public String setTitles() throws IOException
    {
        JsonNode root;
        HashMap<Integer, String> title_hash = new HashMap<Integer, String>();
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            root = mapper.readTree(new File("json/obog.json"));
            for (JsonNode n : root.get("Titles")) {
                int id = n.get("Id").asInt();
                String title = n.get("Title").asText();
                System.out.println("ID:" + id + " " + title);
                title_hash.put( id, title);
            }
        }
        catch(FileNotFoundException fe)
        {
            fe.printStackTrace();
            System.out.println("タイトル情報が読み込めませんでした.");
            System.exit(1);
        }

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        System.out.println("上記のタイトル番号のいずれかを指定してください.");
        String str = br.readLine();

        String title = title_hash.get(Integer.parseInt(str));
        System.out.println( title + "が選択されました.");

        return title;
    }
}