package com.glinboy.sample.hibernateuuid.aop;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class MethodExecutionMetricsAspect {
    private final MeterRegistry meterRegistry;

    @Pointcut("execution(* com.glinboy.sample.hibernateuuid.web.rest..*(..))")
    private void controllerLayer() {
    }

    @Pointcut("execution(* com.glinboy.sample.hibernateuuid.service..*(..))")
    private void serviceLayer() {
    }

    @Pointcut("execution(* com.glinboy.sample.hibernateuuid.repository..*(..))")
    private void repositoryLayer() {
    }

    @Pointcut("controllerLayer() || serviceLayer() || repositoryLayer()")
    private void applicationLayers() {
    }

    @Around("applicationLayers()")
    public Object measureMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        String layer = determineLayer(joinPoint);
        Timer timer = Timer.builder("method_execution_time")
            .tag("method", methodName)
            .tag("layer", layer)
            .description("Time taken to execute method")
            .register(meterRegistry);
        try {
            return timer.record(() -> {
                try {
                    return joinPoint.proceed();
                } catch (Throwable throwable) {
                    throw new RuntimeException(throwable);
                }
            });
        } catch (Exception ex) {
            meterRegistry.counter("method_execution_errors",
                    "method", methodName, "layer", layer)
                .increment();
            throw ex;
        }
    }

    private String determineLayer(ProceedingJoinPoint joinPoint) {
        return switch (joinPoint.getSignature().getDeclaringTypeName()) {
            case String s when s.startsWith("com.glinboy.sample.hibernateuuid.web.rest.") -> "Controller";
            case String s when s.startsWith("com.glinboy.sample.hibernateuuid.service.") -> "Service";
            case String s when s.startsWith("com.glinboy.sample.hibernateuuid.repository.") ||
                s.startsWith("org.springframework.data.repository") -> "Repository";
            default -> "Unknown";
        };
    }
}
