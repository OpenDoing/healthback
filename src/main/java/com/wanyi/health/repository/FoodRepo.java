package com.wanyi.health.repository;

import com.wanyi.health.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface FoodRepo extends JpaRepository<Food, Integer> {

    @Modifying
    @Transactional
    @Query(value = "update food set food1= ?1 , food2=?2 , advice=?3, reason=?4 where id= ?5", nativeQuery = true)
    int updateFood( String food1,  String food2, String advice, String reason,Integer id);
}
