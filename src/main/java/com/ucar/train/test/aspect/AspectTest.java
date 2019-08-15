package com.ucar.train.test.aspect;
import com.ucar.train.test.function.MyLog;
import com.ucar.train.test.vo.SysLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.sql.Time;
import java.sql.Timestamp;

@Aspect
@Component
public class AspectTest {

//    @Pointcut("execution(public * com.ucar.train.test.controller.*.*(..))")
    Timestamp start;
    Timestamp end;
    @Pointcut("@annotation(com.ucar.train.test.function.MyLog)")
    private void cutMethod() {

    }

    @Before("cutMethod()")
    public void begin() {
        start = new Timestamp(System.currentTimeMillis());
        System.out.println("==@Before== start: " +start);
    }

//    @AfterReturning("cutMethod()")
//    public void afterReturning() {
//        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
//        HttpServletRequest request = sra.getRequest();
//
//        String url = request.getRequestURI();
//        System.out.println("==@AfterReturning== requestUrl: "+url);
//    }

    @After("cutMethod()")
    public void after(JoinPoint joinPoint) {


        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
//        获取操作
        MyLog myLog = method.getAnnotation(MyLog.class);
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        HttpSession session = request.getSession();
        int user_id = (Integer)session.getAttribute("user_id");
        String user_name = (String) session.getAttribute("user");
        end = new Timestamp(System.currentTimeMillis());
        long diff_time = end.getTime()-start.getTime();
        SysLog sysLog = new SysLog(user_id,user_name,myLog.operation(),start,end,diff_time,myLog.result());
        System.out.println(sysLog);
    }


}
