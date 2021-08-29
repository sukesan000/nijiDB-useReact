package com.example.nijiDBuseReact.scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class GetMemberInfo {
    public static void main(String[] args) throws IOException{
        String url = "https://vtuber-post.com/database/detail_group.php?groupId=tUSNnDmdaR";
        Document document = Jsoup.connect(url).get();
        //ßSystem.out.println(document.html());

        Element member_list = document.getElementById("vtuber_list");
        for (Element e : document.select("p.name")) {
                System.out.println(e.text());
        }
    }
}
