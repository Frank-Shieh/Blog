package com.blog.core;

import com.blog.core.Bean.NBANews;
import com.blog.core.Dao.NBANewsRepository;
import com.blog.core.Service.NBANewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class databaseTests {

    @Autowired
    private NBANewsRepository nbaRepository;
    @Autowired
    private NBANewsService nbaNewsService;
    @Test
    public void test() throws Exception {
        // 创建2条记录
        nbaRepository.save(new NBANews("ttt", "ttt","123tt"));
        nbaNewsService.addNBANews("ttt", "ttt","123tt");
        System.out.println(nbaRepository.findByTitle("t"));
    }
}