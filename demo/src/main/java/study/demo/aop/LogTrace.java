package study.demo.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class LogTrace {

    @Around("execution(* study.demo.web..*.*(..))")
    public Object logTrace(ProceedingJoinPoint joinPoint) throws Throwable {
        String signature = joinPoint.getSignature().toString();
        log.info("-> [{}]", signature);

        try {
            Object result = joinPoint.proceed();
            log.info("<- [{}]", signature);
            return result;
        } catch (Exception e) {
            log.info("<-X [{}]", signature);
            throw e;
        }
    }
}
