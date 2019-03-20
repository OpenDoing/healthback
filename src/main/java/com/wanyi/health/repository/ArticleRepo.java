package com.wanyi.health.repository;

import com.wanyi.health.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Integer> {

    @Modifying
    @Transactional
    @Query(value = "update article set title= ?1 , content=?2 , level=?3 where id= ?4", nativeQuery = true)
    int updateArticle( String title,  String content, String level, Integer id);

//    @Query(value = "SELECT * FROM article where level >= ?1", nativeQuery = true)
    List<Article> findArticlesByLevelIsGreaterThan(Integer level);
}
