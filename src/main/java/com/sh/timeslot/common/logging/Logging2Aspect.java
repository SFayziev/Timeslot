package com.sh.timeslot.common.logging;



import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Marker;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Aspect
@Configuration
@Slf4j
public class Logging2Aspect {


//    @Before(value = "@within(tsLog) "  ) // @annotation(loginValidator)
//    public void beforeClass(JoinPoint joinPoint, TSLog tsLog) {
//        validate(joinPoint, tsLog, null);
//    }

//    @Around(value =  "@annotation(tsLog) ")
//    public void beforeMethod(JoinPoint joinPoint, TSLog tsLog) {
//        validateBefore(joinPoint, tsLog, null);
//    }

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


    /**
     * Validate current login with loginValidator annotation's  params
     * @param tsLog {@link com.sh.timeslot.common.logging.TSLog}
     */
    public void validateBefore (JoinPoint joinPoint, TSLog tsLog ,  Throwable e) {
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
        if (log.isDebugEnabled()) {
            log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        }
        try {
            Object result = joinPoint.proceed();
            if (log.isDebugEnabled()) {
                log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName(), result);
            }
            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());

            throw e;
        }

    }

}
