package lk.rasheeda.ee.ejb;

import jakarta.ejb.Stateless;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.Interceptors;
import lk.rasheeda.ee.interceptor.TestInterceptor;

@Stateless
@Interceptors(TestInterceptor.class)
public class UserSessionBean {

    public String doAction(String name, int age) {

        System.out.println("UserSessionBean doAction Start...");

        System.out.println("UserSessionBean doAction : " + name + " | " + age);

        System.out.println("UserSessionBean doAction End...");


        return "Success";

    }

}
