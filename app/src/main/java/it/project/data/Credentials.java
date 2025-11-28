package it.project.data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Credentials {

    public record Account(String password, String privilege) {}
    private final HashMap<String,Account> accounts = new HashMap<>();

    public Credentials() {
        accounts.put("admin", new Account("admin", "ADMIN"));
        accounts.put("user", new Account("user", "STANDARD"));
    }

    public Map<String, Account> getAccounts() {
        return Collections.unmodifiableMap(accounts);
    }
}
