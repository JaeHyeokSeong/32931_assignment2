package study.demo.jdkproxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import study.demo.jdkproxy.code.AImpl;
import study.demo.jdkproxy.code.AInterface;
import study.demo.jdkproxy.code.AInvocationHandler;

import java.lang.reflect.Proxy;

import static org.assertj.core.api.Assertions.*;

@Slf4j
class AImplTest {

    @Test
    void jdk() {
        //given
        AImpl target = new AImpl();
        AInvocationHandler handler = new AInvocationHandler(target);
        AInterface proxy = (AInterface)
                Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);

        //when
        String result = proxy.call();

        //then
        assertThat(result).isEqualTo("AImpl.call()");
        log.info("target class={}", target.getClass());
        log.info("proxy class={}", proxy.getClass());
    }
}