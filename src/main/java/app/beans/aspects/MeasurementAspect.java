package app.beans.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MeasurementAspect {

    @Around("@annotation(app.annotations.BasicMeasurement) || @target(app.annotations.BasicMeasurement)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();

        Object proceed = joinPoint.proceed();

        long executionTime = System.nanoTime() - start;

        System.out.println("BasicMeasurement: " + joinPoint.getSignature().getName()
                + " executed in " + executionTime + "ms");
        return proceed;
    }
}
