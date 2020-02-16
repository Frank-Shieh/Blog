package com.blog.core.ServiceImpl;

import com.blog.core.Bean.NBANews;
import com.blog.core.Dao.NBANewsRepository;
import com.blog.core.Service.NBANewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NBANewsServiceImpl implements NBANewsService {

    @Autowired
    NBANewsRepository nbaNewsRepository;


    @Override
    public void addNBANews(String title, String source, String link) {
        nbaNewsRepository.save(new NBANews(title, source, link));
    }

    @Override
    public void addNBANewsList(List<NBANews> list) {
        nbaNewsRepository.saveAll(list);
    }
}
