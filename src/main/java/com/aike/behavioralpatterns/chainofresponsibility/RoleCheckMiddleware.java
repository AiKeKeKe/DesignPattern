package com.aike.behavioralpatterns.chainofresponsibility;

/**
 * 用户角色检查
 */
public class RoleCheckMiddleware extends Middleware {

    @Override
    public boolean check(String userName, String password) {
        System.out.println("RoleCheckMiddleware");
        if (userName.equals("admin")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(userName, password);
    }
}
