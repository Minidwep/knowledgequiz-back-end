package com.sdjzu.knowledgequiz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.sdjzu.knowledgequiz.mapper"}) //扫描DAO
public class KnowledgeQuizApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnowledgeQuizApplication.class, args);
    }

}
