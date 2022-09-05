package com.example.configuration;

import com.example.component.TestComponent;
import com.example.properties.TestProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author dc.wang <dc.wang@idiaoyan.com>
 * @version V1.0
 * @date 2022/8/15 17:56
 */

@Configuration
@EnableConfigurationProperties(TestProperties.class)
public class TestConfiguration {

    @Bean
    @ConditionalOnMissingBean(TestComponent.class)
    public TestComponent testComponent(TestProperties properties){
        return new TestComponent(properties.toString());
    }

}
