package com.sh.timeslot.common.logging;



import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Aspect
@Configuration
@Slf4j
public class Logging2Aspect {


    @Around(value =  "@annotation(tsLog) ")
    public Object afterMethod(ProceedingJoinPoint  joinPoint, TSLog tsLog) throws Throwable {
        return validateAfter(joinPoint, tsLog);
    }

    /**
     * Advice that logs methods throwing exceptions.
     *
     * @param joinPoint join point for advice
     * @param e exception
     */
    @AfterThrowing(value = "@annotation(tsLog)", throwing = "e")
    public void logAfterThrowing(JoinPoint  joinPoint, TSLog tsLog, Throwable e) {

        validateBefore(joinPoint, tsLog, e);
    }


    private Logger getLogger( JoinPoint joinPoint){


        try {
            return LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        }
        catch (Exception ignore) {

        }
        return log;
    }
    /**
     * Validate current login with loginValidator annotation's  params
     * @param tsLog {@link com.sh.timeslot.common.logging.TSLog}
     */
    public void validateBefore (JoinPoint joinPoint, TSLog tsLog ,  Throwable e) {
        Logger log = getLogger(joinPoint);
        if (e!= null) {
            log.error("Exception in {}.{}() with cause = \'{}\' and exception = \'{}\'", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), e.getCause() != null? e.getCause() : "NULL", e.getMessage(), e);
        }
        else {
            log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        }
    }

    /**
     * Validate current login with loginValidator annotation's  params
     * @param tsLog {@link com.sh.timeslot.common.logging.TSLog}
     */
    public Object validateAfter (ProceedingJoinPoint  joinPoint, TSLog tsLog ) throws Throwable {
        Logger log = getLogger(joinPoint);
        if (log.isDebugEnabled()) {
            log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getName(),
                    joinPoint.getSignature().toShortString() , Arrays.toString(joinPoint.getArgs()));
        }
        try {
            Object result = joinPoint.proceed();
            if (log.isDebugEnabled()) {
                log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getName(),
                        joinPoint.getSignature().toShortString(), result);
            }
            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().toShortString(), joinPoint.getSignature().getName());

            throw e;
        }

    }

}
