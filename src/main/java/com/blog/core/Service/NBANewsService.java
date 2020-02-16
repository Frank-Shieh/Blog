package com.blog.core.Service;

import com.blog.core.Bean.NBANews;

import java.util.List;

public interface NBANewsService {
    void addNBANews(String title, String source, String link);
    void addNBANewsList(List<NBANews> list);
}
