package com.whaleal.prewarm;

import com.whaleal.prewarm.service.UrlService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class PrewarmApplicationTests {

    @Autowired
    private UrlService urlService;

    @Test
    void contextLoads() {
    }


    @Test
    public void test(){
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            strings.add(i + "");
        }

        urlService.saveUrl("123456",strings);
        System.out.println(strings);
    }

}
