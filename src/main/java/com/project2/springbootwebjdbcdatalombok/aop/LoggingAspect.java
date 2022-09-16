package com.project2.springbootwebjdbcdatalombok.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggingAspect 
{
  private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
   
  @Around("execution(* com.project2.springbootwebjdbcdatalombok..*(..)))")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable 
    {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
          
        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
          
        final StopWatch stopWatch = new StopWatch();
          
        //Measure method execution time
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
  
        //Log method execution time
        LOGGER.info("Execution time of " + className + "." + methodName + " "
                  + ":: " + stopWatch.getTotalTimeMillis() + " ms");
  
        return result;
    }
}
