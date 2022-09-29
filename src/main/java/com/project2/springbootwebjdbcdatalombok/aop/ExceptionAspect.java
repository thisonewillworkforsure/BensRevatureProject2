package com.project2.springbootwebjdbcdatalombok.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@AfterThrowing(pointcut="execution(* com.project2.springbootwebjdbcdatalombok..*(..)))", throwing="ex")
    public void logAllExceptionMethods(JoinPoint proceedingJoinPoint, Exception ex) throws Throwable 
    {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        LOGGER.error("Exception at " + methodName + " in " + className);
        LOGGER.error(ex.getMessage());
    }
}
