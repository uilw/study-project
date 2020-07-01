package com.liuw.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Liuw
 */
 @Configuration
 // @EnableScheduling
 @Slf4j
public class StaticScheduleTask {

    /**
     * 定时任务
     * 没5秒执行一次
     */
    @Scheduled(cron = "0/5 * * * * ?")
    private void configureTasks() throws Exception {
        log.info("--定时任务---{}------",LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}