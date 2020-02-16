package com.blog.core.Controller;


import com.blog.core.Bean.NBANews;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class NBANewsCrawler  {
    public ArrayList<NBANews> processNews (Document doc){
        ArrayList<NBANews> newsList = new ArrayList<>();
        Elements elements = doc.getElementsByClass("news-list");
        for(Element element:elements){
            Elements list = element.select("ul").select("li");
            for (Element item:list){
                //解析新闻列表，获取标题，链接，来源
                Element titleItem = item.getElementsByClass("list-hd").select("h4").select("a").first();
                Element sourceItem = item.getElementsByClass("otherInfo").first();
                Element sourceElement = sourceItem.getElementsByClass("comeFrom").select("a").first();
                NBANews news = new NBANews(titleItem.text(),sourceElement.text(),titleItem.attr("href"));
                newsList.add(news);
            }
        }
        return newsList;
    }
}
