package com.aike.behavioralpatterns.chainofresponsibility;

import java.util.HashMap;
import java.util.Map;

public class Server {
    private Map<String, String> users = new HashMap<>();

    private Middleware middleware;

    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    public boolean login(String userName, String password) {
        return middleware.check(userName, password);
    }

    public void register(String userName, String password) {
        users.put(userName, password);
    }

    public boolean hasUserName(String userName) {
        return users.containsKey(userName);
    }

    public boolean isValidPassword(String userName, String password) {
        return users.get(userName).equals(password);
    }
}
