package com.wanyi.health.controller;

import com.wanyi.health.entity.Article;
import com.wanyi.health.entity.Food;
import com.wanyi.health.repository.ArticleRepo;
import com.wanyi.health.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepo articleRepo;

    @PostMapping("/add")
    public Object addArticle(@RequestBody Article article) {
        LocalDateTime now = LocalDateTime.now();
        article.setCtime(now);
        articleRepo.save(article);
        return ResponseUtil.ok();
    }

    @PostMapping("/update")
    public Object updateArticle(@RequestParam String title, @RequestParam String content,
                             @RequestParam String level, @RequestParam Integer id) {
        articleRepo.updateArticle(title, content, level, id);
        return ResponseUtil.ok();
    }

    @GetMapping("/get")
    public Object getArticle(@RequestParam Integer id) {
        return ResponseUtil.ok(articleRepo.findById(id));
    }

    @DeleteMapping("/del")
    public Object delArticle(@RequestParam Integer id) {
        articleRepo.deleteById(id);
        return ResponseUtil.ok();
    }

    @GetMapping("/all")
    public Object getAll() {
        return ResponseUtil.ok(articleRepo.findAll());
    }
}
