package com.wanyi.health.controller;

import com.wanyi.health.entity.Article;
import com.wanyi.health.entity.Video;
import com.wanyi.health.repository.ArticleRepo;
import com.wanyi.health.repository.VideoRepo;
import com.wanyi.health.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoRepo videoRepo;

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
}
