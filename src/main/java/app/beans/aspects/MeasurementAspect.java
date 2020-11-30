package app.beans.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MeasurementAspect {
    private long start;

    @Before("@annotation(app.annotations.BasicMeasurement)||@target(app.annotations.BasicMeasurement)")
    public void logBefore(JoinPoint jp) {
        start = System.nanoTime();
        System.out.println(jp.getSignature().getName() + " starting time: " + start);
    }

    @After("@annotation(app.annotations.BasicMeasurement)||@target(app.annotations.BasicMeasurement)")
    public void logAfter(JoinPoint jp) {
        long end = System.nanoTime();
        System.out.println(jp.getSignature().getName() + " finish time: " + end);
        System.out.println(jp.getSignature().getName() + " total time: " + (end - start));
    }
}
