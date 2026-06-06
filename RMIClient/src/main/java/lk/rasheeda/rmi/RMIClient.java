package lk.rasheeda.rmi;

import lk.rasheeda.rmi.client.Message;
import lk.rasheeda.rmi.client.UserService;
import lk.rasheeda.rmi.model.Data;
import lk.rasheeda.rmi.model.User;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry("localhost",6666);
            String[] list = registry.list();

            for (String str : list) {
                System.out.println(str);
            }

//            Message massage =(Message) registry.lookup("message_service");
//            java.lang.String msg = massage.hello();
//            lk.rasheeda.rmi.model.Data data = massage.getData();
//
//            System.out.println(data.getId());
//            System.out.println(data.getName());
//
//            System.out.println(msg);
//
//             java.lang.String result = massage.getResult(10,20);
//             System.out.println(result);

            lk.rasheeda.rmi.client.UserService userService
                    = (UserService) registry.lookup("user_service");
            userService
                    .addUser(1,new User(1,"Rasheeda","Colombo","Rasheeda@gmail.com"));

            userService.getAllUsers().forEach(user -> {
                System.out.println(user.getName());
            });



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
