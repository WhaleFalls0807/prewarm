package com.whaleal.prewarm.controller;

import com.whaleal.prewarm.entity.UserEntity;
import com.whaleal.prewarm.util.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTHOR LYZ
 * @CREATE 2022-03-17  11:43
 */
@RestController
@RequestMapping("/api/user/")
public class UserController {


    @PostMapping("login")
    public R login(@RequestBody UserEntity userEntity){



        return R.ok().put("data","登陆成功");
    }
}
