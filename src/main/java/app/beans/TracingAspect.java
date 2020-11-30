package app.beans;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class TracingAspect {
    @Before("@annotation(app.annotations.LevSampleAnnotation)||@target(app.annotations.LevSampleAnnotation)")
    public void logFunc(JoinPoint jp) {
        System.out.println(jp.getSignature().getName() + " called at " + new Date());
    }
}
