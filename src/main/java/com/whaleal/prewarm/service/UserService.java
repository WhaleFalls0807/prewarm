package com.whaleal.prewarm.service;

import com.whaleal.prewarm.entity.UserEntity;

/**
 * @AUTHOR LYZ
 * @CREATE 2022-03-17  11:40
 */
public interface UserService {

    UserEntity login(UserEntity userEntity);
}
