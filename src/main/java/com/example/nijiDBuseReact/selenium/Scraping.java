package com.example.nijiDBuseReact.selenium;
import com.example.nijiDBuseReact.entity.Member;
import com.example.nijiDBuseReact.service.NijidbService;
import com.google.api.services.youtube.model.Channel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class Scraping{
    @Autowired
    private NijidbService njService;

    @Scheduled(cron = " 0 0 1 * * *", zone = "Asia/Tokyo")
    public void saveMemberInfo() throws IOException {
        Document document = Jsoup.connect("https://refined-itsukara-link.neet.love/livers").get();
        List<Member> memberList = new ArrayList<>();

        //System.out.println(document);
        Elements hrefs = document.select("a[href*=YouTube]");
        int idNum = 0;
        for (Element element: hrefs){
            Member member = new Member();
            String href = element.attr("href");
            member.setChannel_id(href.substring(32));
            member.setId(idNum);
            memberList.add(member);
            idNum++;
        }

        int num = 0;
        Elements names = document.select("div.flex-grow > p.ease-out");
        for (Element element: names){
            Member member = memberList.get(num);
            String name = element.text();
            member.setName(name);
            num++;
        }

        //名前とidをDBにセット
        for(Member member: memberList){
            String id = member.getChannel_id();
            String name = member.getName();
            njService.saveIdAndData(id, name);
        }

        List<Channel> channelInfoList = njService.getChannelInfo(memberList);
        njService.saveChannelInfo(channelInfoList, memberList);
        System.out.println("バッチが動きました！");
    }
}
