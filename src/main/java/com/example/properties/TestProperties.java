package com.example.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author dc.wang <dc.wang@idiaoyan.com>
 * @version V1.0
 * @date 2022/8/15 17:43
 */
@ConfigurationProperties("test")
public class TestProperties {
    private String name;
    private String context;

    public String getContext() {
        return context;
    }

    public String getName() {
        return name;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestProperties{" +
                "name='" + name + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
