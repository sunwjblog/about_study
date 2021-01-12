package com.sunwjblog.firststatge.mybatis.handwritingframe.io;

import java.io.InputStream;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/12 1:04 下午
 */
public class Resource {

    /** * 根据配置文件路径，将配置文件加载成字节输入流，存储在内存中 * @param path * @return */
    public static InputStream getResourceAsStream(String path){

        InputStream inputStream = Resource.class.getClassLoader().getResourceAsStream(path);
        return inputStream;
    }
}
