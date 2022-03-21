package com.whaleal.prewarm.entity;


import com.whaleal.mars.codecs.pojo.annotations.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.BsonType;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: jy
 * @Date: 2021/09/24
 * @desc 数据类基类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseMongoEntity implements Serializable {

    @Id(concreteClass = String.class)
    @Representation(BsonType.STRING)
    public String id;

    /**
     * 创建时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date createTime;

    /**
     * 更新时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date updateTime;



}
