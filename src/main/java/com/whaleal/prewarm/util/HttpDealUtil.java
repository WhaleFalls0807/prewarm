package com.whaleal.prewarm.util;

import com.whaleal.icefrog.http.HttpRequest;
import com.whaleal.icefrog.http.HttpResponse;
import com.whaleal.icefrog.http.HttpUtil;
import com.whaleal.prewarm.entity.UrlEntity;

import java.util.Date;

/**
 * @AUTHOR LYZ
 * @CREATE 2022-03-20  20:43
 */
public class HttpDealUtil {


    public static UrlEntity preWarmUrl(String url){


        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setUrl(url);
        urlEntity.setCreateTime(new Date());
        urlEntity.setUpdateTime(new Date());

        HttpRequest httpRequest = HttpUtil.createGet(url);
//        httpRequest.setReadTimeout()

        long oldTime = System.currentTimeMillis();
        HttpResponse execute = httpRequest.execute();

        urlEntity.setResult_code(execute.getStatus());

        if(execute.isOk()){
            urlEntity.setStatus(2);
        }else {
            urlEntity.setStatus(3);
        }
        urlEntity.setExecTime(System.currentTimeMillis() - oldTime);
        urlEntity.setResult(execute.body());

        return urlEntity;
    }

    public static UrlEntity preWarmUrl(UrlEntity urlEntity){

        HttpRequest httpRequest = HttpUtil.createGet(urlEntity.getUrl());

        long l = System.currentTimeMillis();
        HttpResponse execute = httpRequest.execute();

        urlEntity.setStatus(execute.getStatus());
        urlEntity.setExecTime(System.currentTimeMillis() - l);

        if(execute.isOk()){
            urlEntity.setStatus(2);
        }else {
            urlEntity.setStatus(3);
        }

        return urlEntity;
    }

}
