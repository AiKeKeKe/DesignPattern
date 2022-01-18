package com.aike.behavioralpatterns.chainofresponsibility;

/**
 * 用户登录信息检查
 */
public class UserExistsMiddleware extends Middleware {
    private Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    @Override
    public boolean check(String userName, String password) {
        System.out.println("UserExistsMiddleware");
        if (!server.hasUserName(userName)) {
            System.out.println("This userName is not registered!");
            return false;
        }
        if (!server.isValidPassword(userName, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(userName, password);
    }
}
