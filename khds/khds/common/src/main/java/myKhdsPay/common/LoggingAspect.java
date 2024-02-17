package myKhdsPay.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final LongingProducer longingProducer;

    public LoggingAspect(LongingProducer longingProducer) {
        this.longingProducer = longingProducer;
    }

    @Before("execution(* myKhdsPay.*.adaptor.in.web.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        longingProducer.sendMessage("logging", "Before executing method: " + methodName);
    }

}
