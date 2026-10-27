package com.zone01.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class BlogApplication{
    public static void main(String[] args){
        System.out.println(args);
        SpringApplication.run(BlogApplication.class, args);
    }
}