package lk.rasheeda.ee.interceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import lk.rasheeda.ee.annotation.Logged;

@Logged
@Interceptor
public class LoggingInterceptor {
    @AroundInvoke
    public Object Intercept(InvocationContext ctx) throws Exception {
        System.out.println("Logging Intercepter start...");
        Object proceed = ctx.proceed();
        System.out.println("Logging Intercepter end...");
        return proceed;
    }
}
