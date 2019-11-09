package top.suiyueran.user.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.*;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 2:21 2019/11/9
 * @Modifyed by:
 */
@Configuration
public class ScheduledConfiguration implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutors());
    }

    @Bean
    public Executor taskExecutors() {
        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(10, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        }, new ThreadPoolExecutor.AbortPolicy());
        return pool;
        //return Executors.newScheduledThreadPool(10);
    }
}
