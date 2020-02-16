package com.blog.core.Controller;

import com.blog.core.Bean.NBANews;
import com.blog.core.Service.NBANewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@Api(value = "HelloWorld", description = "你好，世界！")
public class HelloWorldController {

    @Autowired
    private NBANewsService nbaNewsService;

    @ApiOperation(value = "申请世界！")
    @RequestMapping(value = "/helloWorld")
    public String helloWorld() {

        return "HelloWorld!";
    }

    @ApiOperation(value = "爬nba新闻！")
    @RequestMapping(value = "/climb")
    public String climbNews() {
        //扫描1-100页的新闻
        for (int i = 1; i <= 100; i++) {
            String url = "https://voice.hupu.com/nba/" + i;
            try {
                Document doc = Jsoup.connect(url).get();
                ArrayList<NBANews> newsList = new NBANewsCrawler().processNews(doc);
                for (NBANews item : newsList) {
                    System.out.println(item.toString());
                }
                nbaNewsService.addNBANewsList(newsList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "爬nba新闻！!";
    }
}