package com.aike.behavioralpatterns.chainofresponsibility;

public class Client {
    public static void main(String[] args) {
        Server server = new Server();
        server.register("admin", "123456");
        Middleware middleware = new ThrottlingMiddleware(2);
        middleware.linkWith(new UserExistsMiddleware(server)).linkWith(new RoleCheckMiddleware());
        server.setMiddleware(middleware);
        boolean success = server.login("admin", "123456");
        System.out.println(success);
    }
}
