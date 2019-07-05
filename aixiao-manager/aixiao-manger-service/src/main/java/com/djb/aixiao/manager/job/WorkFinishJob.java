package com.djb.aixiao.manager.job;

import com.djb.aixiao.manager.service.WorkService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/** 定时将超时的作业状态 变为完成
 * @author djb
 * @create 2019-05-27 13:38
 */
public class WorkFinishJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        //获取spring容器
        ApplicationContext applicationContext = (ApplicationContext) context.getJobDetail().getJobDataMap().get("applicationContext");
        //运行实现类
        applicationContext.getBean(WorkService.class).updateworkStatusByCloseTime();
    }
}
