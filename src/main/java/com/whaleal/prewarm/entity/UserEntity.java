package com.whaleal.prewarm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @AUTHOR LYZ
 * @CREATE 2022-03-17  11:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class UserEntity extends BaseMongoEntity{

    private String username;

    private String nickname;

    private String password;


}
