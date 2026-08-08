package lk.rasheeda.ee.interceptor;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.interceptor.AroundConstruct;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

public class TestInterceptor {

    @AroundConstruct
    public void AroundConstruct(InvocationContext ic){
        System.out.println("TestInterceptor AroundConstruct");
    }

    public TestInterceptor() {
        System.out.println("TestInterceptor constructor");
    }

    @PostConstruct
    public void init(InvocationContext invocationContext) throws Exception {
        System.out.println("TestInterceptor init");
        invocationContext.proceed();
    }

    @AroundInvoke
    Object m(InvocationContext invocationContext) throws Exception {
        System.out.println("TestInterceptor m() start...");
        Object proceed = invocationContext.proceed();
        System.out.println("TestInterceptor m() end...");
        return proceed;
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("TestInterceptor preDestroy");
    }

}
