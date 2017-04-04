package com.cloudin.commons.util;

import java.io.File;

/**
 * 文件路径相关工具方法
 * Created by YFHan on 2017/4/4 0004.
 */
public class Paths {

    private static String rootPath;


    /**
     * 获取类路径。<br>
     *     例如：E:/workspace/project_name/target/classes
     *
     * @return
     */
    public static String classPath() {
        if (rootPath == null) {
            rootPath = new File(Thread.currentThread().getContextClassLoader().getResource("").getPath())
                    .getAbsolutePath().replace('\\', '/');
        }
        return rootPath;
    }


    public static void main(String[] args) {
        System.out.println(classPath());

    }
}
