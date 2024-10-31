package study.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Slf4j
public class TimeTrace {

    @Around("execution(* study.demo.web.HelloController.*(..))")
    public Object timeTrace(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        Exception exception = null;
        String signature = joinPoint.getSignature().toString();

        long startTime = System.currentTimeMillis();
        log.info("-> [{}]", signature);

        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            exception = e;
            throw e;
        } finally {
            complete(startTime, exception, signature);
        }

        return result;
    }

    private void complete(long startTime, Exception e, String signature) {
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        if (e == null) {
            log.info("<- [{}], totalTime={}ms", signature, totalTime);
        } else {
            log.info("<- EXCEPTION [{}], totalTime={}ms", signature, totalTime);
        }
    }
}
