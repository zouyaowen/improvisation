package top.suiyueran.user.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 3:29 2019/11/10
 * @Modifyed by:
 */
@Component
@Slf4j
public class InitRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("系统启动完毕");
    }
}
