package com.zxw.crawler.Most;

import com.zxw.pipeline.MostPipeline;
import com.zxw.processor.Most.MostBriefPageProcessor;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;

import javax.annotation.Resource;

@Component("MostListCrawler")
public class MostListCrawler {
    @Resource
    private MostBriefPageProcessor mostBriefPageProcessor;
    @Resource
    private MostPipeline mostPipeline;
    public void run() {
        Site site = Site.me().setCycleRetryTimes(20).setSleepTime(500).setTimeOut(5000)

                .setUserAgent("User-Agent:Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
        Spider spider = Spider.create(mostBriefPageProcessor)
                // .addPipeline(projectPipeLine);
                .addUrl("http://www.most.gov.cn/kjjh/xmsb/sbzj/")
                .addPipeline(mostPipeline);


        spider.run();
    }
}
