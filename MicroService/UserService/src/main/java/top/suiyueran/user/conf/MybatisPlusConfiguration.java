package top.suiyueran.user.conf;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 2:11 2019/11/9
 * @Modifyed by:
 */
@Configuration
@MapperScan("top.suiyueran.user.mapper.*")
public class MybatisPlusConfiguration {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
