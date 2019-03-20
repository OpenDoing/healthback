package com.wanyi.health.repository;

import com.wanyi.health.entity.LikeKey;
import com.wanyi.health.entity.Likev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface LikevRepo extends JpaRepository<Likev,Integer> {

    Likev findLikevByUserIdAndCategory(Integer userId, String category);
    List<Likev> findLikevsByCategory(String category);
    List<Likev> findLikevsByUserId(Integer id);
    @Modifying
    @Transactional
    @Query(value = "INSERT  INTO likev(user_id,category,count) VALUES (?1,?2,?3)", nativeQuery = true)
    int insertLike(Integer userId, String category, Integer count);

    @Modifying
    @Transactional
    @Query(value = "UPDATE likev SET user_id=?1,category=?2,count=?3", nativeQuery = true)
    int updateLike(Integer userId, String category, Integer count);
}
