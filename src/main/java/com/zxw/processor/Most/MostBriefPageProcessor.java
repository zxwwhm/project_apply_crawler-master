package com.zxw.processor.Most;

import com.zxw.entity.Information;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

@Component
public class MostBriefPageProcessor implements PageProcessor {

    @Override
    public void process(Page page) {
        page.setCharset("UTF-8");
        String html = page.getHtml().toString();
        Document document = Jsoup.parse(html);


        /*Elements content=document.select("#content_doc > table:nth-child(3)> tbody > tr > td > div >a");
        List<Information> informationList=new ArrayList<>();
        System.out.println("1111111");
        String title=document.select("#content_doc > table:nth-child(3)>a").text().trim();
        System.out.println(title);
        String url="http://www.most.gov.cn"+content.attr("href");

        Information information=new Information(title,url);

        informationList.add(information);*/
       //#content_doc > table:nth-child(2) > tbody > tr > td:nth-child(2) > div > a

      Elements requests=document.select("#content_doc > table > tbody > tr > td:nth-child(2) > div");
       System.out.println("-----------------");
      // requests=requests.remove(1).getAllElements();

        List<Information> informationList=new ArrayList<>();
        for (Element e:requests
                ) {
                System.out.println("444444");
                Elements content = e.select("a");
            String title = content.text().trim();
            System.out.println(title);
                String url = "http://www.nsfc.gov.cn" + content.attr("href");



                Information information = new Information(title, url);
                informationList.add(information);

            }

        if(!informationList.isEmpty()){
            page.putField("informationLists",informationList);
        }
    }

    @Override
    public Site getSite() {
        return Site.me()
                .setRetryTimes(3)
                .setSleepTime(500)
                .setCharset("utf-8")
                .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/604.3.5 (KHTML, like Gecko) Version/11.0.1 Safari/604.3.5");
    }
    public static void main(String[] args) {
        Spider spider = Spider.create(new MostBriefPageProcessor());
        spider.addUrl("http://www.most.gov.cn/kjjh/xmsb/sbzj/");
        spider.run();
    }
}
//#content_doc
//#content_doc > table:nth-child(3) > tbody > tr > td:nth-child(2) > div
//#content_doc > table:nth-child(6)
//#content_doc
//#content_doc > table:nth-child(2) > tbody
//#content_doc
//#content_doc > table:nth-child(2)
//#content_doc > table:nth-child(2)
//#content_doc > table.black
//body > table:nth-child(15) > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > div:nth-child(2)