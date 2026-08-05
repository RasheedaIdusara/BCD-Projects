package lk.rasheeda.ee;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/test",asyncSupported = true)
public class test extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Start:"+Thread.currentThread().getName());

        AsyncContext async = request.startAsync();

        async.start(()->{
            for (int i = 0; i < 10; i++) {

                System.out.println(Thread.currentThread().getName() + i);

                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }

            async.complete();
        });

        System.out.println("End:"+Thread.currentThread().getName());




    }
}
