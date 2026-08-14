package lk.rasheeda.web;

import lk.rasheeda.web.util.JwtUtil;

import java.util.Set;

public class Test {

    public static void main(String[] args) {
//        String token = JwtUtil.genrateToken("Rasheeda", Set.of("Admin", "User"));
//        System.out.println(token);

        boolean valid =
                JwtUtil.isValid("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJSYXNoZWVkYSIsInJvbGVzIjpbIlVzZXIiLCJBZG1pbiJdLCJpYXQiOjE3ODY3Mjc3MzQsImV4cCI6MTc4NjczMTMzNH0.EW8N_LAFsyMj-kEHGqab5EMpjPlvn7haoemYRVybQdI");
        System.out.println(valid);

    }

}
