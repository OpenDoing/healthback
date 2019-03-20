package com.wanyi.health.repository;

import com.wanyi.health.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface VideoRepo extends JpaRepository<Video, Integer> {

    @Modifying
    @Transactional
    @Query(value = "update video set title= ?1 , path=?2 , category=?3 where id= ?4", nativeQuery = true)
    int updateVideo(String title, String path, String category, Integer id);

    List<Video> findVideosByCategory(String category);
}
