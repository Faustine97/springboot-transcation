//package com.ucar.train.test.config;
//
//import com.ucar.train.test.intercepors.MyInterceptor;
//import  com.ucar.train.test.intercepors.MyInterceptorTwo;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//public class InterceptorConfig implements WebMvcConfigurer {
//
//    private MyInterceptor myInterceptor;
//
//    private MyInterceptorTwo myInterceptorTwo;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(myInterceptorTwo).addPathPatterns("/**");
//        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
//    }
//}