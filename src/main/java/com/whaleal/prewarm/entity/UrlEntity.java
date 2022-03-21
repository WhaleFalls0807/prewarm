package com.whaleal.prewarm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @AUTHOR LYZ
 * @CREATE 2022-03-17  11:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class UrlEntity extends BaseMongoEntity{

    /**
     * 用户id
     */
    private String userId;

    /**
     * 请求的url
     */
    private String url;

    /**
     * url状态
     * 0：待预热
     * 1：正在预热中
     * 2：预热结束（正常）
     * 3：预热结束（失败）
     */
    private int status;

    /**
     * 请求时间
     */
    private long execTime;

    /**
     * 响应码
     */
    private int result_code;

    /**
     * 执行结果
     */
    private String result;
}
