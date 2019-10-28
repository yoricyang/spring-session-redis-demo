package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * description:TODO
 *
 * @version 1.0
 * @author: xianbang.yang
 * @date: 2019/10/24 16:05
 */
@SpringBootApplication
public class AppMain  extends SpringBootServletInitializer {
    public static void main(String[] args){
        SpringApplication.run(AppMain.class, args);
    }

    /**
     * 为了打包springboot项目
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
