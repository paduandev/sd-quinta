package builder;

import builder.User.UserBuilder;

public class AppBuilder {
    public static void main(String[] args) {
        User u = new UserBuilder("Emerson")
                .id(123)
                .email("emerson@tec.com")
                .phone("1198765432")
                .build();
        System.out.println(u);
    }
}
