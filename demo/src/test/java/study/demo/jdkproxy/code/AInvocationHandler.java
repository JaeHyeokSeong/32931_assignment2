package study.demo.jdkproxy.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@RequiredArgsConstructor
@Slf4j
public class AInvocationHandler implements InvocationHandler {

    private final Object target;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("proxy begin");
        Object result = method.invoke(target, args);
        log.info("proxy end");
        return result;
    }
}
