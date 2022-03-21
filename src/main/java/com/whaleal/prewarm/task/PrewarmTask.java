package com.whaleal.prewarm.task;

import com.whaleal.mars.core.Mars;
import com.whaleal.mars.core.query.Criteria;
import com.whaleal.mars.core.query.Query;
import com.whaleal.mars.core.query.Sort;
import com.whaleal.mars.session.QueryCursor;
import com.whaleal.prewarm.entity.UrlEntity;
import com.whaleal.prewarm.service.UrlService;
import com.whaleal.prewarm.util.HttpDealUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Dsec 定时任务类
 * @AUTHOR LYZ
 * @CREATE 2022-03-18  10:22
 */
@Component
@Slf4j
public class PrewarmTask {

    @Autowired
    private Mars mars;

    @Autowired
    private UrlService urlService;


    /**
     * 定时任务类，初始化五秒后执行，每五秒执行，定时处理数据库中未预热的url
     */
    @Scheduled(initialDelay = 5000L, fixedRate = 1000 * 5L)
    public void sendHostInfo() {

        Criteria status = Criteria.where("status").is(0);

        Query query = new Query(status);
        query.with(Sort.by(Sort.Direction.ASC,"createTime"));

        QueryCursor<UrlEntity> all = mars.findAll(query, UrlEntity.class);

        for (int i = 0; i < 1000; i++) {
            if(all.hasNext()){
                UrlEntity next = all.next();
                String url = next.getUrl();
//                urlService.execUrlOne(url);
                HttpDealUtil.preWarmUrl(url);
                System.out.println("预热了" + url);

            }
        }


    }

}
