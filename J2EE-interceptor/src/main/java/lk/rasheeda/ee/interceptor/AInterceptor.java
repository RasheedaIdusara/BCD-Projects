package lk.rasheeda.ee.interceptor;

import jakarta.annotation.PostConstruct;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

public class AInterceptor {

    @PostConstruct
    public void init(InvocationContext ic) throws Exception {
        System.out.println("AInterceptor init");
        ic.proceed();
    }

    @AroundInvoke
    public Object m(InvocationContext ic) throws Exception {

        System.out.println("AInterceptor m start");
        java.lang.Object proceed = ic.proceed();
        System.out.println("AInterceptor m end");
        return proceed;

    }

}
