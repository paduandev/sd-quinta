package builder;

public class User {
    private String name, email, phone;
    private int id;

    private User(UserBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
        this.id = builder.id;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", id=" + id + ", name=" + name + ", phone=" + phone + "]";
    }

    public static class UserBuilder {
        private String name, email, phone;
        private int id;

        public UserBuilder(String name) {
            this.name = name;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder id(int id) {
            this.id = id;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

}