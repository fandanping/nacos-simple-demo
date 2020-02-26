package com.nacos;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @description: 修改密码工具类
 * @author: fandp
 * @create: 2020-02-25 11:23
 **/
public class PasswordEncoderUtil {
    public static void main(String[] args){
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
    //如果想把密码修改为123，则 先执行此程序
    // 将程序执行的结果更新到数据库user表中
}
