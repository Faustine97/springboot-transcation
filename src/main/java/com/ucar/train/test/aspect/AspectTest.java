package com.ucar.train.test.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

@Aspect
@Component
public class AspectTest {
    @Pointcut("execution(public * com.ucar.train.test.controller.LoginController.*(..))")
    private void cutMethod() {

    }

    @Before("cutMethod()")
    public void begin() {
      //  HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();//获取request
//        String url =
        System.out.println("==@Before== lingyejun blog logger : begin");
    }

    @AfterReturning("cutMethod()")
    public void afterReturning() {
        System.out.println("==@AfterReturning== lingyejun blog logger : after returning");
    }

    @After("cutMethod()")
    public void after() {
        System.out.println("==@After== lingyejun blog logger : finally returning");
    }

}
