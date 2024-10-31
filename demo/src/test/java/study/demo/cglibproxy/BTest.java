package study.demo.cglibproxy;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import study.demo.cglibproxy.code.B;
import study.demo.cglibproxy.code.BMethodInterceptor;

import static org.assertj.core.api.Assertions.*;

@Slf4j
class BTest {

    @Test
    void cglib() {
        //given
        B target = new B();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(B.class);
        enhancer.setCallback(new BMethodInterceptor(target));
        B proxy = (B) enhancer.create();

        //when
        String result = proxy.call();

        //then
        assertThat(result).isEqualTo("B.call()");
        log.info("proxy class={}", proxy.getClass());
    }
}