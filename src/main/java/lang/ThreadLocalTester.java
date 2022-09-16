package lang;

/**
 * @author dc.wang <dc.wang@idiaoyan.com>
 * @version V1.0
 * @date 2022/9/8 15:19
 */
public class ThreadLocalTester {

    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    void test(){
        threadLocal.set(123);
    }

}
