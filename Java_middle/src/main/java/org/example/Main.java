package org.example;

import lombok.*;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Ramazan", "ramazan@test.com", 25);

        user1.setAge(26);

        User user2 = User.builder()
                .id(2)
                .name("Ramazan QA")
                .email("pro@test.com")
                .age(30)
                .build();

        System.out.println("User 1: " + user1);
        System.out.println("User 2: " + user2);
    }
}


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
class User {
    private long id;
    private String name;
    private String email;
    private int age;
}