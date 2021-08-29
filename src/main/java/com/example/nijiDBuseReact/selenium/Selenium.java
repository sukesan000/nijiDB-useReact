package com.example.nijiDBuseReact.selenium;

import com.example.nijiDBuseReact.entity.Member;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selenium {
    public static void main(String[] args) throws IOException {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver", "/Users/ooyamakousuke/Documents/git/nijiDB-useReact/Chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        String liver_url = "https://www.itsukaralink.jp/livers";
        List<Member> memberList = new ArrayList<>();


        driver.get(liver_url);

//        List<WebElement> livers = driver.findElements(By.className("liver"));
//        for(WebElement liver: livers){
//            WebElement fllContainer = liver.findElement(By.className("fllContainer"));
//            WebElement liverLinkBox = fllContainer.findElement(By.className("liver-linkBox"));
//            WebElement elm = driver.findElement(By.xpath("//a[contains(@href,'youtube')]"));
//            System.out.println(elm.getAttribute("href"));
//
//        }

        List<WebElement> names = driver.findElements(By.className("liver-followBoxText"));
        for (WebElement name: names){
            Member member = new Member();
            member.setName(name.getText());
            memberList.add(member);
        }

        List<WebElement> urls = driver.findElements(By.xpath("//a[contains(@href,'youtube')]"));
        int num = 0;
        for (WebElement url: urls){
            String url_ = url.getAttribute("href");
            int lastIndex = url_.indexOf("?");
            String chId = url_.substring(28,lastIndex);
            Member member = memberList.get(num);
            member.setChannel_id(chId);
            num++;
        }
        for(Member member_: memberList){
            System.out.print(member_.getName() + " ");
            System.out.println(member_.getChannel_id());
        }
        System.out.println(memberList.size());
        driver.quit();

    }
}
