package com.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Spring.xml");
        SingerSongs songs=(SingerSongs) applicationContext.getBean("song");
        System.out.println(songs);
    }
}
