package util.function;

import java.util.function.Consumer;

/**
 * @author dc.wang <dc.wang@idiaoyan.com>
 * @version V1.0
 * @date 2022/9/6 18:28
 */
public class ConsumerTester {
    private Consumer<Integer> integerConsumer = System.out::println;

    public void test(Integer integer){

        integerConsumer.accept(integer);
    }
}

interface MyConsumer<T> extends Consumer<T>{

}
