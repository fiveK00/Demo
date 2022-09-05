package com.example.component;


/**
 * @author dc.wang <dc.wang@idiaoyan.com>
 * @version V1.0
 * @date 2022/8/15 17:41
 */
public class TestComponent {
    private final String testProperties;

    public TestComponent(String properties){
        this.testProperties = properties;
    }

    @Override
    public String toString() {
        return "TestComponent{" +
                "testProperties='" + testProperties + '\'' +
                '}';
    }
}
