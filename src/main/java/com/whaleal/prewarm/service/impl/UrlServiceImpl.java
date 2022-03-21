package com.whaleal.prewarm.service.impl;

import com.whaleal.icefrog.core.lang.ObjectId;
import com.whaleal.mars.core.Mars;
import com.whaleal.prewarm.entity.UrlEntity;
import com.whaleal.prewarm.service.UrlService;
import com.whaleal.prewarm.util.HttpDealUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @AUTHOR LYZ
 * @CREATE 2022-03-17  11:41
 */
@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private Mars mars;

    @Async
    @Override
    public void saveUrl(String userId, List<String> urlList) {

        List<UrlEntity> urlEntityList = new ArrayList<>();

        for (String url : urlList){
            UrlEntity urlEntity = new UrlEntity();
            urlEntity.setUserId(userId);
            urlEntity.setStatus(0);
            ObjectId objectId = new ObjectId();
            urlEntity.setId(objectId.toString());
            urlEntity.setUrl(url);
            urlEntity.setCreateTime(new Date());
            urlEntity.setUpdateTime(new Date());
            urlEntityList.add(urlEntity);
        }

        System.out.println("当前线程为：" + Thread.currentThread());
        mars.save(urlEntityList);

//        return urlEntityList;

    }

    @Async
    @Override
    public void execUrl(List<String> url,String userId){

        List<UrlEntity> urlEntityList = new ArrayList<>();
        for (String u : url){
            UrlEntity urlEntity = HttpDealUtil.preWarmUrl(u);
            urlEntity.setUserId(userId);
            urlEntityList.add(urlEntity);
        }

        System.out.println("当前线程为：" + Thread.currentThread());

        mars.save(urlEntityList);

    }

    @Override
    public void execUrlOne(String url) {
        HttpDealUtil.preWarmUrl(url);
        System.out.println("当前线程为：" + Thread.currentThread());
    }


}
