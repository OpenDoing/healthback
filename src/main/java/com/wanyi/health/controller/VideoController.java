package com.wanyi.health.controller;

import com.wanyi.health.entity.Article;
import com.wanyi.health.entity.Likev;
import com.wanyi.health.entity.Video;
import com.wanyi.health.repository.ArticleRepo;
import com.wanyi.health.repository.LikevRepo;
import com.wanyi.health.repository.VideoRepo;
import com.wanyi.health.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoRepo videoRepo;

    @Autowired
    private LikevRepo likevRepo;

    @PostMapping("/add")
    public Object addVideo(@RequestBody Video video) {
        videoRepo.save(video);
        return ResponseUtil.ok();
    }

    @PostMapping("/update")
    public Object updateVideo(@RequestParam String title, @RequestParam String path,
                             @RequestParam String category, @RequestParam Integer id) {
        videoRepo.updateVideo(title, path, category, id);
        return ResponseUtil.ok();
    }

    @GetMapping("/get")
    public Object getVideo(@RequestParam Integer id) {
        return ResponseUtil.ok(videoRepo.findById(id));
    }

    @DeleteMapping("/del")
    public Object delVideo(@RequestParam Integer id) {
        videoRepo.deleteById(id);
        return ResponseUtil.ok();
    }

    @GetMapping("/all")
    public Object getAllVideo() {
        return ResponseUtil.ok(videoRepo.findAll());
    }

    @PostMapping("/like")
    public Object LikeVideo(@RequestParam Integer userId, @RequestParam String category) {
        if (likevRepo.findLikevByUserIdAndCategory(userId, category) == null) {
            likevRepo.insertLike(userId, category, 1);
        }else {
            Likev raw = likevRepo.findLikevByUserIdAndCategory(userId, category);
            int t = raw.getCount();
            t = t + 1;
            raw.setCount(t);
            likevRepo.save(raw);
        }
        return ResponseUtil.ok();
    }



    @GetMapping("/category")
    public Object getLikeVideo(@RequestParam Integer userId) {
        //1.按照userid和分类查询结果
        List<Likev> likevs = likevRepo.findLikevsByUserId(userId);
        int temp = 0;
        String category = "";
        for (Likev likev: likevs) {
            if (likev.getCount() > temp) {
                temp = likev.getCount();
                category = likev.getCategory();
            }
        }
        return ResponseUtil.ok(videoRepo.findVideosByCategory(category));
    }
}
