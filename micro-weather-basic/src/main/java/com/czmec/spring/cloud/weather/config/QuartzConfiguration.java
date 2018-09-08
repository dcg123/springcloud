package com.czmec.spring.cloud.weather.config;


import com.czmec.spring.cloud.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {
    private static final int TIME = 1800; // 更新频率


    //定义定时任务具体需要做什么

    @Bean
    public JobDetail weatherDataSyncJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("WeatherDataSyncJob")
                .storeDurably().build();
    }

    //触发定时任务条件

    @Bean
    public Trigger weatherDataSyncTrigger(){
        SimpleScheduleBuilder simpleScheduleBuilder=SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(TIME)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail()).withIdentity("weatherDataSyncTrigger")
                .withSchedule(simpleScheduleBuilder).build();
    }


}
