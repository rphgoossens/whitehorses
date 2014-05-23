package nl.whitehorses.acm.security;

import java.io.Serializable;

public class Credentials implements Serializable {

    @SuppressWarnings("compatibility:-3840918952265886511")
    private static final long serialVersionUID = -8734980940041776002L;

    private final String username;
    private final String password;

    public Credentials(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
