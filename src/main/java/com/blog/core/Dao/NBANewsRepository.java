package com.blog.core.Dao;

import com.blog.core.Bean.NBANews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NBANewsRepository extends JpaRepository<NBANews, Integer>, JpaSpecificationExecutor<NBANews> {
    NBANews findById(int id);
    @Query(nativeQuery = true, value = "select * from news n where n.title like CONCAT('%',:t,'%') ")
    List<NBANews> findByTitle(@Param("t") String title);
}

