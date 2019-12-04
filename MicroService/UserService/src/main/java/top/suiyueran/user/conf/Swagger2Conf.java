package top.suiyueran.user.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 22:31 2019/12/3
 * @Modifyed by:
 */
@Configuration
@EnableSwagger2
public class Swagger2Conf {
    private static final String SWAGGER_SCAN_BASE_PACKAGE = "top.suiyueran.user.controller";
    private static final String VERSION = "1.0";

    /**
     * @return Docket
     * @Desc 配置RESTAPI接口文档页面
     * @Author zyw
     * @Date 2019年6月28日下午1:08:07
     */
    @Bean
    public Docket createRestApi() {
        // 添加head参数start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList();
        tokenPar.name("Authorization").description("授权").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        // 添加head参数end
        // api接口包扫描路径
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .paths(PathSelectors.any())
                // globalOperationParameters添加header
                .build().globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        // 设置文档的标题
        return new ApiInfoBuilder().title("邹耀文项目指挥RESTAPI接口文档")
                //设置文档的描述->1.Overview
                .description("更多内容请咨询：riverflowinyou@126.com")
                // 设置文档的版本信息-> 1.1 Version information
                .version(VERSION)
                // 设置文档的联系方式->1.2
                .contact(new Contact("邹耀文项目", "http://www.baidu.com", "riverflowinyou@126.com"))
                // Contact information,设置文档的License信息->1.3
                .termsOfServiceUrl("top.suiyueran.improvisation")
                // License information
                .title("营区指挥RESTAPI接口文档").build();
    }

}
