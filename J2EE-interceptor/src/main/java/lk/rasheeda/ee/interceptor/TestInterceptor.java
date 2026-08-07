package lk.rasheeda.ee.interceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

public class TestInterceptor {

    @AroundInvoke
    Object m(InvocationContext invocationContext) throws Exception {
        System.out.println("TestInterceptor m() start...");
        Object proceed = invocationContext.proceed();
        System.out.println("TestInterceptor m() end...");
        return proceed;
    }

}
