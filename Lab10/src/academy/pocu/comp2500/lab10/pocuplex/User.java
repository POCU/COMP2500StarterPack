package academy.pocu.comp2500.lab10.pocuplex;

public final class User {
    private final String username;
    private final String password;

    public User(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
