package com.example.nijiDBuseReact.selenium;
import com.example.nijiDBuseReact.entity.Member;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Scraping {


    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://refined-itsukara-link.neet.love/livers").get();
        List<Member> memberList = new ArrayList<>();

        //System.out.println(document);
        Elements hrefs = document.select("a[href*=YouTube]");
        for (Element element: hrefs){
            Member member = new Member();
            String href = element.attr("href");
            member.setChannel_id(href.substring(32));
            memberList.add(member);
        }

        int num = 0;
        Elements names = document.select("div.flex-grow > p.ease-out");
        for (Element element: names){
            Member member = memberList.get(num);
            String name = element.text();
            member.setName(name);
            num++;
        }
        for(Member member: memberList){
            System.out.print(member.getChannel_id());
            System.out.println(member.getName());
        }
    }
}
