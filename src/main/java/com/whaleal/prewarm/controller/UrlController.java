package com.whaleal.prewarm.controller;

import com.whaleal.prewarm.service.UrlService;
import com.whaleal.prewarm.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @AUTHOR LYZ
 * @CREATE 2022-03-17  11:43
 */
@RestController
@RequestMapping("/api/url")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/{userId}/save")
    public R saveUrl(@PathVariable("userId") String userId,
                     @RequestBody List<String> uriList){


        urlService.saveUrl(userId,uriList);

        return R.ok().put("data","添加成功");
    }

    @GetMapping("preWarm")
    public R preWarm(@RequestBody List<String> uriList){


        return R.ok();
    }

}
