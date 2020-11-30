package app.beans.aspects;

import app.annotations.BasicAuthorization;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthorizationAspect {

    @Before("@annotation(app.annotations.BasicAuthorization)")
    public void auth(JoinPoint joinPoint) {
        BasicAuthorization authorization = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(BasicAuthorization.class);
        System.out.println("BasicAuthorization: Access Authorized, policy - " +  authorization.policyName());
    }

    /* my (not working) try
    @Before("@target(app.annotations.BasicAuthorization)&&@annotation(basicAuthorization)")
    public void logFunc(JoinPoint jp, BasicAuthorization basicAuthorization) {
        System.out.println("Access balance authorized " + jp.getSignature().getName()
                + " with policy: "+ basicAuthorization.policyName());
    }*/
}
