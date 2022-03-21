package com.whaleal.prewarm.service;

import com.whaleal.prewarm.entity.UrlEntity;

import java.util.List;

/**
 * @AUTHOR LYZ
 * @CREATE 2022-03-17  11:40
 */
public interface UrlService {

    void saveUrl(String userId, List<String> urlList);

    void execUrl(List<String> urlList,String userId);

    void execUrlOne(String url);

}
