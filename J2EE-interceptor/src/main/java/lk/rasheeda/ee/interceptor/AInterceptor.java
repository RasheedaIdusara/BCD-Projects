package lk.rasheeda.ee.interceptor;

import jakarta.interceptor.InvocationContext;

public class AInterceptor {

    public Object m(InvocationContext ic) throws Exception {

        System.out.println("AInterceptor m start");
        java.lang.Object proceed = ic.proceed();
        System.out.println("AInterceptor m end");
        return proceed;

    }

}
