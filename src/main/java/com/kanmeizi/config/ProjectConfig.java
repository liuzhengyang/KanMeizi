package com.kanmeizi.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * JavaConfig配置类
 * Created by liuzhengyang on 2014/11/26.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.kanmeizi.repository")
@Import(InfrastructureConfig.class)
public class ProjectConfig {
}
