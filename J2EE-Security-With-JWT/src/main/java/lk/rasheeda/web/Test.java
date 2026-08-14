package lk.rasheeda.web;

import lk.rasheeda.web.util.JwtUtil;

import java.util.Set;

public class Test {

    public static void main(String[] args) {
        String token = JwtUtil.genrateToken("Rasheeda", Set.of("Admin", "User"));
        System.out.println(token);
    }

}
